class Android extends HP {
    String androidVersion;

    public Android(String merk, String warna, double harga, int stok, int tahun, String version) {
        super(merk, warna, harga, stok, tahun);
        this.androidVersion = version;
    }

    public String getAndroidVersion() {
        return this.androidVersion;
    }

    public void setAndroidVersion(String version) {
        this.androidVersion = version;
    }
}