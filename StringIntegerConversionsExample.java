
public class StringIntegerConversionsExample {
	
	 public static int stringToint( String str ){
	        int i = 0, number = 0;
	        boolean isNegative = false;
	        int len = str.length();
	        if( str.charAt(0) == '-' ){
	            isNegative = true;
	            i = 1;
	        }
	        while( i < len ){
	            number *= 10;
	            number += ( str.charAt(i++) - '0' );
	        }
	        if( isNegative )
	        number = -number;
	        return number;
	    } 
	
		public static final int MAX_DIGITS = 10;
		public static String intToStr( int num ){
	        int i = 0;
	        boolean isNegative = false;
	        /* Buffer big enough for largest int and - sign */
	        char[] temp = new char[ MAX_DIGITS + 1 ];
	        /* Check to see if the number is negative */
	        if( num < 0 ){
	            num = -num;
	            isNegative = true;
	        }
	        /* Fill buffer with digit characters in reverse order */
	        do {
	            temp[i++] = (char)((num % 10) + '0');
	            num /= 10;
	        } while( num != 0 );
	        StringBuilder b = new StringBuilder();
	        if( isNegative )
	        b.append( '-' );
	        while( i > 0 ){
	            b.append( temp[--i] );
	        }
	        return b.toString();
	    }
	
	public static void main(String[] args){
			String  convertingString="Ana";
	        System.out.println("String Before Conversion :  "+ convertingString);
	        int output = stringToint( convertingString );
	        System.out.println("");
	        System.out.println("");
	        System.out.println("int value as output "+ output);
	        System.out.println("");
	        
	        String result=    intToStr(-23);
	        System.out.println("Output is : "+ result);
		
	}
}
/*Method 2 : Convert int to string using valueOf() method

int number=537;
String result = String.valueOf(number);
System.out.println(result);



Method 3 : Convert int to string using toString() method

int number=537;
String result = Integer.toString(number);
System.out.println(result);


Method 4 : Append  empty string ""  to the integer using + operator   

int number=537;
System.out.println(number + "" );



Big Question !! Which is most efficient method to convert integer to string?and Why ?

We are discussing comparison  between Method 2 , Method 3 and Method 4 , since the Method 1 is our own algorithm , we are not comparing it with the rest.

So the Order is :

Method 3 (recommended)> Method  2 > Method  4 (least preferred)     

Why ?

Method 4 is the least preferred because

It uses empty string "" with + operator which internally performs :

StringBuilder sbobject=  new StringBuilder();
sbobject.append();
sbobject.append(number);
return sbobject.toString();


So there is so much overhead before it reaches toString() method.


Method 2 ,valueOf() method internal implementation is like this  :

public static String valueOf(Object obj) {
    return (obj == null) ? "null" : obj.toString();
} 


Above, we can see that  valueOf() internally calling toString() method , to convert integer to string.

Hence  Method 3 is the most efficient where we are directly calling toString() method to achieve our goal .*/
