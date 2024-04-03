public class Apple extends HP {
    private String iOSVersion;

    public Apple(String merk, String warna, double harga, int stok, int tahun, String version) {
        super(merk, warna, harga, stok, tahun);
        this.iOSVersion = version;
    }

    public String getIOSVersion() {
        return iOSVersion;
    }

    public void setIOSVersion(String version) {
        this.iOSVersion = version;
    }


    // Override dari Class HP
    @Override
    public void printInfo() {
        System.out.println("Merk HP Apple: " + getMerkHp());
        System.out.println("Warna HP: " + getWarnaHp());
        System.out.println("Harga HP: " + getHargaHp());
        System.out.println("Stok HP: " + getStokHp());
        System.out.println("Tahun Rilis: " + getTahunHp());
        System.out.println("Versi iOS: " + iOSVersion);
    }
}
