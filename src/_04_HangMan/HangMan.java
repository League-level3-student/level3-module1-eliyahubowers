package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener{
	
	JFrame f;
	JPanel p;
	JLabel l;
	
	int jopon = 0;
	
	int input = 10;
	
	ArrayList<String> strings;
	
	public static void main(String[] args) {
		new HangMan().joptionPanes();
		new HangMan().gameScreen();
	}
	
	void gameScreen() {
		f = new JFrame();
		p = new JPanel();
		l = new JLabel();
		
		p.add(l);
		
		f.add(p);
		f.pack();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("HANGman");
		f.addKeyListener(this);
	}
	
	void joptionPanes() {
		if(jopon == 0) {
			input = inpuT();
		}if(input > 0 && input < 51) {
			jopon = 1;
		}
		    
	}
	
	public int inpuT() {
		int i = 0;
		String s = JOptionPane.showInputDialog("Please enter a number Between 0 and 50");
		i = Integer.parseInt(s);
		return i;
	}
	
	void winLose() {
		
	}
	
	void playAgain() {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
				
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
}
