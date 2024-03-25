class Apple extends HP {
    String iOSVersion;

    public Apple(String merk, String warna, double harga, int stok, int tahun, String version) {
        super(merk, warna, harga, stok, tahun);
        this.iOSVersion = version;
    }

    public String getIOSVersion() {
        return this.iOSVersion;
    }

    public void setIOSVersion(String version) {
        this.iOSVersion = version;
    }
}
