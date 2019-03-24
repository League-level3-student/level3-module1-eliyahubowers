import java.util.ArrayList;
import java.util.Random;

public class Checkpoint {
	
	public static void main(String[] args) {
		Random r = new Random(0);
		int j = r.nextInt(10);
		ArrayList<Cow> cw = new ArrayList<Cow>(j);
		for(Cow c : cw) {
			c.feed();
		}
	}
	
	class Cow {
        public void feed(){}
      }
	
}
