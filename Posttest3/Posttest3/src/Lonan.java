class HP {
    String MerkHp;
    String WarnaHp;
    double HargaHp;
    int StokHp;
    int TahunHp;

    public HP(String merk, String warna, double harga, int stok, int tahun) {
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

    public String getWarnaHp() {
        return this.WarnaHp;
    }

    public void setWarnaHp(String warna) {
        this.WarnaHp = warna;
    }

    public double getHargaHp() {
        return this.HargaHp;
    }

    public void setHargaHp(double harga) {
        this.HargaHp = harga;
    }

    public int getStokHp() {
        return this.StokHp;
    }

    public void setStokHp(int stok) {
        this.StokHp = stok;
    }

    public int getTahunHp() {
        return this.TahunHp;
    }

    public void setTahunHp(int tahun) {
        this.TahunHp = tahun;
    }
}



