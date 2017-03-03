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



public class AddElections extends JPanel {
	JLabel selElc = new JLabel("Select Elections"); 
	ElectionsDAO dao = new ElectionsDAO();
	JComboBox electionType;
    //ArrayList<Elections> electionList = dao.getAllElections();
    JTextArea cand1 = new JTextArea(5,15);
    JTextArea cand2 = new JTextArea(5,15);
    JTextArea cand3 = new JTextArea(5,15);
	//JCheckBox cand1 = new JCheckBox();
	//JCheckBox cand2 = new JCheckBox();
	//JCheckBox cand3 = new JCheckBox();
	JButton submit = new JButton(" Add Election and Candidates");
	JButton back = new JButton("Back for result");
	//private int candidate1Count;
	//private int candidate2Count;
	//private int candidate3Count;
	Elections event;
	
	public AddElections(){
        
         
         setLayout(new BorderLayout());
 		
         selElc.setFont(new Font("Serif", Font.PLAIN, 16));
 		setMinimumSize(new Dimension(400,250));
         
         System.out.println("Test");
 		HashSet<String> uniqueElectionNames = dao.getUniqueElectionName();
 		
 		String[] electionName = new String[uniqueElectionNames.size()];
 		uniqueElectionNames.toArray(electionName);
 		System.out.println(uniqueElectionNames);
 		electionType = new JComboBox<String>(electionName);
 		
 		
 		//setMinimumSize(new Dimension(400,250));
 		
 		StringBuilder sb = new StringBuilder();
 		for(String a: dao. getCurrentElectionsFromTable(electionName[0])){
 			sb.append(a + "\n");
 		}
 		cand1.setText(sb.toString());
		//list.append("Text from store will go here");
		cand1.setLineWrap(true);
	    cand1.setEditable(true);
	    cand1.setVisible(true);
 		  setLayout(new BorderLayout());
 			add(selElc, BorderLayout.NORTH);
 			add(electionType, BorderLayout.WEST);
 			add(cand1, BorderLayout.CENTER);
 			add(back, BorderLayout.SOUTH);
 			add(submit, BorderLayout.SOUTH);
 			cand2.setText(sb.toString());
 			//list.append("Text from store will go here");
 			cand2.setLineWrap(true);
 		    cand2.setEditable(true);
 		    cand2.setVisible(true);
 	 		  setLayout(new BorderLayout());
 	 			add(selElc, BorderLayout.NORTH);
 	 			add(electionType, BorderLayout.WEST);
 	 			add(cand2, BorderLayout.CENTER);
 	 			add(back, BorderLayout.SOUTH);	
 	 			add(submit, BorderLayout.SOUTH);
 	 		cand3.setText(sb.toString());
 	 			//list.append("Text from store will go here");
 	 			cand3.setLineWrap(true);
 	 		    cand3.setEditable(true);
 	 		    cand3.setVisible(true);
 	 	 		  setLayout(new BorderLayout());
 	 	 			add(selElc, BorderLayout.NORTH);
 	 	 			add(electionType, BorderLayout.WEST);
 	 	 			add(cand3, BorderLayout.CENTER);
 	 	 			add(back, BorderLayout.SOUTH);
 	 	 			add(submit, BorderLayout.SOUTH);
		ButtonandComboBoxListener e = new ButtonandComboBoxListener();
		submit.addActionListener(e);
		back.addActionListener(e);
		electionType.addActionListener(e);
		//elecSel.addActionListener(e);
		//elecSel.addItem("Presidential Elections");
		//elecSel.addItem("Homecoming Queen");
		//elecSel.addItem("Senate");
		
		selElc.setFont(new Font("Serif", Font.PLAIN, 16));
		add(selElc, BorderLayout.NORTH);
		
		/*
	    JPanel electionLabel = new JPanel(new GridLayout(2,2));
		JPanel electionsel = new JPanel(new GridLayout(2,2));
		JPanel candSel = new JPanel(new GridLayout(3,3));
		electionLabel.add(selElc);
		//electionsel.add(elecSel);
		//candSel.add(cand1);
		//candSel.add(cand2);
		//candSel.add(cand3);
		add(electionLabel, BorderLayout.WEST);
		add(electionsel, BorderLayout.CENTER);
		add(candSel, BorderLayout.EAST);
		
		
		
		
		    JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
			buttonPanel.add(submit);
			buttonPanel.add(back);
			add(buttonPanel, BorderLayout.SOUTH);
			
			*/


		
	}
	
	class ButtonandComboBoxListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			String s = electionType.getSelectedItem().toString();
			StringBuilder sb = new StringBuilder();
			for(String a: dao.getCurrentElectionsFromTable(s)){
				sb.append(a + "\n");
			}
		    cand1.setText(sb.toString());
			System.out.println(sb.toString());
			 cand2.setText(sb.toString());
				System.out.println(sb.toString());
			cand3.setText(sb.toString());
			 System.out.println(sb.toString());
			// TODO Auto-generated method stub
			//String numVotes = submit.getText();
			//int nV = Integer.parseInt(numVotes);
			/*if(e.getSource() == submit && e.getSource()==cand1)
				{
				event.candidate1VotesCount(candidate1Count);
				//System.out.print(event.candate1VotesCount(nV));
				
				
			}*/
				if (e.getSource() == submit) {
					System.out.println("Add new item to database");
					
					String tempElection;
					
					tempElection = electionType.getSelectedItem().toString();
					String tempCand1 = cand1.getText();
					String tempCand2 = cand2.getText();
					String tempCand3 = cand3.getText();
					int tempCand1Vote = 0;
					int tempCand2Vote = 0;
					int tempCand3Vote = 0;
					
					
					Elections i= new Elections(tempElection, tempCand1, tempCand2, tempCand3, tempCand1Vote, tempCand2Vote, tempCand3Vote );
					ElectionsDAO dao = new ElectionsDAO();
					dao.insertNewElection(i);
					electionType.setEditable(false);
					
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

