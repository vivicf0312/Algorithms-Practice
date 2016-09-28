import java.util.Scanner;

public class SumNumbersInArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter length of array");
		int n = in.nextInt();
		int arr[] = new int[n];
		int sum = 0;
		System.out.println("Enter a values in array");
		for (int arr_i = 0; arr_i < n; arr_i++) {
			arr[arr_i] = in.nextInt();
		}

		for (int j = 0; j < arr.length; j++) {
			sum = sum + arr[j];

		}
		System.out.print("Result of addition: "+sum);
	}
}
