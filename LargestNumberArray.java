import java.util.InputMismatchException;
import java.util.Scanner;

public class LargestNumberArray {

	public static int CompareToMax(int numbers[]) {

		int curMax, i;
		if (numbers.length <= 0) {
			return -1;
		}
		curMax = numbers[0];
		for (i = 1; i < numbers.length; i++) {
			if (numbers[i] > curMax) {
				curMax = numbers[i];
			}
		}
		System.out.println(" \n Largest Number " + curMax);
		return curMax;
	}

	public static void main(String[] args) {

		Scanner t = new Scanner(System.in);
		int value = 0;
		int numbers[] = new int[10];

		for (int i = 0; i < numbers.length; i++) {
			boolean flag;
			do {
				try {
					System.out.println("Enter value: ");
					value = t.nextInt();
					numbers[i] = value;
					flag = false;
				} catch (InputMismatchException iex) {
					System.out.println("Invalid number. Enter again.");
					flag = true;
					t.nextLine();
				}
			} while (flag);
		}
		for (int i : numbers) {
			System.out.print(i + " ");
		}

		CompareToMax(numbers);
	}
}
