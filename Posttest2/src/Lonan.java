public class Lonan {
    
    String MerkHp;
    String WarnaHp;
    double HargaHp;
    int StokHp;
    int TahunHp;

    public Lonan(String merk, String warna, double harga, int stok, int tahun) {
        this.MerkHp = merk;
        this.WarnaHp = warna;
        this.HargaHp = harga;
        this.StokHp = stok;
        this.TahunHp = tahun;
    }

    public String getMerkHp() {
        return this.MerkHp;
    }

    public void setMerkHp(String merk) {
        this.MerkHp = merk;
    }

    public String getwarna() {
        return this.WarnaHp;
    }

    public void setWarnaHp(String warna) {
        this.WarnaHp = warna;
    }

    public double getharga() {
        return this.HargaHp;
    }

    public void setHargaHp(double harga) {
        this.HargaHp = harga;
    }

    public int getstok() {
        return this.StokHp;
    }

    public void setStokHp(int stok) {
        this.StokHp = stok;
    }

    public int gettahun() {
        return this.TahunHp;
    }

    public void setTahunHp(int tahun) {
        this.TahunHp = tahun;
    }
}
