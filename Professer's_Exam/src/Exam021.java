
public class Exam021 {
//for(;;) ���ѷ����� main()�Լ��� return
	public static void main(String[] args) {
		int hap = 0;
		int i = 0;

		for (;;) {
			for (i = 1; i < 101; i++) {
				hap += i;

				if (hap > 2000) {
					System.out.println("�հ�: " + hap);
					hap = 0;
					break;
//					return; : main �Լ��� �����Ŵ.
				}
			}
			System.out.println("������ �ݺ���...");
		}
	}

}
