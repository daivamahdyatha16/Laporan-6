package javaapplication25;

public class PegawaiTetap extends Employee {
    
    private int gajiAkhir;
    
    public PegawaiTetap(String nama, String id, int jabatan, int awalKerja, String istri, int anak) {
        super(nama, id, jabatan, istri, anak, awalKerja);
    }	
    
    public int gajiAkhir() {
        gajiAkhir = super.getGajiAwal() + super.bonusTunjangan() + super.tunjanganIstri() + super.tunjanganAnak();
        return gajiAkhir;
    }
    
    public String showSuperData() {
        return super.toString();
    }
    
    @Override
    public String toString() {
        return String.format("%-5s%7d%12d%10d%9d%12d%12d\n", super.getID(), super.getBonus(), super.getTunjangan(), super.tunjanganIstri(), super.tunjanganAnak(), 0, gajiAkhir());
    }    
}
