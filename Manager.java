package javaapplication25;

public class Manager extends Employee {
    
    private int tunjanganJabatan;
    private int gajiAkhir;
    	
    public Manager(String nama, String id, int jabatan, int awalKerja, String istri, int anak) {
        super(nama, id, jabatan, istri, anak, awalKerja);
    }
   
    public int tunjanganJabatan() {
        tunjanganJabatan = (int) (0.1 * (super.getGajiAwal() + super.bonusTunjangan()));
        return tunjanganJabatan;
    }
    
    public int gajiAkhir() {
        gajiAkhir =  (super.getGajiAwal() + super.bonusTunjangan() + super.tunjanganIstri() + super.tunjanganAnak() + tunjanganJabatan());
        return gajiAkhir;
    }
    
    public String showSuperData() {
        return super.toString();
    }
    
    @Override
    public String toString() {
        return String.format("%-5s%7d%12d%10d%9d%12d%12d\n", super.getID(), super.getBonus(), super.getTunjangan(), super.tunjanganIstri(), super.tunjanganAnak(), tunjanganJabatan(), gajiAkhir());
    }
}
