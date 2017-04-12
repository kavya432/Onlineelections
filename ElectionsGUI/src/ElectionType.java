import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ElectionType extends JPanel {
	
	JButton vote = new JButton("Vote in an Election");
	//JButton results = new JButton("Election Results");
	JButton add = new JButton("Add an Election");
	//JButton delete = new JButton("Delete an Election");
	public ElectionType (){
		
		add(vote);
		//add(results);
		add(add);
		//add(delete);
		
		VotesHandler handler = new VotesHandler();
		vote.addActionListener(handler);
		//results.addActionListener(handler);
		add.addActionListener(handler);
		//delete.addActionListener(handler);
		
		
		
		
		
		
	}
	class VotesHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent v) {
			if(v.getSource() == vote){
				removeAll();
                JPanel newPanel= new ElectionSelection();
                add(newPanel);
                revalidate();
			}
		/*	if(v.getSource() == results){
				removeAll();
                JPanel newPanel= new ElectionResults();
                add(newPanel);
                revalidate();
			}*/
			if(v.getSource() == add){
				removeAll();
                JPanel newPanel= new AddElections();
                add(newPanel);
                revalidate();
			
		    }
			/*if(v.getSource() == results){
				removeAll();
                JPanel newPanel= new DeleteElections();
                add(newPanel);
                revalidate();
	        }*/
		}
	}
		

}
