public class CombinationOfStringsExample {

	private StringBuilder output = new StringBuilder();
	private final String inputstring;

	public CombinationOfStringsExample(final String str) {
		inputstring = str;
		System.out.println("The input string  is  : " + inputstring);
	}

	public static void main(String args[]) {
		CombinationOfStringsExample combobj = new CombinationOfStringsExample(
				"wx");
		System.out.println("");
		System.out.println("");
		System.out.println("All possible combinations are :  ");
		System.out.println("");
		System.out.println("");
		combobj.combine();
	}

	public void combine() {
		combine(0);
	}

	static int index = 1;

	private void combine(int start) {

		//when i is = or > than inputstring.length(), it goes out of the loop,
		//it substract one character from outputstring
		//start goes back to the previous iteration, 3, i will be 3+1(use ++1 of for loop),
		//so it will go out of the loop and so on
		for (int i = start; i < inputstring.length(); ++i) {
			output.append(inputstring.charAt(i));
			System.out.println(index++ + ")" + output);
			if (i < inputstring.length() - 1) {
				combine(i + 1);
			}
			output.setLength(output.length() - 1);
		}
	}
}
