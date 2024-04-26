final class Android extends HP {
        private String androidVersion;

        public Android(String merk, String warna, double harga, int stok, int tahun, String version) {
            super(merk, warna, harga, stok, tahun);
            this.androidVersion = version;
        }

        public String getAndroidVersion() {
            return androidVersion;
        }

        public void setAndroidVersion(String version) {
            this.androidVersion = version;
        }


            // Override dari Class HP
        @Override
        public void printInfo() {
            System.out.println("Merk HP Android: " + getMerkHp());
            System.out.println("Warna HP: " + getWarnaHp());
            System.out.println("Harga HP: " + getHargaHp());
            System.out.println("Stok HP: " + getStokHp());
            System.out.println("Tahun Rilis: " + getTahunHp());
            System.out.println("Versi Android: " + androidVersion);
        }
    }
