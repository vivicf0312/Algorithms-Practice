public class ReverseSentenceExample {

	public static void reverseSentence(String input) {
		int i;
		System.out.println("Input is " + input);
		StringBuilder sb = new StringBuilder();
		String[] temp = input.split(" ");

		for (i = temp.length - 1; i >= 0; i--) {
			sb.append(temp[i]);
			sb.append(" ");
		}
		System.out.println("Reversed string is " + sb);
	}

	public static void main(String[] args) {
		reverseSentence("glass of water");
	}
}
