
public class Exam023 {

	public static void main(String[] args) {
		int aa[] = { 100, 200, 300, 400 };
		int[] abc = { 100, 200, 300, 400 };
		int[] bb = new int[] { 100, 200, 300 };
		int cc[];
		cc = new int[] { 100, 200 };
		int[] dd = new int[1];
		dd[0] = 100;

		for (int i = 0; i < aa.length; i++) {
			System.out.println("aa[" + i + "] : " + aa[i]);
		}
		for (int i = 0; i < abc.length; i++) {
			System.out.println("abc[" + i + "] : " + aa[i]);
		}
		for (int i = 0; i < bb.length; i++) {
			System.out.println("bb[" + i + "] : " + aa[i]);
		}
		for (int i = 0; i < cc.length; i++) {
			System.out.println("cc[" + i + "] : " + aa[i]);
		}
		for (int i = 0; i < dd.length; i++) {
			System.out.println("dd[" + i + "] : " + aa[i]);
		}
	}

}
