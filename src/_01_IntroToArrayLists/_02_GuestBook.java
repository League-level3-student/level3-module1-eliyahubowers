package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class _02_GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names".
	JFrame jf;
	JPanel jp;
	JButton jb1;
	JButton jb2;
	JTextField jtf;
	ArrayList<String> names = new ArrayList<String>();
	public static void main(String[] args) {
		new _02_GuestBook().buttons();
	}
	
	public void buttons() {
		jf = new JFrame();
		jp = new JPanel();
		jb1 = new JButton("Add Name");
		jb2 = new JButton("View Names");
		jtf = new JTextField();
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		jtf.setText("There are no names");
		jtf.setEditable(false);
		
		jp.add(jb1);
		jp.add(jb2);
		jp.add(jtf);
		
		jf.add(jp);
		jf.setResizable(true);
		jf.pack();
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jb1)) {
			String s = JOptionPane.showInputDialog("put in a String");
			names.add(s);
		}else if(e.getSource().equals(jb2)) {
			String s = "";
			for(int i = 0; i < names.size(); i++) {
				s += "Guest #" + (i+1) +  ":  "+names.get(i) + "\n";		
			}
			JOptionPane.showMessageDialog(null, s);
			jtf.setText(s);
			jp.add(jtf);
			jf.add(jp);
		}
	}
	
	
	
}
