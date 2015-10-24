package baitap;

public class bai1 {
	public static void main(String[] args){
		int n = Integer.valueOf(args[0]);
		int[] array = new int[n];
		for(int i = 0; i < n; i++){
			array[i] = Integer.valueOf(args[i+1]);
		}
		for(int i = 0; i < n - 1; i++){
			for(int j = i + 1; j < n; j++){
				if(array[i] <= array[j]){
					int templ = array[i];
					array[i] = array[j];
					array[j] = templ;
				}
			}
		}
		System.out.println(array[0] + " " + array[n-1]);
		for(int i = n-1; i >= 0; i--){
			System.out.print(array[i] + " ");
		}
		System.out.println();
		for(int i = 0; i < n; i++){
			System.out.print(array[i] + " ");
		}
		
		
		
	}
}
