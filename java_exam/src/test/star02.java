package test;

public class star02 {

		   public static void main(String[] args) {
			      int k = 5;// ���� ������ ����

			      for (int i = 0; i < 9; i++) {
			         if (i < 5) {
			            k--;// 5��° �ٱ����� ������ ������ 1�� ������
			         } else {
			            k++;// �� ���Ŀ��� ������ ������ 1�� �����Ѵ�
			         }

			         // �ٸ��� �׻� 5���� ���ڸ� ���
			         for (int j = 0; j < 5; j++) {
			        	//���� k���� ���
			        	 System.out.print(j<k ? " " : "*");
				
//				  if (j < k)System.out.println("*");
//				  else System.out.print(" ");
				 
			         }

			         System.out.println();
			      }
			   }

		}

