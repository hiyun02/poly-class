
public class Exam030 {

	public static void main(String[] args) {
		System.out.println("main�Լ� ����");
		int res = sum(4, 6);
		System.out.println("Res : " + res);
		System.out.println("main�Լ� ��");
	}

	public static int sum(int i1, int i2) {

		System.out.println("sum�Լ� ����");
		int sum = 0;
		for (int i = i1; i <= i2; i++) {
			sum += i;

		}
		System.out.println("sum�Լ� ��");
		return sum;
	}
}
