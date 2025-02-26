package spring.ioc;

public class ArithmeticImpl implements Arithmetic {

	@Override
	public int add(int x,int y) {
		System.out.println("Add A = "+x+" B = "+y);
		return x+y;
	}
	
	@Override
	public int sub(int x,int y) {
		System.out.println("Sub A = "+x+" B = "+y);
		return x-y;
	}
	
	@Override
	public int mul(int x,int y) {
		System.out.println("Mul A = "+x+" B = "+y);
		return x*y;
	}
	
	@Override
	public int div(int x,int y) {
		System.out.println("Div A = "+x+" B = "+y);
		return x/y;
	}
}
