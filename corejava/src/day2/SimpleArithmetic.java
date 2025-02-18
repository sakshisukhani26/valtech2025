package day2;

public class SimpleArithmetic implements Arithmetic {

	@Override
	public double add(double x, double y) {
		// TODO Auto-generated method stub
		return x+y;
	}

	@Override
	public double sub(double x, double y) {
		// TODO Auto-generated method stub
		return x-y;
	}

	@Override
	public double mul(double x, double y) {
		// TODO Auto-generated method stub
		return x*y;
	}

	@Override
	public double div(double x, double y) {
		// TODO Auto-generated method stub
		return x/y;
	}
	
	@Override
	public int div(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void main(String[] args) {
		SimpleArithmetic obj= new SimpleArithmetic();
		System.out.println("Addition is "+obj.add(20, 10));
		System.out.println("Subtraction is "+obj.sub(20, 10));
		System.out.println("Multiplication is "+obj.mul(20, 10));
		System.out.println("Division is "+obj.div(20, 10));
	}

	

}

