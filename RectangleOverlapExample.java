import java.util.Scanner;

public class RectangleOverlapExample {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out
				.print("Enter r1's center x-, y-coordinates, width, and height: ");
		// get input from the standard input
		double x1 = input.nextDouble(), y1 = input.nextDouble(), w1 = input
				.nextDouble();
		double h1 = input.nextDouble();
		System.out
				.print("Enter r2's center x-, y-coordinates, width, and height: ");
		// get input from the standard input
		double x2 = input.nextDouble(), y2 = input.nextDouble(), w2 = input
				.nextDouble();
		double h2 = input.nextDouble();
		double left1, right1, up1, down1, left2, right2, up2, down2;
		// define up, down, left and right edges of the two rectangles
		left1 = x1 - w1 / 2.0;
		right1 = x1 + w1 / 2.0;
		up1 = y1 + h1 / 2.0;
		down1 = y1 - h1 / 2.0;
		left2 = x2 - w2 / 2.0;
		right2 = x2 + w2 / 2.0;
		up2 = y2 + h2 / 2.0;
		down2 = y2 - h2 / 2.0;
		// check if the two rectangles overlap each other or one is inside the
		// other
		if (Math.abs(x1 - x2) < 1e-8 && Math.abs(y1 - y2) < 1e-8
				&& Math.abs(w1 - w2) < 1e-8 && Math.abs(h1 - h2) < 1e-8)
			System.out.println("Two rectangles match exactly");
		else if (right1 >= right2 && left2 >= left1 && up1 >= up2
				&& down2 >= down1)
			System.out.println("r2 is inside r1");
		else if (right2 >= right1 && left1 >= left2 && up2 >= up1
				&& down1 >= down2)
			System.out.println("r1 is inside r2");
		else if (down2 >= up1 || down1 >= up2 || right2 <= left1
				|| right1 <= left2)
			System.out.println("r2 does not overlap r1");
		else
			System.out.println("r2 overlaps r1");

	}
}
