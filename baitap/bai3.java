

public class bai3 {
	public static void main(String[] args){
		int n = args.length;
		String[] arrayS = new String[n];
		int[] arrayI = new int[n];
		for(int i = 0; i < n; i++){
			String[] templ = args[i].split("[., ]");
			arrayS[i] = templ[0];
			arrayI[i] = 1;
		}
		for(int i = 0; i < n - 1; i++){
			if(arrayI[i] == 0){
				// khong lam gi ca ....
			} else{
				for(int j = i + 1; j < n; j++){
					if(arrayI[j] == 1 && arrayS[i].equals(arrayS[j])){
						arrayI[i]++;
						arrayI[j] = 0;
					}
				}
			}
		}
		for(int i = 0; i < n - 1; i++){
			for(int j = i + 1; j < n; j++){
				if(arrayI[i] < arrayI[j]){
					int templI = arrayI[i];
					String templS = arrayS[i];
					arrayI[i] = arrayI[j];
					arrayI[j] = templI;
					
					arrayS[i] = arrayS[j];
					arrayS[j] = templS;
				}
			}
		}
		for(int i = 0; i < n; i++){
			if(arrayI[i] == 0){
				break;
			}
			else {
				System.out.println(arrayS[i] + " " + arrayI[i]);
			}
		}
		
		
	}
}
