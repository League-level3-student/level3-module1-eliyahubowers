package _03_IntroToStacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class _03_TestMatchingBrackets {
	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String b) {
		Stack<String> Brackets = new Stack<String>();
		for(int i =0; i < b.length(); i++) {
			if(b.charAt(i) == '{') {
				Brackets.push("}");
			}else if(b.charAt(i) == '}') {
				if(Brackets.empty() != true) {
				    Brackets.pop();
				}else{
					return false;
				}
			}
		}
		if(Brackets.isEmpty() == false) {		
			System.out.println("false");
		    return false;
		}else {
			System.out.println("true");
			return true;	
		}
	}

}