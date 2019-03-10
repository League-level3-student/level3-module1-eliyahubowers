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
	boolean doResetGameScreen = true;
	
	ArrayList<Boolean> b = new ArrayList();
	public static void main(String[] args) {
		new HangMan().Order();
	}
	
	void gameScreen() {
		f = new JFrame();
		p = new JPanel();
		l = new JLabel();
		
		p.add(l);
		
		f.add(p);
		
		f.pack();
		f.addKeyListener(this);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("HANGman");
	}
	
	void resetGameScreen(String s, int j, ArrayList<Boolean> bo) {
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
		
	}
	
	void Order() {
		
		boolean won = false;
		int lives = 10;
		int loop = 1;
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
				
				jopon = 0;
				lives = 10;               
				loop = 2;
				
				gameScreen();
				
			}
			
		}
		
		System.out.println("loop2");
		
		while(loop == 2) {
			
			System.out.print("");
			
			if(changeWordInGameScreen == true) {
				
				if(HangWords.isEmpty() == false) {
				
					s = HangWords.pop();
					changeWordInGameScreen = false;
             	    b.clear();
             	    lives = 10;
                
				}else{
					
					won = true;
					loop = 3;
					
				}
				
                for(int i = 0; i < s.length(); i++) {
                	
                		b.add(false);
					
			    }
                
			}	
			
			if (doResetGameScreen == true){
				
				if(ch != '~') {
					
					boolean check = false;
					
					for(int i = 0; i < s.length(); i++) {
						
						if(s.charAt(i) == ch) {
							
							b.set(i, true);
							check = true;
							
						}
						
					}
					
					if(check == false) {
						lives --;
					}
					
					ch = '~';
					
				}
				// runs screen
				resetGameScreen(s,lives,b);
				doResetGameScreen = false;
				//
				for(int i = 0; i < s.length(); i++) {
					
					if(b.get(i) != true) {
						i = s.length();
					}
					
					if(i == s.length()-1) {
						
						changeWordInGameScreen = true;
						
					}
					
				}
				
			}
			
			if(lives == 0) {
				
				won = false;
				loop = 3;
				
			}
			
		}
		
		while(loop == 3) {
			
			String ss = "";
			
			if(won == true) {
				
				ss = "You Won!!!";
				
			}else {
				
				ss = "You ran out of lives \nThe word was: " + s;
				
			}
			
			JOptionPane.showMessageDialog(null, ss);
			int continu = JOptionPane.showConfirmDialog(null, "continuePlaying ?");
			//cancel = 2 no = 1 yes = 0
			System.out.println(continu);
			
			if(continu == 0) {
				
				loop = 1;
				jopon = 0;
				
			}else{
				
				System.exit(0);
				
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

	@Override
	public void keyTyped(KeyEvent e) {
				
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char c = e.getKeyChar();
		ch = c;
		doResetGameScreen = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
}
