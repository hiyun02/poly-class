
import java.util.Scanner;

public class Exam020 {

	public static void main(String[] args) {
		//do-while���� �̿��� �ֹ��ޱ� ����
		Scanner s = new Scanner(System.in);
		int menu = 0;

		do {
			System.out.println("�մ� �ֹ��Ͻðڽ��ϱ�?");
			System.out.println("<1>ī��� <2>īǪġ�� <3>�Ƹ޸�ī�� <4>�׸���ų����  ");
			
			menu = s.nextInt();

			switch(menu) {
			case 1:
				System.out.println("ī��󶼸� �ֹ��ϼ̽��ϴ�.");
				break;

			case 2:
				System.out.println("īǪġ�븦 �ֹ��ϼ̽��ϴ�.");
				break;

			case 3:
				System.out.println("�Ƹ޸�ī�븦 �ֹ��ϼ̽��ϴ�.");
				break;

			case 4:
				System.out.println("�ֹ��Ͻ� Ŀ�Ǹ� �غ��ϰڽ��ϴ�.");
				break;

			default:
				System.out.println("�߸� �ֹ��ϼ̽��ϴ�.");
				break;

			}

		} while (menu != 4);
	}

}
