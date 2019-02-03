package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	JFrame jf;
	JPanel jp;
	JButton jb;
	ArrayList<String> songs = new ArrayList<String>();
	Song son;
	int i;
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.					
		
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		songs.add("Chopin - Spring Waltz.mp3");
		songs.add("Chopin-Nocturne.mp3");
		songs.add("MoonlightSonata.mp3");
		songs.add("claudeDebussy-ClairDeLune.mp3");
		i = songs.size();
		jf = new JFrame();	
		jp = new JPanel();	
		jb = new JButton();
		
		jb.addActionListener(this);
		jb.setText("Suprise Me!");
		
		jp.add(jb);
		jf.add(jp);
		
		jf.setVisible(true);
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jb) {
			if(i != songs.size()) {
				son.stop();
			}
			Random r = new Random();
			i = r.nextInt(songs.size());
			System.out.println(i);
			son = new Song(songs.get(i));
			son.play();
		}
	}
}