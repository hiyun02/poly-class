package test;

import java.util.Scanner;

public class star02 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k;
		for (int i = 1; i <= 2 * n - 1; i++) {
			if (i < n) {
				k = n - i;
			} else {
				k = i - n;
			}

			for (int j = 0; j < k; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < n - k; j++) {
				System.out.print("*");
			}

			System.out.println();
		}
	}

}
