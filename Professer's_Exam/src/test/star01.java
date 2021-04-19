package test;

import java.util.Scanner;

public class star01 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 1; i <= 2 * n - 1; i++) {
			if (i < n) {
				for (int j = 1; j <= i; j++) {
					System.out.print("*");
				}
			}

			else {
				for (int j = n; j > i-n; j--) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

}
