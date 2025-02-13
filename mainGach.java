package package1;
import java.util.Scanner;



public class mainGach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Gach g[] = new Gach[n];
        for(int i = 0; i < n; i++) {
            g[i] = new Gach();
            g[i].nhapTT();
        }
        for(int i = 0; i<n; i++) {
            g[i].display();
        }
        for(int i = 0; i<n; i++) {
            System.out.println("Gia ban le cua ma so " + g[i].getMaSo() + " la: " + g[i].giaBanLe());
        
        }
        float costG1 = (float)(g[0].getGia()/(float)g[0].maxArea());
        float costG2 = (float)(g[1].getGia()/(float)g[1].maxArea());
        float costG3 = (float)(g[2].getGia()/(float)g[2].maxArea());
        float minCost = costG1;
        Gach temp = g[0];
        if(costG2 < minCost) {
            minCost = costG2;
            temp = g[1];
        }
        if(costG3 < minCost) {
            minCost = costG3;
            temp = g[2];
        }
        System.out.println("Loai gach co chi phi thap nhat la: ");
        temp.display();
        long chiPhi[] = new long[n];
        for(int i = 0; i < n; i++) {
            chiPhi[i] = g[i].soLuongHop(20, 5)*g[i].getGia();
            System.out.println("Chi phi tam tinh " + i + " : " + chiPhi[i]);
            int areaLast = 100 - g[i].soLuongHop(20, 5)*g[i].maxArea();
            chiPhi[i] += (areaLast/(g[i].getChieuDai()*g[i].getChieuNgang())) * (long)g[i].giaBanLe();
        }
        for(int i=0; i<n; i++) {
            System.out.println("Chi phi loai gach ma so " + g[i].getMaSo() + " la: " + chiPhi[i]);
        }
    }
}
