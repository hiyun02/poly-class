import java.util.Scanner;

public class Exam019 {

	public static void main(String[] args) {
//while(true) 무한루프와 break

		Scanner sc = new Scanner(System.in);

		int a = 0;
		int b = 0;

		while (true) {// 난 무한루프이다.
			System.out.println("첫번째 입력 값 : ");
			a = sc.nextInt();
			System.out.println("두번째 입력 값 : ");
			b = sc.nextInt();

			System.out.println("합계 : " + (a + b));

			// 합계가 10보다 크면 나가기
			if ((a + b) > 10) {
				break;
			}
		}
	}
}
