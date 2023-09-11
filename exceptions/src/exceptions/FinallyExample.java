package exceptions;

public class FinallyExample {

	public static void main(String[] args) {
		int result = doTask();
		System.out.println(result);
	}

	private static int doTask() {
		try {
			int x = 10;
			int y = 0;
			System.out.println(x/y);
		} catch(NullPointerException ex) {
			return 100;
		} catch(ArithmeticException ex) {
			return 200;
		} finally {
			return 500;
		}
	}

}
