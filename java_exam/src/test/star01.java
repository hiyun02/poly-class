package test;

import java.util.Scanner;

public class star01 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = 0;
		for (int i = 0; i < 2 * n - 1; i++) {
			if (i < n) {
				k++;
			} else {
				k--;
			}
			for (int j = 0; j < k; j++) {
				System.out.print("*");
			}

			System.out.println();
		}
	}

}
