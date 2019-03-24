package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener{
	HashMap<Integer,String> Hm = new HashMap();

	JFrame jf;
	JPanel jp;
	
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	
	public static void main(String[] args) {
		new _02_LogSearch().makeScreen();
	}
	
	void makeScreen() {
		jf = new JFrame();
		
		jp = new JPanel();
		
		b1 = new JButton();
		b2 = new JButton();
		b3 = new JButton();
		b4 = new JButton();
			
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		b1.setText("Add Entry");
		b2.setText("Search by ID");
		b3.setText("View List");
		b4.setText("Remove Entry");
		
		jp.add(b1);
		jp.add(b2);
		jp.add(b3);
		jp.add(b4);
		
		jf.add(jp);
		jf.setVisible(true);
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */

	@Override
	public void actionPerformed(ActionEvent e) {
		int i = 0;
		String s = "";
		if(e.getSource() == b1) {
		
			i = Integer.parseInt(JOptionPane.showInputDialog("Put in a ID Number"));
			s = JOptionPane.showInputDialog("Put in a Name");
			
			Hm.put(i, s);
			
			i = 0;
			s = "";
			
		}else if(e.getSource() == b2) {
			
			i = Integer.parseInt(JOptionPane.showInputDialog("Put in a ID Number"));
			
			if(Hm.containsKey(i)) {
				JOptionPane.showMessageDialog(null, "The value is: "+Hm.get(i));
			}else {
				JOptionPane.showMessageDialog(null, "This key doesn't exist");
			}
			
			i = 0;
			s = "";
			
		}else if(e.getSource() == b3) {
			
			ArrayList<Integer> Int = new ArrayList();
			ArrayList<String> Str = new ArrayList();
			
			for(String ss : Hm.values()){  Str.add(ss); }			
			for(Integer ii : Hm.keySet()){ Int.add(ii); }
			
			for(int j = 0; j < Hm.size(); j ++) {		
				s = s + "\n ID: "+ Int.get(j) +"  Name: "+ Str.get(j);
			}
			
			JOptionPane.showMessageDialog(null, s);
			
			i = 0;
			s = "";
			
			
		}else if(e.getSource() == b4) {
			
			i = Integer.parseInt(JOptionPane.showInputDialog("Put in a ID Number"));
			
			if(Hm.containsKey(i)) {
				Hm.remove(i);
				JOptionPane.showMessageDialog(null, "This key was removed");
			}else {
				JOptionPane.showMessageDialog(null, "This key doesn't exist");
			}
			
		}
	}
	
}
