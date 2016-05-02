package javaapplication25;

public class Employee {

    private final String nama;
    private final String id;
    private final int jabatan;
    private final String istri;
    private final int anak;
    private final int lamaKerja;
    private final int gajiBulan = 2000000;
    private int bonus = 0;
    private int tunjangan = 0;
    private int tunjanganIstri;
    private int tunjanganAnak;

    public Employee(String nama, String id, int jabatan, String istri, int anak, int awalKerja) {
        this.nama = nama;
        this.id = id;
        this.jabatan = jabatan;
        this.istri = istri;
        this.anak = anak;
        lamaKerja = 2016 - awalKerja;
    }
    
    public String getID() {
        return id;
    }	
    	
    public String getStringJbt() {
        String jbt;
        if(jabatan == 1) jbt = "Manager";
        else if(jabatan == 2) jbt = "Pegawai Tetap";
        else jbt = "Pegawai nonPNS";
        return jbt;
    }
    
    public int getLamaKerja() {
        return lamaKerja * 12;
    }
    
    public int getGajiAwal() {
        return gajiBulan;
    }
    
    public int getBonus() {
        bonusTunjangan();
        return bonus;
    }
    
    public int getTunjangan() {
        bonusTunjangan();
        return tunjangan;
    }
            
    public int bonusTunjangan() {
        if (jabatan == 1 || jabatan == 2) {
            if (lamaKerja >= 1 && lamaKerja <= 5) {
                bonus = 0;
                tunjangan = 0;
            } else if (lamaKerja >= 6 && lamaKerja <= 10) {
                bonus = (int) (0.05 * gajiBulan);
                tunjangan = 0;
            } else {
                bonus = (int) (0.1 * gajiBulan);
                tunjangan = (int) (0.1 * gajiBulan);
            }
        }
        return bonus + tunjangan;
    }    
    
    public int tunjanganIstri() {
        if (jabatan == 1 || jabatan == 2) {
            if (istri.equals("Ada")) tunjanganIstri = (int) (0.1 * (gajiBulan + bonusTunjangan()));
            else tunjanganIstri = 0;
        }
        return tunjanganIstri;
    }
    
    public int tunjanganAnak() {
        if (jabatan == 1 || jabatan == 2) {
            if (anak == 0) tunjanganAnak = 0;
            else if (anak >=1 && anak <=3) tunjanganAnak = (int) (0.15 * (gajiBulan + bonusTunjangan()) * anak);
            else tunjanganAnak = (int) (0.15 * (gajiBulan + bonusTunjangan()) * 3);
        }
        return tunjanganAnak;
    }
    
    @Override
    public String toString() {
        return String.format("%-8s%-5s%-16s%-11s%-6s%-12s%-12s\n", nama, id, getStringJbt(), istri, anak, 2016-lamaKerja, lamaKerja);
    }
}
