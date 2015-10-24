package tuan1;

class Temp{
	
	static int x = 10;
	public  static void show(){
		System.out.println("this is x : " + x);
	}
	static{
		System.out.println("hahahaha");
	}
	
}
public class bai3 {
	public static void main(String args[]){
		Temp.show();
		Temp temp =  new Temp();
		temp.show();
		temp.x = 20;
		temp.show();
	}	
}
