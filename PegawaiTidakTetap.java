package javaapplication25;

public class PegawaiTidakTetap extends Employee {
    
    private final int jamLembur;
    private int gajiLembur;
    private int gajiAkhir;
    	
    public PegawaiTidakTetap(String nama, String id, int jabatan, int awalKerja, String istri, int anak, int jamLembur) {
        super(nama, id, jabatan, istri, anak, awalKerja);
        this.jamLembur = jamLembur;
    }
    
    public int gajiLembur() {
        gajiLembur = jamLembur * 10000;
        return gajiLembur;
    }
    
    public int gajiAkhir() {
        if(jamLembur == 0) gajiAkhir = super.getGajiAwal();
        else gajiAkhir = super.getGajiAwal() + gajiLembur();
        return gajiAkhir;
    }
    
    public String showSuperData() {
        return super.toString();
    }
    
    @Override
    public String toString() {
        return String.format("%-5s%10d%14d%12d\n", super.getID(), jamLembur, gajiLembur(), gajiAkhir());
    }
}
