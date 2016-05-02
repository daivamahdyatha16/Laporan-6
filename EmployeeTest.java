package javaapplication25;

import java.util.Scanner;
public class EmployeeTest {

    static String nama;
    static String id;
    static int jabatan;
    static int tahun;
    static String istri;
    static int anak;
     
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("================== DATA PEGAWAI UNIVERSITAS BRAWIJAYA ==================");      
        System.out.println("Bonus, tunjangan-tunjangan, dan gaji akhir adalah data per bulan.");
        System.out.println("Jabatan : 1.Manager / 2.Pegawai Tetap / 3.Pegawai nonPNS.");
        System.out.println("ID terdiri dari 3 angka.\n");
        Manager manager[] = new Manager[100];
        PegawaiTetap tetap[] = new PegawaiTetap[100];
        PegawaiTidakTetap ttetap[] = new PegawaiTidakTetap[100];
        int x = -1, y = -1, z = -1;       
        for (int i = 0;; i++) {
            showMenu();
            if(jabatan == 1) {
                x++;
                manager[x] = new Manager(nama, id, jabatan, tahun, istri, anak);
            } else if(jabatan == 2) {
                y++;
                tetap[y] = new PegawaiTetap(nama, id, jabatan, tahun, istri, anak);
            } else {
                z++;
                System.out.print("Jam Lembur            : ");
                int jam = in.nextInt();
                ttetap[z] = new PegawaiTidakTetap(nama, id, jabatan, tahun, istri, anak, jam);
            }
            System.out.print("Tambah data <Y/T> : ");
            String pil = in.next();
            System.out.println();
            if(pil.startsWith("T") || pil.startsWith("t")) break;                
        }
        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("%-8s%-5s%-16s%-11s%-6s%-12s%-12s\n", "NAMA", "ID", "JABATAN", "ISTRI", "ANAK", "AWAL KERJA", "LAMA KERJA(TH)");
        System.out.println("-------------------------------------------------------------------------");
        for (int i = 0; i <= x; i++) System.out.print(manager[i].showSuperData());
        for (int i = 0; i <= y; i++) System.out.print(tetap[i].showSuperData());
        for (int i = 0; i <= z; i++) System.out.print(ttetap[i].showSuperData());
        System.out.println();
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("%-7s%-8s%-11s%-10s%-9s%-12s%-10s\n", "ID", "BONUS", "TUNJANGAN", "TJ.ISTRI", "TJ.ANAK", "TJ.JABATAN", "TOTAL GAJI");
        System.out.println("--------------------------------------------------------------------");
        for (int i = 0; i <= x; i++) System.out.print(manager[i]);
        for (int i = 0; i <= y; i++) System.out.print(tetap[i]);
        System.out.println();
        System.out.println("------------------------------------------");
        System.out.printf("%-5s%-13s%-13s%-12s\n", "ID", "JAM LEMBUR", "GAJI LEMBUR","TOTAL GAJI");
        System.out.println("------------------------------------------");
        for (int i = 0; i <= z; i++) System.out.print(ttetap[i]);
    }
    
    private static void showMenu() {
        Scanner in = new Scanner(System.in);
        System.out.print("Nama                  : ");
        nama = in.next();
        System.out.print("ID                    : ");
        id = in.next();
        System.out.print("Jabatan               : ");
        jabatan = in.nextInt();
        System.out.print("Tahun Masuk           : ");
        tahun = in.nextInt();
        in.nextLine();
        System.out.print("Istri <Ada/Tidak Ada> : ");
        istri = in.nextLine();
        System.out.print("Anak                  : ");
        anak = in.nextInt();
    }
}