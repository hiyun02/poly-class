import java.util.Scanner;

public class Exam019 {

	public static void main(String[] args) {
//while(true) ���ѷ����� break

		Scanner sc = new Scanner(System.in);

		int a = 0;
		int b = 0;

		while (true) {// �� ���ѷ����̴�.
			System.out.println("ù��° �Է� �� : ");
			a = sc.nextInt();
			System.out.println("�ι�° �Է� �� : ");
			b = sc.nextInt();

			System.out.println("�հ� : " + (a + b));

			// �հ谡 10���� ũ�� ������
			if ((a + b) > 10) {
				break;
			}
		}
	}
}
