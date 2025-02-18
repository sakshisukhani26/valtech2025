package day3;

public class SimpleInterestImpl implements SimpleInterest {

	public static void main(String[] args) {
		SimpleInterest si= new SimpleInterestImpl();
		System.out.println(si.computeInterest(2000, 12, 3));
		SimpleInterest newSI= new SimpleInterest() {
			@Override
			public double computeInterest(double principal, double rateOfInterest, double duration) {
				// TODO Auto-generated method stub
				return SimpleInterest.super.computeInterest(principal, rateOfInterest, duration);
			}
		};
		System.out.println(newSI.computeInterest(2000, 12, 3));
//		SimpleInterest lambaSi= (p,r,d)-> 
	}
}
