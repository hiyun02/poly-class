
public class Exam14 {

	static int bbbb = 0; // Ŭ���� ��ü���� ���Ǵ� ���� (��������)

	public static void main(String[] args) {

		int hap = 0; // main �Լ��� ����Ǵ� ���ȸ� ����ִ� ����. for���� ����Ǳ���� ���� �����ϱ� ���� ���⿡ ����
		

		for (int i = 1; i <= 10; i++) {
			int b = 0; // for���� �� ���� ���� ���� ����ִ� ����
			hap += i;
		}
		System.out.println("1���� 10������ �� : " + hap);
		System.out.println(bbbb);
	}

}
