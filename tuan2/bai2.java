import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.lang.*;
public class bai2 {
	static String MENU = "1. Nhap kho \n" + "2. Xuat kho \n"
			+ "3. Quan ly gia \n" + "4. In hoa don \n" + "5. Thoat\n";
	static String NHAPKHO = "1. Nhap kho so luong mot don vi \n"
			+ "2. Nhap theo thung 20 don vi \n"
			+ "3. Nhap theo ta 10 don vi \n" + "4. Chinh sua theo so \n"
			+ "5. Quay lai menu 1 \n";
	static String XUATKHO = "1. Xuat theo don vi \n"
			+ "2. Xuat theo thung 20 don vi \n"
			+ "3. Xuat theo ta 10 don vi \n" + "4. Chinh sua theo so  \n"
			+ "5. Quay lai menu 1 \n";
	static String QUANLYGIA = "1. Hien thi gia \n" + "2. Sua gia \n"
			+ "3. Tong tien hang \n" + "4. Quay lai menu 1 \n";

	public static void main(String[] args) throws InterruptedException {
		Kho kho = new Kho();
		HoaDon hoaDon = new HoaDon();
		hoaDon.inHoaDon();
		TaiKhoan TK = new TaiKhoan();
		int chon = 0;
		Scanner scan = new Scanner(System.in);
		String taiKhoan, matKhau;
		int flap = 0;
		int flap2 = 0;
		while (flap2 == 0) {
			for (int i = 0; i < 3 && flap == 0; i++) {
				System.out.print("Tai Khoan : ");
				try {
					taiKhoan = scan.nextLine();
					if (TK.kiemTraTK(taiKhoan) == false) {
						System.out.println("Tai Khoan khong ton tai !!! ");
					}
					if (TK.kiemTraTK(taiKhoan)) {
						System.out.print("MatKhau : ");
						matKhau = scan.nextLine();
						if (TK.kiemTraMK(matKhau)) {
							flap = 1;
							flap2 = 1;
						}
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			if (flap != 1) {
				System.out.println("ngu 10s ...............................");
				Thread.sleep(10000);
			}
		}
		while (chon != 5) {
			System.out.print(MENU);
			int chon2 = 0;
			try {
				chon = chonChucNang();
			} catch (IOException e) {
				System.out.println("error : " + e.getMessage());
			}
			switch (chon) {
				case 1 :
					System.out.print(NHAPKHO);
					try {
						chon2 = chonChucNang();
					} catch (IOException e) {
						System.out.println("error : " + e.getMessage());
					}
					nhapKho(kho, chon2, hoaDon);
					break;
				case 2 :
					System.out.print(XUATKHO);
					try {
						chon2 = chonChucNang();
					} catch (IOException e) {
						System.out.println("error : " + e.getMessage());
					}
					xuatKho(kho, chon2, hoaDon);
					break;
				case 3 :
					System.out.print(QUANLYGIA);
					try {
						chon2 = chonChucNang();
					} catch (IOException e) {
						System.out.println("error : " + e.getMessage());
					}
					quanLyGia(kho, chon2);
					break;
				case 4 :
					hoaDon.inHoaDon();
					break;
				case 5 :
					try {
						chon = thoat();
					} catch (IOException e) {
					}
					break;
			}
		}

	}
	// ham thoat chuong trinh
	public static int thoat() throws IOException {
		System.out.println("ban co muon thoat : (Y = co; N = ko) ");
		Scanner scan = new Scanner(System.in);
		String dapAn = scan.nextLine();
		if (dapAn.equalsIgnoreCase("Y")) {
			return 5;
		} else {
			return 0;
		}
	}
	// ham quan ly gia
	public static void quanLyGia(Kho kho, int chon2) {
		switch (chon2) {
			case 1 :
				System.out.println("gia hien tai : " + kho.getGia());
				break;
			case 2 :
				System.out.println("Nhap gia moi (don vi vnd): ");
				try {
					Scanner scan = new Scanner(System.in);
					int gia = scan.nextInt();
					kho.setGia(gia);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3 :
				System.out.println("tong tien hang trong kho : "
						+ kho.getTongTien());
				break;
		}
	}
	// ham quan ly viec xuat kho
	public static void xuatKho(Kho kho, int chon2, HoaDon hoaDon) {
		int soLuong = 0;
		try {
			soLuong = nhapSoLuong();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		int donvi = 1;
		switch (chon2) {
			case 1 :
				donvi = 1;
				break;
			case 2 :
				donvi = 20;
				break;
			case 3 :
				donvi = 10;
				break;
			default :
				break;
		}
		if (kho.xuatKho(soLuong * donvi) == false) {
			System.out
					.println("Hang trong kho ko con du !!! nhung se xuat het cho ban");
			kho.xuatKho(kho.getSoLuong());
			hoaDon.xuat(kho.getSoLuong(), kho.getGia());
		}
		hoaDon.xuat(soLuong * donvi, kho.getGia());
	}
	// ham quan ly viec nhap kho
	public static void nhapKho(Kho kho, int chon2, HoaDon hoaDon) {
		int soLuong = 0;
		try {
			soLuong = nhapSoLuong();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		int donvi = 1;
		switch (chon2) {
			case 1 :
				donvi = 1;
				break;
			case 2 :
				donvi = 20;
				break;
			case 3 :
				donvi = 10;
				break;
			default :
				break;
		}
		kho.nhapKho(soLuong * donvi);
		hoaDon.nhap(soLuong * donvi, kho.getGia());
	}
	// ham ho tro viec nhap so luong hang
	public static int nhapSoLuong() throws IOException {
		System.out.print("Nhap so luong : ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		return n;
	}
	// ham ho tro viec chon chuc nang
	public static int chonChucNang() throws IOException {
		System.out.print("Chon : ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		if (n == 0 || n > 9) {
			return 1;
		} else {
			return n;
		}
	}
}
// lop TaiKhoan ho tro quan ly tai khoan
class TaiKhoan {
	String taiKhoan;
	String matKhau;
	String dataFile = "TaiKhoan.txt";
	File file = new File(dataFile);
	public boolean kiemTraTK(String taiKhoan) {
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				String[] array = line.split(";");
				if (taiKhoan.equals(array[0])) {
					this.taiKhoan = taiKhoan;
					this.matKhau = array[1];
					return true;
				}
			}
			br.close();
			fr.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	public boolean kiemTraMK(String matKhau) {
		if (this.matKhau.equals(matKhau)) {
			return true;
		} else {
			return false;
		}
	}
}
// lop Kho ho tro quan ly kho
class Kho {
	int soLuong;
	int gia;
	int tongTien;
	String dataFile = "KhoGiaTien.txt";
	File file = new File(dataFile);
	public Kho() {
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			line = br.readLine();
			String[] array = line.split(";");
			this.soLuong = Integer.valueOf(array[0]);
			this.gia = Integer.valueOf(array[1]);
			this.tongTien = Integer.valueOf(array[2]);
			br.close();
			fr.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	private void capNhatDataFile() {
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			String line = this.soLuong + ";" + this.gia + ";" + this.soLuong
					* this.gia + ";";
			bw.write(line);
			bw.close();
			fw.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public void nhapKho(int soLuongNhap) {
		this.soLuong += soLuongNhap;
		capNhatDataFile();
	}
	public boolean xuatKho(int soLuongXuat) {
		if (soLuongXuat > this.soLuong) {
			return false;
		} else {
			this.soLuong -= soLuongXuat;
			capNhatDataFile();
			return true;
		}
	}
	public int getSoLuong() {
		return this.soLuong;
	}
	public void setGia(int gia) {
		this.gia = gia;
		capNhatDataFile();
	}
	public int getGia() {
		return this.gia;
	}
	public int getTongTien() {
		return this.tongTien;
	}
}
// lop HoaDon ho tro quan ly viec in hoa don
class HoaDon {
	int soLuongNhap;
	int soLuongXuat;
	int tienNhap;
	int tienXuat;
	String dataFile = "HoaDon.txt";
	File file = new File(dataFile);
	public HoaDon() {
		this.soLuongNhap = 0;
		this.soLuongXuat = 0;
		this.tienNhap = 0;
		this.tienXuat = 0;
	}
	public void nhap(int soLuongNhap, int gia) {
		this.soLuongNhap += soLuongNhap;
		this.tienNhap += soLuongNhap * gia;
	}
	public void xuat(int soLuongXuat, int gia) {
		this.soLuongXuat += soLuongXuat;
		this.tienXuat += soLuongXuat * gia;
	}
	public void inHoaDon() {
		String hoaDon = "\t HOA DON \r\n" + " Nhap : " + this.soLuongNhap
				+ " thanh tien : " + this.tienNhap + "\r\n" + " Xuat : "
				+ this.soLuongXuat + " thanh tien : " + this.tienXuat + "\r\n";
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file);
			BufferedWriter br = new BufferedWriter(fw);
			br.write(hoaDon);
			br.close();
			fw.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
