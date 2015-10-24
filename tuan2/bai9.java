//package tuan2;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
import java.lang.Thread;;
class Dictionary{
	private String dataFile1 = "keyword.txt";
	private String dataFile2 = "dictionary.txt";
	private File file1 = new File(dataFile1);
	private File file2 = new File(dataFile2);
	private int soLuong = 0;
	public Dictionary(){
		if(!file1.exists()){
			try{
				file1.createNewFile();
				FileWriter fw = new FileWriter(file1);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.close();
				fw.close();
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
		}else{
			try{
				FileReader fr = new FileReader(this.file1);
				BufferedReader br = new BufferedReader(fr);
				String line;
				while((line = br.readLine()) != null){
					this.soLuong++;
				}
				br.close();
				fr.close();
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
			
			
		}
		if(!file2.exists()){
			try{
				file2.createNewFile();
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
		
	}
	private String getKey(String keyWord){
		String key = "";
		try{
			
			FileReader fr = new FileReader(file1);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null){
				String[] array = line.split(";");
				if(array[0].equals(keyWord)){
					return array[1];
				}
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return key;
	}
	// kiem tra su ton tai cua tu ... false - da ton tai .. true - chua ton tai
	private boolean kiemTraNghia(String key, String nghia){
		try{
			FileReader fr = new FileReader(file2);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null){
				String[] array = line.split(";");
				if(array[0].equals(key)){
					if(array[1].equalsIgnoreCase(nghia)){
						return false;
					}
				}
			}
			br.close();
			fr.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return true;
	}
	// ghi vao file ....
	private void ghiFile(String key, String value, String file){
		try{
			String templ = "";
			if(file.equals("file1")){
				templ = this.dataFile1;
			}
			if(file.equals("file2")){
				templ = this.dataFile2;
			}
			FileWriter fw = new FileWriter(templ, true);
			BufferedWriter bw = new BufferedWriter(fw);
			String line = key + ";" + value + ";\r\n";
			bw.write(line);
			bw.close();
			fw.close();
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	// HAM CHINH them tu ....
	public boolean themTu(String keyWord, String nghia){
		String key = getKey(keyWord);
		if(key != ""){
			if(!kiemTraNghia(key, nghia)){
				return false;
			}else{
				ghiFile(key, nghia, "file2");
				return true;
			}
		}else{
			int templ = this.soLuong + 1;
			key = templ + "";
			ghiFile(keyWord, key, "file1");
			ghiFile(key, nghia,"file2");
			this.soLuong ++;
			return true;
		}
	}
	// HAM CHINH tim tu ...
	public String[] timTu(String keyWord){
		String[] array = new String[10];
		int i = 0;
		String key = getKey(keyWord);
		try{
			FileReader fr = new FileReader(this.file2);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null){
				String[] templ = line.split(";");
				if(templ[0].equalsIgnoreCase(key)){
					array[i] = templ[1];
					i++;
				}
			}
			br.close();
			fr.close();
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		return array;
	}
}
public class bai9{
	static String MENU = "1. Them tu \n" + 
						 "2. Tim tu \n" +
						 "3. Thoat \n";
	public static void main(String[] args) throws InterruptedException{
		Dictionary td = new Dictionary();
		int chon = 0;
		while(chon != 3){
			System.out.print(MENU);
			try{
				chon = chonChucNang();
			}catch(IOException e){
				System.out.println(e.getMessage());
			}
			switch(chon){
				case 1:
					try{
						themTu(td);
					}catch(IOException e){
						System.out.println(e.getMessage());
					}
					break;
				case 2:
					try{
						traTu(td);
					}catch(IOException e){
						System.out.println(e.getMessage());
					}
					break;
				case 3:
					try{
						chon = thoat();
					}catch(IOException e){
						System.out.println(e.getMessage());
					}
					
					break;
			}
		}
		System.out.println("Bye ! hen gap lai ban sau .... ");
		Thread.sleep(2500);
	}
	// Chuc nang tra tu 
	public static void traTu(Dictionary td)throws IOException{
		Scanner scan = new Scanner(System.in);
		System.out.print("Key Word: ");
		String keyWord = scan.nextLine();
		String[] array = td.timTu(keyWord);
		System.out.print("\n Value: ");
		int i = 0;
		while(array[i] != null){
			System.out.print(array[i] + ", ");
			i++;
		}
		System.out.print("\n\n");
		if(i == 0){
			System.out.println("\n tu nay chua co trong tu dien !!!\n");
		}
	}
	// Chuc nang them tu 
	public static void themTu(Dictionary td)throws IOException{
		Scanner scan = new Scanner(System.in);
		System.out.print("Key Word: ");
		String keyWord = scan.nextLine();
		System.out.print("Vaule: ");
		String value = scan.nextLine();
		if(td.themTu(keyWord, value)){
			System.out.println("\n OK ... da them \n");
		}else{
			System.out.println("\n tu nay da ton tai !!! \n");
		}
	}
	// ham ho tro viec chon chuc nang
	public static int chonChucNang()throws IOException{
		System.out.print("Chon : ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		if(n < 0 || n > 3){
			return 3;
		} else{
			return n;
		}
	}
	// ham thoat chuong trinh
	public static int thoat() throws IOException{
		System.out.println("ban co muon thoat : (Y = co; N = ko) ");
		Scanner scan = new Scanner(System.in);
		String dapAn = scan.nextLine();
		if(dapAn.equalsIgnoreCase("Y")){
			return 3;
		}else{
			return 0;
		}	
	}
}












