package test;

public class test010 {

	public static void main(String[] args) {
		// Q10. 다음과 같은 구조의 배열에 값이 저장 및 출력되도록 반복문을 사용하여 자바 코드 작성
		// for문으로 저장, while문으로 출력
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
