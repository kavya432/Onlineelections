import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;



public class ElectionResults extends JPanel{
	Elections event;
	ElectionsDAO dao = new ElectionsDAO();
	ArrayList<Elections> electionList = dao.getAllElections();
	ArrayList<JLabel> elecResults = new ArrayList<JLabel>();
	ArrayList<JLabel> elecCount = new ArrayList<JLabel>();
	JButton back = new JButton("Main");
	ArrayList<Integer> vc = new ArrayList<Integer>();
	String eleName;
	
	

	public ElectionResults(String electionResults){
		//add(title);
		eleName=electionResults;
		JLabel title = new JLabel ("Results for Elections: " + " " + eleName);
		setLayout(new BorderLayout());
		title.setFont(new Font("Serif", Font.PLAIN, 16));
		setMinimumSize(new Dimension(400,250));
		JPanel candidateName = new JPanel(new GridLayout(3,0));
		JPanel candCount = new JPanel(new GridLayout(3,0));
		ButtonListener e = new ButtonListener();
		//electionName = electionResults;
		for(String a: dao. getCurrentElectionsFromTable(electionResults)){
			JLabel candNames = new JLabel(a);
			elecResults.add(candNames);
			candidateName.add(candNames);
			//box.addActionListener(e);

		}
		
		for(int b: dao.getCurrentElectionsCountFromTable(electionResults)){
			//vc.add(b);
			JLabel candVotes = new JLabel("");
			candVotes.setText(String.valueOf(b));
			elecCount.add(candVotes);
			candCount.add(candVotes);
			//System.out.println(b);
		}
		
		
		back.addActionListener(e);
        add(title, BorderLayout.NORTH);
		add(candidateName, BorderLayout.CENTER );
		add(candCount,BorderLayout.EAST);
		add(back,BorderLayout.SOUTH);
	}


	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {


			if(e.getSource() == back){
				removeAll();
				JPanel newPanel=new ElectionSelection();
				add(newPanel);
				revalidate();
				newPanel.repaint();
			}
		}
	}
}
