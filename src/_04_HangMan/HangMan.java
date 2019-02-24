package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

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
	
	Stack<String> HangWords;
	
	public static void main(String[] args) {
		new HangMan().Order();
	}
	
	void gameScreen(String s) {
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
	
	void Order() {
		int b = 1;
		while(b == 1) {
			if(jopon == 0) {
				input = inpuT();
			}if(input > 0 && input < 51) {
				jopon = 1;
			}if(jopon == 1) {
				HangWords = new Stack<String>();
				String s = "";
				boolean StackIn = false;
				for(int i = 0; i < input; i++) {
					while(StackIn == false) {
						System.out.println("hi");
					    s = Utilities.readRandomLineFromFile("dictionary.txt");
					    if(HangWords.contains(s) == false) {
					        HangWords.push(s);
					      	StackIn = true;
					    }
					}
				}
			}if(jopon == 2) {
				b = 2;
			}
		}
		System.out.println("got Input");
		while(b == 2) {
			for(int i = 0; i < HangWords.size(); i++) {
				System.out.println(HangWords.elementAt(i));
			}
		}
	}
	
	public int inpuT() {
		int i = 0;
		String s = "111";
			while(i < 0||i > 50||s.length() > 2) {
				try{					
					s = JOptionPane.showInputDialog("Welcome to HANGMAN \n Please enter a number Between 0 and 50 \n For how many words you would like to guess");
					i = Integer.parseInt(s);
					return i;
				}catch(NumberFormatException e) {
					error();
				}
			}
		return i;
	}
	
	void error() {
		JOptionPane.showMessageDialog(null, "please enter a number between 0 & 50");
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
