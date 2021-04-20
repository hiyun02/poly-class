package test;

public class star02 {

		   public static void main(String[] args) {
			      int k = 5;// 찍을 공백의 개수

			      for (int i = 0; i < 9; i++) {
			         if (i < 5) {
			            k--;// 5번째 줄까지는 공백의 개수가 1씩 줄지만
			         } else {
			            k++;// 그 이후에는 공백의 개수가 1씩 감소한다
			         }

			         // 줄마다 항상 5개의 문자를 출력
			         for (int j = 0; j < 5; j++) {
			        	//별은 k번만 출력
			        	 System.out.print(j<k ? " " : "*");
				
//				  if (j < k)System.out.println("*");
//				  else System.out.print(" ");
				 
			         }

			         System.out.println();
			      }
			   }

		}

