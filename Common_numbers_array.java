import java.util.Arrays;

public class Common_numbers_array {
	static void withForLoop() {
		int a[] = { 1, 2, 3, 4, 5 };
		int b[] = { 3, 2, 9, 3, 7 };
		int common_elements[] = new int[5];
		int i;
		int j;
		int idx = 0;
		for (i = 0; i < a.length; i++) {
			j=0;
			for (j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					common_elements[idx++] = a[i];
				}
			}
		}
		System.out.println("With FOR LOOP "+Arrays.toString(common_elements));

	}
	public static void withWhileLoop(){
		int a[]={1,2,3,4,5};
		int b[]={3,2,9,3,7};
		int common_elements[] = new int[5];
		int i =0;
		int j =0;
		int idx =0;
		while (i < a.length){
			j=0;
			while(j<b.length){
				if(a[i]==b[j]){
					common_elements[idx++] = a[i];
				}
				j++;
			}
			i++;
		}
		System.out.println("With WHILE LOOP"+Arrays.toString(common_elements));
	}
	public static void sortedArrays(){
		int a[] = {1,2,3,4,5};
		int b[] = {2,3,3,7,9};
		int common_elements[]=new int[5];
		int i,j;
		int idx =0;
		
		for(i=0;i<a.length;i++){
			for(j=0;j<b.length;j++){
				if(a[i]<b[j]){
					break;
					}
				if(a[i]==b[j]){
					common_elements[idx++]=a[i];
				}
			}
		}
		System.out.println("Sorted Array "+ Arrays.toString(common_elements));
	}
	public static void main(String[] args) {
		withForLoop();
		withWhileLoop();
		sortedArrays();
	}

}
