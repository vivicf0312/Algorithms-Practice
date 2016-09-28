
public class NfactorialExample {
	
	
	//Recursive Functions
	public static int factorial(int n){
		int result;
		if(n > 1){//recursive case
			result = factorial(n-1) * n;
			return result;
		}
		else{
			result = 1;
			return result;//base case
		}
	}
	
	//Recursive Functions with wrapper
	public static int factorialWrapper(int number) {
	    if(number == 0) {
	           return 1;
	        }
	        return factorial_i(number, 1);
	}

	public static int factorial_i(int currentNumber, int sum) {
	    if(currentNumber == 1) {
	        return sum;
	    } else {
	        return factorial_i(currentNumber - 1, sum*currentNumber);
	    }
	}
	
	//Recursive Function with wrapper and array
	public static int[] allFactorials(int n){
		int length = (n == 0 ? 1:n);
		int[] results = new int[length];
		doAllFactorials(n, results, 0);
		return results;
	}
	public static int doAllFactorials(int n, int[] results, int level){
		if(n > 1){
			results[level] = n * doAllFactorials(n -1, results, level + 1);
			return results[level];
		}
		else{
			results[level] = 1;
			return 1;
		}
	}
	public static void printArray(int[] results){

		for(int i=0;i<results.length;i++){
			System.out.println("The factorial of "+(results.length -i) + " is: " + results[i] );
		}
	}
	//Iterative Function
	public static int iterativeFactorialFunction(int n){
		 int val = 1;
		 for(int i = 1;i<= n; i++){
			 val *=i;
		 }
		 System.out.println("The factorial of " + n + " is: " + val);
		 return val;
	}
	public static void main(String[] args){
		int n = 4;

		printArray(allFactorials(n));
		System.out.println("\n");
		iterativeFactorialFunction(n);
	}
}
