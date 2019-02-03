package _02_Integer_Stack;

public class IntegerStack {
	//1. create a private array of integers
	private int[] arr = new int[0];
	//2. complete the constructor by initializing the member array
	//   to a new array of length 0. This prevents null pointer exceptions.
	public IntegerStack() {
	}
	
	//3. Complete the steps in the push method.
	public void push(int v) {
		int j  = arr.length+1;
		//A. create a new array that is one element larger than the member array
		int[] arry = new int[j];
		//B. set the last element of the new array equal to the integer passed into the method
		arry[arr.length] = v;
		//C. iterate through the member array and copy all the elements into the new array
		for(int i = 0; i < arr.length; i ++) {
			arry[i] = arr[i];
		}
		//D. set the member array equal to the new array.
		arr = arry;
	}
	
	//4. Complete the steps in the pop method.
	public int pop() {
		int l = arr.length-1;
		//A. create an integer variable and initialize it to the
		//   last element of the member array.
		int j = arr[l];
		//B. create a new array that is one element smaller than the member array
		int[] arry = new int[l];
		//C. iterate through the new array and copy every element from the
		//   member array to the new array
		for(int i = 0; i < l; i ++) {
			arry[i] = arr[i];
		}
		//D. set the member array equal to the new array
		arr = arry;
		//E. return the variable you created in step A
		return j;
	}
	
	//5. Complete the clear method to set the
	//   member array to a new array of length 0
	public void clear() {
		int[] arry = new int[0];
		arr = arry;
	}
	
	//6. Complete the size method to return 
	//   the length of the member array
	public int size() {
		return arr.length;
	}
}
