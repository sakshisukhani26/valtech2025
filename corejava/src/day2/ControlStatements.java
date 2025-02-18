package day2;

public class ControlStatements {

	public void testIfElse(int a) {
		if(a%2==0) {
			System.out.println(a+" is an even number");
		}
		else {
			System.out.println(a+" is an odd number");
		}
	}
	
	public void testfor(int []a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public int add(int iv,int ... a) {
		int sum=iv;
		for (int i = 0; i < a.length; i++) {
			sum+=a[i];
		}
		System.out.println("Sum is "+sum);
		return sum;
	}
	
	public void testswitch(int a) {
		switch(a) {
			case 1:System.out.println("One");
					break;
			case 2:System.out.println("Two");
					break;
			case 3:System.out.println("Three");
					break;
			case 4:System.out.println("Four");
					break;
			default: System.out.println("All others");
		}
	}
	
	public static void main(String[] args) {
		ControlStatements cs=new ControlStatements();
		cs.testIfElse(5);
		cs.testfor(new int[] {1,2,3,4});
		cs.testswitch(1);
		
		cs.add(1,2,3);
		cs.add(1,2,3,4);
	}
}
