import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;





public class AddElections extends JPanel {
	//JLabel title = new JLabel("Enter Election Name and candidates:");
	JLabel selElc = new JLabel("Enter Election Name:"); 
	JTextField newElecName = new JTextField(20);
	ElectionsDAO dao = new ElectionsDAO();

	JLabel candName1 = new JLabel("Candidate1:");
	JTextField cand1 = new JTextField(10);
    JLabel candName2 = new JLabel("Candidate2:");
    JTextField cand2 = new JTextField(10);
    JLabel candName3 = new JLabel("Candidate3:");
    JTextField cand3 = new JTextField(10);
    JButton submit = new JButton("Add");
	JButton back = new JButton("Back for results");

	Elections event;
	
	public AddElections(){
        
         
         setLayout(new BorderLayout());
 		 //System.out.println("Test");
 		 
 		ButtonListener b = new ButtonListener();
 		submit.addActionListener(b);
 		back.addActionListener(b);
 		
		JPanel electionNameLabel = new JPanel(new GridLayout(5,0));
		JPanel electionNameTextAreas = new JPanel(new GridLayout(5,0));
	
		
		electionNameLabel.add(selElc);
		
		electionNameTextAreas.add(newElecName);
		electionNameLabel.add(candName1);
		electionNameTextAreas.add(cand1);
		electionNameLabel.add(candName2);
		electionNameTextAreas.add(cand2);
		electionNameLabel.add(candName3);
		electionNameTextAreas.add(cand3);
		
	    add(electionNameLabel, BorderLayout.WEST);
	    add(electionNameTextAreas, BorderLayout.CENTER);
	    JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		buttonPanel.add(submit);
		buttonPanel.add(back);
		add(buttonPanel, BorderLayout.SOUTH);
		
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		
				if (e.getSource() == submit) {
					System.out.println("Add new item to database");
					
					String tempElection;
					//int tempElectionID =0;
					tempElection = newElecName.getText();
					String tempCand1 = cand1.getText();
					String tempCand2 = cand2.getText();
					String tempCand3 = cand3.getText();
					int tempCand1Vote = 0;
					int tempCand2Vote = 0;
					int tempCand3Vote = 0;
					
					
					Elections i= new Elections( tempElection, tempCand1, tempCand2, tempCand3, tempCand1Vote, tempCand2Vote, tempCand3Vote );
					ElectionsDAO dao = new ElectionsDAO();
					dao.insertNewElection(i);
					newElecName.setText("");
					
					cand1.setText("");
					cand2.setText("");
					cand3.setText("");
				}
			
			if(e.getSource() == back){
				removeAll();
                JPanel newPanel=new ElectionType();
                add(newPanel);
                revalidate();
                newPanel.repaint();
			
		}
		
	}
	
	


}
}

