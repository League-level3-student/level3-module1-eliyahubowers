package _03_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
	public static void main(String[] args) {
		//1. Create a Stack of Doubles
		//   Don't forget to import the Stack class
		Stack<Double> numbers = new Stack<Double>();
		//2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		for(int i = 0; i < 100; i++) {
			double j = 0;
			Random r = new Random();
			j = r.nextInt(101);
			numbers.push(j);
		}
		//3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
		String si = JOptionPane.showInputDialog("put in a number between 0 and 100");
		String sj = JOptionPane.showInputDialog("put in another number between 0 and 100");
		
		int ii = Integer.parseInt(si); 
		int ij = Integer.parseInt(sj);
		double g = 0;
		int Num = 1;
		
		if(ii > 100)   {ii = 100;}
		else if(ii < 0){ii = 0;  }
		
		if(ij > 100)   {ij = 100;}
		else if(ij < 0){ij = 0;  }
		
		//4. Pop all the elements off of the Stack. Every time a double is popped that is
		//   between the two numbers entered by the user, print it to the screen.
		if(ii > ij) {
			for(int i = 0; i < numbers.size(); i ++) {
				g = numbers.pop();
				if(g < ii && g > ij) {
					System.out.println("NUM " + Num + ": " + g);
					Num++;
				}
			}
		}else if(ij != ii){
			for(int i = 0; i < numbers.size(); i ++) {
				g = numbers.pop();
				if(g > ii && g < ij) {
					System.out.println("NUM " + Num + ": " + g);
					Num++;
				}
			}
		}
		
		//   EXAMPLE:
		//   NUM 1: 65
		//   NUM 2: 75
		
		//   Popping elements off stack...
		//   Elements between 65 and 75:
		//   66.66876846
		//   74.51651681
		//   70.05110654
		//   69.21350456
		//   71.54506465
		//   66.47984807
		//   74.12121224
	}
}
