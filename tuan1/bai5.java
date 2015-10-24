package tuan1;

public class bai5 {
	public static void main(String[] args){
		int n = Integer.valueOf(args[0]);
		System.out.println("tam giac thuong .... ");
		print1(n);
		System.out.println("tam giac pascan .... ");
		print2(n);
	}
	static void print1(int n){
		if( n <= 0 ){
			System.out.print("Hay nhap lai !!! ");
		}else {
			for( int i = 0; i <= n ; i++ ){
				for(int j = 1; j <= i; j++){
					System.out.print( j + " ");
				}
				System.out.println();
			}
		}
		
	}
	static void print2(int n){
		if( n <= 1 ){
			System.out.print("Hay nhap lai !!! ");
		}else{
			int [] arrayS;
			int k = 2;
			arrayS = new int[k];
			arrayS[0] = 1;
			arrayS[k-1] = 1;
			for( int i = 0; i < n ; i++ ){
				int[] templ = new int[k+1];
				templ[0] = 1;
				templ[k] = 1;
				for(int j = 0; j < k; j++){
					System.out.print( arrayS[j] + " ");
					if( j > 0){
						templ[j] = arrayS[j] + arrayS[j-1];
					}
				}
				System.out.println();
				arrayS = new int[k+1];
				arrayS = templ;
				k += 1;
			}

		}
	}
}
