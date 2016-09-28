import java.util.Hashtable;
import java.util.Scanner;


public class FirstNonRepeatedCharacter {

	public static Character firstNonRepeated(String str){
		Hashtable<Character, Integer> charHash = new Hashtable<Character, Integer>();
		int i, length;
		char c;
		length = str.length();
		
		//Scan string, building hashtable
		for(i = 0; i<length;i++){
			c = str.charAt(i);
			if(charHash.containsKey(c)){
				//increment count corresponding to c
				charHash.put(c,charHash.get(c) + 1);
			}else{
				charHash.put(c, 1);
			}
		}
		//search hashtable in order of str
		for(i = 0; i < length; i++){
			c = str.charAt(i);
			if(charHash.get(c) == 1){
				return c;
			}
		}
		return null;
	}
	public static void main(String[] args){
		System.out.println(" Please enter the input string :" );
        @SuppressWarnings("resource")
		Scanner in = new Scanner (System.in);
        String s=in.nextLine();
        char c=firstNonRepeated(s);
        System.out.println("The first non repeated character is :  " + c);
	}
	
}
