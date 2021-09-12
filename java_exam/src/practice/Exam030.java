
public class Exam030 {

	public static void main(String[] args) {
		System.out.println("main함수 시작");
		int res = sum(4, 6);
		System.out.println("Res : " + res);
		System.out.println("main함수 끝");
	}

	public static int sum(int i1, int i2) {

		System.out.println("sum함수 시작");
		int sum = 0;
		for (int i = i1; i <= i2; i++) {
			sum += i;

		}
		System.out.println("sum함수 끝");
		return sum;
	}
}
