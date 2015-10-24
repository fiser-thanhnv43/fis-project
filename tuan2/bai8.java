//package tuan2;

import java.util.Scanner;
import java.io.IOException;
import java.lang.*;
import java.util.ArrayList;
class Chuoi{
	String chuoi;
	char[] array;
	public Chuoi(String chuoi){
		this.chuoi = chuoi;
		this.array = new char[chuoi.length()]; 
		for(int i = 0; i < chuoi.length(); i++){
			this.array[i] = chuoi.charAt(i);
		}
	}
	// ham dao chuoi ....
	public String daoChuoi(){
		String result = "";
		for(int i = chuoi.length() - 1; i >= 0; i--){
			result += array[i];
		}
		return result;
	}
	// ham in hoa chu cai dau chuoi....
	public String inHoaDauChuoi(){
		String result = "";
		result += array[0];
		result = result.toUpperCase();
		for(int i = 1; i < chuoi.length(); i++){
			result += array[i];
		}
		return result;
	}
	// ham in hoa cac tu trong chuoi ....
	public String inHoaCacTuTrongChuoi(){
		String result = "";
		result += array[0];
		result = result.toUpperCase();
		for(int i = 1; i < chuoi.length(); i++){
			int key1 = array[i - 1];
			int key2 = array[i];
			if(key1 == 32 && key2 != 32){
				result += (array[i] + "").toUpperCase();
			}else{
				result += array[i];
			}
		}
		return result;
	}
	// ham chon ra cac ky tu hoa trong chuoi.....
	public String chucNang4(){
		String result = "";
		for(int i = 0; i < chuoi.length(); i++){
			int key = array[i];
			if(key >= 65 && key <= 90){
				result += array[i];
			}
		}
		if(result.equals("")){
			result = "trong chuoi cua ban ko co ky tu viet hoa !!!";
		}
		return result;
	}
	public String chucNang5(){
		String result = "";
		for(int i = 0; i < chuoi.length(); i++){
			int key = array[i];
			if(key == 90 || key == 122 || key == 32){
				result += array[i];
			}else{
				int key2 = key + 1;
				char c = (char)key2;
				result += c;
			}
		}
		return result;
	}

}
public class bai8 {
	static String MENU = "1. Dao chuoi \n" + 
				  "2. In hoa chu cai dau \n" + 
				  "3. In hoa chu cai dau cua cac tu trong cau \n" +
				  "4. Xuat ra cac chu cai duoc viet hoa \n" + 
				  "5. In lech chuoi 1 ky tu \n" +
				  "6. Thoat \n";
	public static void main(String[] args)throws InterruptedException{
		int chucNang = 0;
		String line = "";
		Chuoi chuoi;
		while(chucNang != 6){
			System.out.print(MENU);
			try{
				chucNang = chonChucNang();
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			switch (chucNang){
				case 1:
					try{
						line = nhapChuoi();
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
					chuoi = new Chuoi(line);
					System.out.println("Ket qua: " + chuoi.daoChuoi() + "\n");
					break;
				case 2:
					try{
						line = nhapChuoi();
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
					chuoi = new Chuoi(line);
					System.out.println("Ket qua: " + chuoi.inHoaDauChuoi() + "\n");
					break;
				case 3:
					try{
						line = nhapChuoi();
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
					chuoi = new Chuoi(line);
					System.out.println("Ket qua: " + chuoi.inHoaCacTuTrongChuoi() + "\n");
					break;
				case 4:
					try{
						line = nhapChuoi();
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
					chuoi = new Chuoi(line);
					System.out.println("Ket qua: " + chuoi.chucNang4() + "\n");
					break;
				case 5:
					try{
						line = nhapChuoi();
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
					chuoi = new Chuoi(line);
					System.out.println("Ket qua: " + chuoi.chucNang5() + "\n");
					break;
				case 6:
					try{
						chucNang = thoat();
					}catch(Exception e){
						System.out.print(e.getMessage());
					}
					break;
			}
		}
		System.out.println("Bye ! Hen gap ban lan sau .....");
		Thread.sleep(3000);
	}
	// ham thoat khoi chuong trinh .....
	public static int thoat() throws IOException{
		System.out.println("ban co muon thoat : (Y = co; N = ko) ");
		Scanner scan = new Scanner(System.in);
		String dapAn = scan.nextLine();
		if(dapAn.equalsIgnoreCase("Y")){
			return 6;
		}else{
			return 0;
		}	
	}
	// ham chon chuc nang cua menu .....
	public static int chonChucNang()throws IOException{
		System.out.print("Chon : ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		if(n == 0 || n > 9){
			return 6;
		} else{
			return n;
		}
	}
	// ham nhap chuoi .... 
	public static String nhapChuoi() throws Exception{
		String result = "";
		System.out.print("Nhap chuoi: ");
		Scanner scan = new Scanner(System.in);
		result = scan.nextLine();
		return result;
		
	}
}









