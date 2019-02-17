package _03_IntroToStacks;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class _02_TextUndoRedo implements KeyListener{
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	JFrame Jf;
	JPanel Jp;
	JLabel Jl;
	
	Stack<String> Letters = new Stack<String>();
	public static void main(String[] args) {
		new _02_TextUndoRedo().TextField();
	}
	
	void TextField() {
		Jf = new JFrame();
		
		Jp = new JPanel();
			
		Jl = new JLabel();	
		
		Jl.setText("Type");
		
		Jp.add(Jl);
		Jf.add(Jp);
		
		Jf.setVisible(true);
		Jf.setTitle("TextTyper");
		Jf.addKeyListener(this);
		Jf.setPreferredSize(new Dimension(600, 400));
		Jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Jf.pack();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		String s = Jl.getText();
		String c = "";
	    if(e.getKeyCode() != KeyEvent.VK_BACK_SPACE && e.getKeyCode() != KeyEvent.VK_ENTER && e.getKeyCode() != KeyEvent.VK_CAPS_LOCK && e.getKeyCode() != KeyEvent.VK_SHIFT) {
			Jl.setText(s+e.getKeyChar());
			Jp.add(Jl);
			Jf.add(Jp);
			Jf.pack();
			System.out.println("hi");
		}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
		    System.out.println("ih");
			if(s.length() > 0) {
			    Letters.push(s.charAt(s.length()-1)+"");
			    c = s.substring(0, s.length()-1);
			    Jl.setText(c);
			}
		}else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(Letters.isEmpty() == false) {
			    c = Letters.pop();
			    Jl.setText(s+c);
			    Jp.add(Jl);
			    Jf.add(Jp);
			    Jf.pack();
			}
			System.out.println("hii");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub		
	}

}
