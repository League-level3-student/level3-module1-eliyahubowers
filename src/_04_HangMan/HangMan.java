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
	
	char ch = '~';
	
	boolean changeWordInGameScreen = true;
	boolean resetGameScreen = true;
	
	ArrayList<Boolean> b = new ArrayList();
	public static void main(String[] args) {
		new HangMan().Order();
	}
	
	void gameScreen(String s, int j,ArrayList<Boolean> bo) {
		f = new JFrame();
		p = new JPanel();
		l = new JLabel();
		
		String sl = "";
		
		for(int i = 0; i < s.length(); i++) {
			if(bo.get(i) == true) {
				sl += s.charAt(i);
			}else {
				sl += "_";
			}
		}
		
		l.setText(sl + "   Lives Remaining: " + j);
		
		p.add(l);
		
		f.add(p);
		f.pack();
		f.addKeyListener(this);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("HANGman");
		f.addKeyListener(this);
	}
	
	void Order() {
		int loop = 1;
		int lives = 10;
		String s = "";
		while(loop == 1) {
			if(jopon == 0) {
				input = inpuT();
			}if(input > 0 && input < 51) {
				jopon = 1;
			}if(jopon == 1) {
				HangWords = new Stack<String>();
				s= "";
				for(int i = 0; i < input; i++) {
					s = Utilities.readRandomLineFromFile("dictionary.txt");
					if(HangWords.contains(s) == false) {
					    HangWords.push(s);
					}else {
					    	i--;
					}
				}
				jopon = 2;
			}if(jopon == 2) {
				loop = 2;
				jopon = 0;
				lives = 10;
			}
		}
		System.out.println("got Input");
		while(loop == 2) {
			if(changeWordInGameScreen) {
				s = HangWords.pop();
				changeWordInGameScreen = false;
				b.clear();
				for(int i = 0; i < s.length(); i++) {
					b.add(false);
				}
			}			
			if (resetGameScreen == true){
				System.out.println(ch);
				if(ch != '~') {
					for(int i = 0; i < s.length(); i++) {
						if(s.charAt(i) == ch) {
							b.set(i, true);
						}
					}
				}
				gameScreen(s,lives,b);
				resetGameScreen = false;
			}
			
		}
	}
	
	public int inpuT() {
		int i = 0;
		String JOp = "111";
			while(i < 0||i > 50||JOp.length() > 2) {
				try{					
					JOp = JOptionPane.showInputDialog("Welcome to HANGMAN! \n Please enter a number Between 0 and 50 \n For how many words you would like to guess");
					i = Integer.parseInt(JOp);
					return i;
				}catch(NumberFormatException e) {
					error();
				}
			}
		return i;
	}
	
	void error() {
		JOptionPane.showMessageDialog(null, "Please enter a number between 0 & 50");
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
		char c = e.getKeyChar();
		ch = c;
		resetGameScreen = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
}
