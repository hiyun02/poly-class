package test;

public class test002 {

	public static void main(String[] args) {
		int i = 3;
		int j;
		while (i < 9) {
			if (i == 3 || i == 5) {
				System.out.println("<" + i + ">´Ü");
			}
			j = 1;
			while (j < 10) {
				System.out.println(i + "*" + j + "=" + i * j);
				j++;
			}
			System.out.println();
			i++;
		}
	}

}
