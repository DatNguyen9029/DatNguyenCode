
package package1;

import java.util.Scanner;

public class Gach {
    private String maSo;
    private String mau;
    private int soLuong;  // So luong tren 1 hop
    private int chieuDai;
    private int chieuNgang;
    private long gia;   // Gia ban tren 1 hop
    
    public Gach() {
        maSo = "Unknown";
        mau = "Unknown";
        soLuong = 0;
        chieuDai = chieuNgang = 0;
        gia = 0;
    }
    public Gach(String maSo, String mau, int soLuong, int chieuDai, int chieuNgang, long gia) {
        this.maSo = new String(maSo);
        this.mau = new String(mau);
        this.soLuong = soLuong;
        this.chieuDai = chieuDai;
        this.chieuNgang = chieuNgang;
        this.gia = gia;
    }
    public Gach(Gach G) {
        this.maSo = new String(G.maSo);
        this.mau = new String(G.mau);
        this.soLuong = G.soLuong;
        this.chieuDai = G.chieuDai;
        this.chieuNgang = G.chieuNgang;
        this.gia = G.gia;
    }
    public void nhapTT() {
        Scanner sc = new Scanner(System.in);
        boolean kt = false;
        while(!kt) {
            try {   
        System.out.println("Nhap ma so: ");
        maSo = sc.nextLine();
        System.out.println("Nhap mau: ");
        mau = sc.nextLine();
        System.out.println("Nhap so luong 1 hop: ");
        soLuong = sc.nextInt();
        System.out.println("Nhap chieu dai: ");
        chieuDai = sc.nextInt();
        System.out.println("Nhap chieu rong: ");
        chieuNgang = sc.nextInt();
        System.out.println("Nhap gia tien 1 hop: ");
        gia = sc.nextLong();
        kt = true;
            } catch(NumberFormatException e) {
                kt = false;
                System.out.println("Kieu du lieu sai, hay nhap lai!");
            }
        }
    }
    public void display() {
        System.out.println("Ma so: " + maSo);
        System.out.println("Mau: " + mau);
        System.out.println("So luong: " + soLuong);
        System.out.println("Chieu dai: " + chieuDai);
        System.out.println("Chieu ngang: " + chieuNgang);
        System.out.println("Gia: " + gia);
        System.out.println("");
    }
    public void setMaSo(String maSo) {
        this.maSo = new String(maSo);
    }
    public void setMau(String mau) {
        this.mau = new String(mau);
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public void setChieuDai(int chieuDai) {
        this.chieuDai = chieuDai;
    }
    public void setChieuNgang(int chieuNgang) {
        this.chieuNgang = chieuNgang;
    }
    public void setGia(int gia) {
        this.gia = gia;
    }
    public String getMaSo() {
        return maSo;
    }
    public String getMau() {
        return mau;
    }
    public int getSoLuong() {
        return soLuong;
    }
    public int getChieuDai() {
        return chieuDai;
    }
    public int getChieuNgang() {
        return chieuNgang;
    }
    public long getGia() {
        return gia;
    }
    public float giaBanLe() {
        return (float) ((float)(gia/soLuong) * 1.2);
    }
    public int maxArea() {        // Dien tich toi da co the lot dc cua 1 hop gach
        return soLuong*chieuDai*chieuNgang;
    }
    public int soLuongHop(int D, int N) { //So luong hop it nhat can co de lot nen D*N
        int area = D*N;
        int max = maxArea();
        //return (max%area)>0 ? (max/area)+1 : (max/area);
        return max/area;
    }
    
}
