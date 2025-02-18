package day2;

public class ExceptionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Authenticator auth=new Authenticator();
//		long code= auth.authenticate("scott", "tiger");
//		System.out.println("Auth Code = "+code);
		try {
			long code= auth.authenticate("scott", "tiger");
			System.out.println("Auth Code = "+code);
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			System.out.println("I will always be executed");
		}
	}

}
