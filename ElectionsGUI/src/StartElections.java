import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;



public class StartElections extends JPanel {
	//JLabel cand1 = new  JLabel("Candidate1: Kavya");
	//JLabel cand2 = new  JLabel("Candidate2: Michelle");
	//JLabel cand3 = new  JLabel("Candidate3: Kelli");
	JButton stElect = new JButton("Welcome to 2017 Elections");
	//Elections event;
	public StartElections(){
	
		setLayout(new BorderLayout());
		//add(cand1, BorderLayout.NORTH);
		//add(cand2,BorderLayout.CENTER);
		//add(cand3,BorderLayout.WEST);
		add(stElect, BorderLayout.CENTER);
		ButtonHandler handler = new ButtonHandler();
		stElect.addActionListener(handler);
	
	}
	class ButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == stElect){
				removeAll();
                JPanel newPanel= new ElectionType();
                add(newPanel);
                revalidate();
			}
			
		}
		
	}

}
