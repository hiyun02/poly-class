import java.util.Scanner;

public class Exam022 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int[] aa = new int[4];
		int hap = 0;
		int i = 0;

		System.out.println("�Է¹��� 1��° ���ڸ� aa�迭�� �����մϴ�.");
		aa[i++] = s.nextInt();
		System.out.println("�Է¹��� 2��° ���ڸ� aa�迭�� �����մϴ�.");
		aa[i++] = s.nextInt();
		System.out.println("�Է¹��� 3��° ���ڸ� aa�迭�� �����մϴ�.");
		aa[i++] = s.nextInt();
		System.out.println("�Է¹��� 4��° ���ڸ� aa�迭�� �����մϴ�.");
		aa[i++] = s.nextInt();

		hap = aa[0] + aa[1] + aa[2] + aa[3];

		System.out.println("hap : " + hap);

		for (int j = 0; j < aa.length; j++) {
			System.out.println("aa[" + j + "] : " + aa[j]);
		}
	}

}
