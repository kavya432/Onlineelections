import java.awt.BorderLayout;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;




public class ElectionSelection extends JPanel {
	JLabel selElc = new JLabel("Select Elections"); 
	ElectionsDAO dao = new ElectionsDAO();
	JComboBox electionType;
	ArrayList<Elections> electionList = dao.getAllElections();
	JButton submit = new JButton("Start Voting");
	JButton back = new JButton("Main");
	JButton results = new JButton("Results");

	Elections event;

	public ElectionSelection(){


		setLayout(new BorderLayout());

		selElc.setFont(new Font("Serif", Font.PLAIN, 30));
		setMinimumSize(new Dimension(400,250));

		System.out.println("Test");
		HashSet<String> uniqueElectionNames = dao.getUniqueElectionName();

		String[] electionName = new String[uniqueElectionNames.size()];

		uniqueElectionNames.toArray(electionName);
		System.out.println(uniqueElectionNames);
		electionType = new JComboBox<String>(electionName);
		setLayout(new BorderLayout());

		add(selElc, BorderLayout.NORTH);
		add(electionType, BorderLayout.WEST);
		//add(candidateName, BorderLayout.CENTER );


		ButtonandComboBoxListener e = new ButtonandComboBoxListener();
		submit.addActionListener(e);
		back.addActionListener(e);
		electionType.addActionListener(e);
		results.addActionListener(e);



		selElc.setFont(new Font("Serif", Font.PLAIN, 16));
		add(selElc, BorderLayout.NORTH);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		buttonPanel.add(submit);
		buttonPanel.add(back);
		buttonPanel.add(results);
		add(buttonPanel, BorderLayout.SOUTH);
	}

	class ButtonandComboBoxListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
            
			String selectedElection = electionType.getSelectedItem().toString();
			for(String a: dao.getCurrentElectionsFromTable(selectedElection)){
			System.out.println(a.toString());
			}
			for(int b: dao.getCurrentElectionsCountFromTable(selectedElection)){
				System.out.println(b);
			}

			if(e.getSource()==submit){

				removeAll();
				JPanel newPanel=new CandidateSelection(selectedElection);
				add(newPanel);
				revalidate();
				newPanel.repaint();
			}

			if(e.getSource() == back){
				removeAll();
				JPanel newPanel=new ElectionType();
				add(newPanel);
				revalidate();
				newPanel.repaint();

			}
			if(e.getSource() == results){
				removeAll();
				JPanel newPanel=new ElectionResults(selectedElection);
				add(newPanel);
				revalidate();
				newPanel.repaint();

			}

		}




	}
}


