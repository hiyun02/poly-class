package test;

public class test010 {

	public static void main(String[] args) {
		// Q10. ������ ���� ������ �迭�� ���� ���� �� ��µǵ��� �ݺ����� ����Ͽ� �ڹ� �ڵ� �ۼ�
		// for������ ����, while������ ���
		int[] num = new int[10];

		int i = 0;
		for (i = 0; i < num.length; i++) {
			num[i] = 10 * (i + 1);
		}

		i = 0;
		while (i < num.length) {
			System.out.println(num[i]);
			i++;
		}

	}
}
