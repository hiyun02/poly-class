import java.util.Scanner;

public class Exam12 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int a;
		System.out.println("1~4���� �����ϼ���. ");
		a = s.nextInt();
		switch (a) {
		case 1:
			System.out.println(a + " 1�� �����ߴ�.");
			break;
		case 2:
			System.out.println(a + " 2�� �����ߴ�.");
			break;
		case 3:
			System.out.println(a + " 3�� �����ߴ�.");
			break;
		case 4:
			System.out.println(a + " 4�� �����ߴ�.");
			break;
		default:
			System.out.println(" �̻��� �� ������");
			break;

		}
	}

}
