package test;

public class Exam015 {

	public static void main(String[] args) {
		//�������� ���� : 3�� ��� ǥ���ϱ�
		for (int i = 1; i < 11; i++) {
			if (i % 3 == 0) {
				System.out.print("[3�� ���] ");
			}

			System.out.println(i);
		}
		
		//1���� 100������ �� �߿��� 3�� ����� 5�� ����� ���ڸ� ����Ͻÿ�
		for(int i=1;i<101;i++) {
			if(i%3==0&&i%5==0) { //15�� ����� ã�Ƶ� �����ϴ�
				System.out.print(i+" ");
			}
		}
	}

}
