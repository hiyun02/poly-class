class Car2 {
	private String color;
	private int speed;

	Car2() {
		System.out.println("�� �޸𸮸� ������ �� �ڵ����� ����Ǵ� �������̴�.");
		this.color = "����";
		this.speed = 0;

		System.out.println("�� �޸� ���� ��");
	}

	public String getColor() {
		return color;
	}

	public int getSpeed() {
		return speed;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}

public class Exam032 {

	public static void main(String[] args) {
		Car2 myCar1 = new Car2();
		Car2 myCar2 = new Car2();

		
		System.out.println("1�� ���� : " + myCar1.getColor() + " , ����ӵ� : " + myCar1.getSpeed());
		System.out.println("2�� ���� : " + myCar1.getColor() + " , ����ӵ� : " + myCar1.getSpeed());

	}

}
