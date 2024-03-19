public class Lonan {
    
String MerkHp;
String WarnaHp;
double HargaHp;
int StokHp;
int TahunHp;

public Lonan(String merk, String warna,
double harga, int stok, int tahun) {
    this.MerkHp = merk;
    this.WarnaHp = warna;
    this.HargaHp = harga;
    this.StokHp = stok;
    this.TahunHp = tahun;

}
public String getMerkHp() {
    return this.MerkHp;
}
public String getwarna() {
    return this.WarnaHp;
}
public double getharga() {
    return this.HargaHp;
}
public int getstok() {
    return this.StokHp;
}
public int gettahun() {
    return this.TahunHp;
}

}
