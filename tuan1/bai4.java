package tuan1;

public class bai4 {
	public static void main(String[] args){
		int time = Integer.valueOf(args[0]);
		if( time < 0 ){
			System.out.println(" Khong hop le !!! ");
		}else{
			System.out.println(" ... " + money(time));
		}
		
	}
	static float money(int time){
		if(time<200){
			return 27000 + time*120;
		}else{
			if(time<400){
				return 27000 + 200*120 + (time-200)*80;
			}else{
				return 27000 + 200*120 + 200*80 + (time-400)*40;
			}
		}
	}
}
