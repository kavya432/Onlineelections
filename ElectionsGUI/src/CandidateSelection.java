import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;





public class CandidateSelection extends JPanel{
	JLabel selElc = new JLabel("Vote Candidates"); 
	ElectionsDAO dao = new ElectionsDAO();
	ArrayList<Elections> electionList = dao.getAllElections();
	ArrayList<JRadioButton> radiobuttons = new ArrayList<JRadioButton>();
	ArrayList<Integer> vc = new ArrayList<Integer>();
	
	

	ButtonandRadioButtonListener e = new ButtonandRadioButtonListener();

	JButton submit = new JButton("vote");
	JButton back = new JButton("Back for results");
	Elections event;
	String electionName;
	

	public CandidateSelection(String selElection){
		setLayout(new BorderLayout());
		selElc.setFont(new Font("Serif", Font.PLAIN, 16));
		setMinimumSize(new Dimension(400,250));
		JPanel candidateName = new JPanel(new GridLayout(3,0));
		ButtonGroup group = new ButtonGroup();
		
        electionName = selElection;
		for(String a: dao. getCurrentElectionsFromTable(selElection)){
			JRadioButton box = new JRadioButton(a);
			radiobuttons.add(box);
			group.add(box);
			candidateName.add(box);
			box.addActionListener(e);
    	}
		for (int b: dao.getCurrentElectionsCountFromTable(selElection)){
			vc.add(b);
			}
		add(selElc, BorderLayout.NORTH);
		
		add(candidateName, BorderLayout.CENTER );
		submit.addActionListener(e);
		back.addActionListener(e);		
		selElc.setFont(new Font("Serif", Font.PLAIN, 16));
		add(selElc, BorderLayout.NORTH);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		buttonPanel.add(submit);
		buttonPanel.add(back);
		add(buttonPanel, BorderLayout.SOUTH);

	}

	class ButtonandRadioButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==submit){

				if (radiobuttons.get(0).isSelected()){ 
					
					String tempCand1 = radiobuttons.get(0).getText();
					String tempCand2 = radiobuttons.get(1).getText();
					String tempCand3 = radiobuttons.get(2).getText();
					int tempCand1Vote = vc.get(0) + 1;
					int tempCand2Vote = vc.get(1);
					int tempCand3Vote = vc.get(2);
                    System.out.println(tempCand1Vote);

					Elections oldItem = new Elections(electionName, tempCand1, tempCand2, tempCand3, tempCand1Vote, tempCand2Vote, tempCand3Vote );


					dao.updateVote1Count(oldItem);
				    
				}


				else if (radiobuttons.get(1).isSelected()){

					System.out.println(electionList.get(1).getCand1Vote());
					String tempCand1 = radiobuttons.get(0).getText();
					String tempCand2 = radiobuttons.get(1).getText();
					String tempCand3 = radiobuttons.get(2).getText();
					int tempCand1Vote = vc.get(0);
					int tempCand2Vote = vc.get(1) + 1;
					int tempCand3Vote = vc.get(2);
                    System.out.println(tempCand2Vote);

					Elections oldItem = new Elections(electionName, tempCand1, tempCand2, tempCand3, tempCand1Vote, tempCand2Vote, tempCand3Vote );


					dao.updateVote2Count(oldItem);

				}
				else if (radiobuttons.get(2).isSelected()){

					String tempCand1 = radiobuttons.get(0).getText();
					String tempCand2 = radiobuttons.get(1).getText();
					String tempCand3 = radiobuttons.get(2).getText();
					int tempCand1Vote = vc.get(0);
					int tempCand2Vote = vc.get(1);
					int tempCand3Vote = vc.get(2) + 1;
                    System.out.println(tempCand3Vote);

					Elections oldItem = new Elections(electionName, tempCand1, tempCand2, tempCand3, tempCand1Vote, tempCand2Vote, tempCand3Vote );
                    dao.updateVote3Count(oldItem);
					
				}

			}
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





