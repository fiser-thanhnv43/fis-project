package baitap;

public class bai2 {
	public static void main(String[] args){
		int n = Integer.valueOf(args[0]);
		int[] array = new int[n];
		for(int i = 0; i < n; i++){
			array[i] = Integer.valueOf(args[i+1]);
		}
		for(int i = 0; i < n - 1; i++){
			for(int j = i + 1; j < n; j++){
				if(array[i] >= array[j]){
					int templ = array[i];
					array[i] = array[j];
					array[j] = templ;
				}
			}
		}
		int count = 0;
		int sumEnd = Integer.valueOf(args[n + 1]);
		for(int i = 0; i < n; i++){
			int sum = array[i];
			if(sum == sumEnd){
				count++;
				break;
			}
			if(sum > sumEnd){
				i = n - 1;
				break;
			}
			for(int j = i + 1; j < n; j++){
				sum += array[j];
				if(sum == sumEnd){
					count++;
					break;
				}
				if(sum > sumEnd){
					if(j - 1 == i){
						break;
					}
					if(j - i > 2){
						int k = j - i - 2;
						int sumTempl = sum;
						for(int z = 0; z < k; k++){
							sum = sumTempl;
							sum -= (array[j - 1] + array[j]);
						}
						sum -= (array[j - 1] + array[j]);
						j = j - 1;
					}
				}
			}
		}
		System.out.print(count + sumEnd);
	}
}
