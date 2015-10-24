package tuan2;
import java.math.*;

public class SoPhuc {
	double a;
	double b;
	public SoPhuc(){
		
	}
	public SoPhuc(double phanThuc, double phanAo){
		this.a = phanThuc;
		this.b = phanAo;
	}
	public double getPhanThuc(){
		return this.a;
	}
	public double getPhanAo(){
		return this.b;
	}
	public void setPhanThuc(double phanThuc){
		this.a = phanThuc;
	}
	public void setPhanAo(double phanAo){
		this.b = phanAo;
	}
	public double getModun(){
		return Math.sqrt(a*a + b*b);
	}
	public SoPhuc congSoPhuc(SoPhuc z){
		double a2 = this.a + z.getPhanThuc();
		double b2 = this.b + z.getPhanAo();
		return new SoPhuc(a2, b2);
	}
	public SoPhuc truSoPhuc(SoPhuc z){
		double a2 = this.a - z.getPhanThuc();
		double b2 = this.b - z.getPhanAo();
		return new SoPhuc(a2, b2);
	}
	public SoPhuc nhanSoPhuc(SoPhuc z){
		double a2 = this.a * z.getPhanThuc() - this.b * z.getPhanAo();
		double b2 = this.a * z.getPhanAo() + this.b * z.getPhanThuc();
		return new SoPhuc(a2, b2);
	}
	public SoPhuc chiaSoPhuc(SoPhuc z){
		double a2 = (this.a * z.getPhanThuc() + this.b * z.getPhanAo())
					/ (z.getModun() * z.getModun());
		double b2 = (this.b * z.getPhanThuc() - this.a * z.getPhanAo())
					/ (z.getModun() * z.getModun());
		return new SoPhuc(a2, b2);
	}
	public String toString(){
		return this.a + " + " + this.b + "i";
	}
	public static void main(String[] args){
		SoPhuc z1, z2, z3;
		z1 = new SoPhuc(3, 4);
		z2 = new SoPhuc(2, 3);
		System.out.println("z1 : " + z1.toString());
		System.out.println("z2 : " + z2.toString());
		System.out.println("Modun cua z1 : " + z1.getModun());
		z3 = z1.congSoPhuc(z2);
		System.out.println("z3 : " + z3.toString() + " (cong)");
		z3 = z1.truSoPhuc(z2);
		System.out.println("z3 : " + z3.toString() + " (tru)");
		z3 = z1.nhanSoPhuc(z2);
		System.out.println("z3 : " + z3.toString() + " (nhan)");
		z3 = z1.chiaSoPhuc(z2);
		System.out.println("z3 : " + z3.toString() + " (chia)");
	}
}






