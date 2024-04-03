class HP {
    private static int idCounter = 1;
    private int id;
    String MerkHp;
    String WarnaHp;
    double HargaHp;
    int StokHp;
    int TahunHp;

    public HP(String merk, String warna, double harga, int stok, int tahun) {
        this.id = idCounter++;
        this.MerkHp = merk;
        this.WarnaHp = warna;
        this.HargaHp = harga;
        this.StokHp = stok;
        this.TahunHp = tahun;
    }

    public int getId() {
        return id;
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
     
    

    public void printInfo() {
        // Cetak informasi umum tentang HP
        System.out.println("Merk HP: " + MerkHp);
        System.out.println("Warna HP: " + WarnaHp);
        System.out.println("Harga HP: " + HargaHp);
        System.out.println("Stok HP: " + StokHp);
        System.out.println("Tahun Rilis: " + TahunHp);
    }

    // Overloading metode printInfo() dengan parameter tambahan jenis
    public void printInfo(String jenis) {
        System.out.println("Jenis HP: " + jenis);
        System.out.println("Merk HP: " + MerkHp);
        System.out.println("Warna HP: " + WarnaHp);
        System.out.println("Harga HP: " + HargaHp);
        System.out.println("Stok HP: " + StokHp);
        System.out.println("Tahun Rilis: " + TahunHp);
    }

    // Overloading metode printInfo() dengan parameter tambahan
    public void printInfo(String jenis, String versi) {
        System.out.println("Jenis HP: " + jenis);
        System.out.println("Merk HP: " + MerkHp);
        System.out.println("Warna HP: " + WarnaHp);
        System.out.println("Harga HP: " + HargaHp);
        System.out.println("Stok HP: " + StokHp);
        System.out.println("Tahun Rilis: " + TahunHp);

        // Cetak informasi tambahan sesuai dengan jenis HP
        if (jenis.equalsIgnoreCase("Apple")) {
            System.out.println("Versi iOS: " + versi);
        } else if (jenis.equalsIgnoreCase("Android")) {
            System.out.println("Versi Android: " + versi);
        }
    }
    
    // Overloading untuk struk pesanan atau data pesanan
    public void print(String nama) {
        System.out.println("Pesanan atas nama " + nama + " (HP)");
    }

    public void print(int nomor) {
        System.out.println("Nomor pesanan HP: " + nomor);
    }

    // Implementasi Override 
    @Override
    public String toString() {
        return "Merk HP: " + MerkHp + ", Warna HP: " + WarnaHp;
    }
}
   