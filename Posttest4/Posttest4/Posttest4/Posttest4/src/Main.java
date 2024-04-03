import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static List<akunlonan> Dataakunlonan = new ArrayList<>();
    private static List<HP> DataLonan = new ArrayList<>();
    // private static List<Android> android = new ArrayList<>();
    // private static List<Apple> apple = new ArrayList<>();
    private static akunlonan currentUser = null;

    public static void main(String[] args) throws IOException {
        // Membuat data dummy untuk HP Android
        Android android1 = new Android("Samsung", "Hitam", 1000.0, 10, 2022, "Android 11");
        Android android2 = new Android("Xiaomi", "Biru", 2000.0, 8, 2023, "MIUI 12");
        Android android3 = new Android("Google", "Putih", 3000.0, 5, 2022, "Android 12");

        // Membuat data dummy untuk HP Apple
        Apple apple1 = new Apple("iPhone", "Gold", 5000.0, 15, 2022, "iOS 15");
        Apple apple2 = new Apple("iPhone", "Silver", 5000.0, 12, 2023, "iOS 16");
        Apple apple3 = new Apple("iPhone", "Space Gray", 4800.0, 10, 2022, "iOS 15");

        // Menambahkan data dummy ke dalam list
        DataLonan.add(android1);
        DataLonan.add(android2);
        DataLonan.add(android3);

        DataLonan.add(apple1);
        DataLonan.add(apple2);
        DataLonan.add(apple3);
        Dataakunlonan.add(new akunlonan("admin", "admin", akunlonan.Role.ADMIN));
        account();
    }

    // clear screen
    private static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // pause program
    public static void pause() {
        System.out.print("Tekan enter untuk kembali...");
        try {
            input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // register
    private static void register() throws IOException {
        clear();
        System.out.println("----------------------------------------------------");
        System.out.println("|                    LONAN CELL                    |");
        System.out.println("----------------------------------------------------");
        System.out.println("|                     REGISTER                     |");
        System.out.println("----------------------------------------------------");

        String user = "";
        String pass = "";

        do {
            System.out.print("Username   : ");
            user = input.readLine().trim();
            if (user.isEmpty()) {
                System.out.println("Error: Username tidak boleh kosong.");
            }
        } while (user.isEmpty());

        do {
            System.out.print("Password   : ");
            pass = input.readLine().trim();
            if (pass.isEmpty()) {
                System.out.println("Error: Password tidak boleh kosong.");
            }
        } while (pass.isEmpty());

        akunlonan new_akun = new akunlonan(user, pass, akunlonan.Role.PELANGGAN);
        Dataakunlonan.add(new_akun);

        System.out.println("----------------------------------------------------");
        System.out.println("                Account Registered                  ");
        System.out.println("----------------------------------------------------");
        System.out.println("                   Please Login                     ");
        System.out.println("");
        pause();
        login();
    }

    // login
    private static void login() throws NumberFormatException, IOException {
        clear();
        System.out.println("----------------------------------------------------");
        System.out.println("|                    LONAN CELL                    |");
        System.out.println("----------------------------------------------------");
        System.out.println("|                      LOGIN                       |");
        System.out.println("----------------------------------------------------");
        System.out.print("Username   : ");
        String userp = input.readLine();
        System.out.print("Password   : ");
        String pwp = input.readLine();
        boolean isLogIn = false;
        for (akunlonan Acc : Dataakunlonan) {
            if (Acc.getusername().equals(userp) && Acc.getPass().equals(pwp)) {
                isLogIn = true;
                currentUser = Acc;
                break;
            }
        }

        if (isLogIn) {
            clear();
            System.out.println("----------------------------------------------------");
            System.out.println("                 Login Succesful!                   ");
            System.out.println("----------------------------------------------------");
            pause();
            if (currentUser.getRole() == akunlonan.Role.ADMIN) {
                adminMenu();
            } else {
                mainmenu();
            }
        } else {
            clear();
            System.out.println("----------------------------------------------------");
            System.out.println("             Username / Password Invalid!           ");
            System.out.println("----------------------------------------------------");
            pause();
        }
    }

    // account menu
    private static void account() throws IOException {
        while (true) {
            clear();
            tableacc();
            System.out.println("|         1. Register                              |");
            System.out.println("|         2. Login                                 |");
            System.out.println("|         3. Exit                                  |");
            System.out.println("====================================================");
            System.out.print("Masukkan pilihan anda : ");
            try {
                int choose = Integer.parseInt(input.readLine());
                switch (choose) {
                    case 1:
                        register();
                        break;
                    case 2:
                        login();
                        break;
                    case 3:
                        clear();
                        exitprogram();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Pilihan tidak tersedia.");
                        pause();
                }
            } catch (NumberFormatException e) {
                System.out.println("Inputan harus berupa bilangan bulat.");
                pause();
            }
        }
    }

    // menu for crud Handphone products
    private static void menu() {
        System.out.println("====================================================");
        System.out.println("|                    WELCOME ADMIN                 |");
        System.out.println("|                     LONAN CELL                   |");
        System.out.println("====================================================");
        System.out.println("|          1. Tambah Data                          |");
        System.out.println("|          2. Tampilkan Data                       |");
        System.out.println("|          3. Edit Data                            |");
        System.out.println("|          4. Hapus Data                           |");
        System.out.println("|          5. Keluar                               |");
        System.out.println("====================================================");
    }

    private static void adminMenu() throws IOException {
        boolean continuemenu = true;
        while (continuemenu) {
            clear();
            menu();
            System.out.print("Masukkan pilihan anda : ");
            try {
                int choose = Integer.parseInt(input.readLine());

                switch (choose) {
                    case 1:
                        addData();
                        pause();
                        break;
                    case 2:
                        display();
                        pause();
                        break;
                    case 3:
                        update_data();
                        pause();
                        break;
                    case 4:
                        delete_data();
                        pause();
                        break;
                    case 5:
                        account();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Pilihan tidak tersedia.");
                        pause();
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Inputan harus berupa angka.");
                pause();
            }
        }
    }

    // ----------------------------------- DAERAH PELANGGAN --------------------------------

    private static void lihatProduk() {
        clear();
        display();
        pause();
    }

    // Beli HP
    private static void beliHp() throws IOException {
        clear();
        if (DataLonan.isEmpty()) {
            System.out.println("----------------------------------------------------");
            System.out.println(" DATA TIDAK TERSEDIA ");
            System.out.println("----------------------------------------------------");
            pause();
            return;
        }
    
        display();
        int idProduk;
        boolean validID = false; 
        do {
            System.out.print("Masukkan ID produk yang ingin dibeli : ");
            idProduk = -1;
            try {
                idProduk = Integer.parseInt(input.readLine());
    
                HP hpDibeli = null;
                if (idProduk >= 1 && idProduk <= DataLonan.size()) {
                    hpDibeli = DataLonan.get(idProduk - 1);
                } else if (idProduk > DataLonan.size() && idProduk <= DataLonan.size() + DataLonan.size()) {
                    hpDibeli = DataLonan.get(idProduk - DataLonan.size() - 1);
                } else {
                    System.out.println("ID produk tidak valid. Harap masukkan ID yang benar.");
                    pause();
                    return; 
                }
    
                System.out.println("");
                System.out.println("Berikut produk yang kamu pilih:");
                System.out.println("Merk HP : " + hpDibeli.getMerkHp());
                System.out.println("Warna HP : " + hpDibeli.getWarnaHp());
                System.out.println("Harga HP : " + hpDibeli.getHargaHp());
    
                int jumlahDibeli = 0;
                do {
                    System.out.print("Masukkan jumlah stok yang ingin dibeli : ");
                    try {
                        jumlahDibeli = Integer.parseInt(input.readLine());
                        if (jumlahDibeli <= 0 || jumlahDibeli > hpDibeli.getStokHp()) {
                            System.out.println("Jumlah stok yang diminta tidak valid. Harap masukkan jumlah yang benar.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Format jumlah stok tidak valid. Harap masukkan angka.");
                    }
                } while (jumlahDibeli <= 0 || jumlahDibeli > hpDibeli.getStokHp());
    
                for (int i = 0; i < jumlahDibeli; i++) {
                    currentUser.tambahKeKeranjang(hpDibeli);
                }
                System.out.println("Pembelian berhasil! Produk telah ditambahkan ke dalam keranjang belanja.");
    
                validID = true; 
            } catch (NumberFormatException e) {
                System.out.println("Format ID tidak valid. Harap masukkan angka.");
                pause();
                return; 
            }
        } while (!validID);
    }
    
    
    
    

    private static void pembayaran() {
        if (currentUser != null) {
            currentUser.prosesPembayaran();
        } else {
            System.out.println("Silakan login terlebih dahulu.");
        }
    }

    // melihat keranjang pemesanan
    private static void lihatKeranjang() {
        if (currentUser != null) {
            currentUser.lihatKeranjang();
        } else {
            System.out.println("Silakan login terlebih dahulu.");
        }
        pause();
    }

    private static void menuPelanggan() {
        System.out.println("====================================================");
        System.out.println("|                      WELCOME                     |");
        System.out.println("|                     LONAN CELL                   |");
        System.out.println("====================================================");
        System.out.println("|          1. Lihat Produk                         |");
        System.out.println("|          2. Beli HP                              |");
        System.out.println("|          3. Pembayaran                           |");
        System.out.println("|          4. Lihat Keranjang                      |");
        System.out.println("|          5. Keluar                               |");
        System.out.println("====================================================");
    }

    // main menu
    static void mainmenu() throws IOException {
        boolean continuemenu = true;
        while (continuemenu) {
            clear();
            menuPelanggan();
            System.out.print("Masukkan pilihan anda : ");
            try {
                int choose = Integer.parseInt(input.readLine());

                switch (choose) {
                    case 1:
                        lihatProduk();
                        break;
                    case 2:
                        beliHp();
                        break;
                    case 3:
                        pembayaran();
                        break;
                    case 4:
                        lihatKeranjang();
                        break;
                    case 5:
                        account();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Pilihan tidak tersedia.");
                        pause();
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Inputan harus berupa angka.");
                pause();
            }
        }
    }

    // ----------------------------------- AKHIR DAERAH PELANGGAN --------------------------------

    // table akun
    private static void tableacc() {
        System.out.println("====================================================");
        System.out.println("|                     WELCOME                      |");
        System.out.println("|--------------------------------------------------|");
        System.out.println("|                    LONAN CELL                    |");
        System.out.println("====================================================");
    }

    // table menambahkan data handphone
    private static void tableadddata() {
        System.out.println("====================================================");
        System.out.println("|                    LONAN CELL                    |");
        System.out.println("|--------------------------------------------------|");
        System.out.println("|                    Tambah Data                   |");
        System.out.println("====================================================");
    }

    // table menampilkan data handphone
    private static void showdata() {
        System.out.println("----------------------------------------------------");
        System.out.println("|                    LONAN CELL                    |");
        System.out.println("----------------------------------------------------");
    }

    // table update data handphone
    private static void tableupdate() {
        System.out.println("====================================================");
        System.out.println("|                    LONAN CELL                    |");
        System.out.println("|--------------------------------------------------|");
        System.out.println("|                     Edit Data                    |");
        System.out.println("====================================================");
    }

    // table keluar program lonan
    private static void exitprogram() {
        System.out.println("====================================================");
        System.out.println("|                    LONAN CELL                    |");
        System.out.println("|--------------------------------------------------|");
        System.out.println("|             See u in the next promo !            |");
        System.out.println("====================================================");
    }

    // only string (inputan hanya bisa huruf)
    private static String only_abc() throws IOException {
        String fillString = "";
        while (true) {
            String inputString = input.readLine();
            if (inputString.matches("[a-zA-Z]+")) {
                fillString = inputString;
                break;
            } else {
                System.out.println("");
                System.err.print("Inputan harus berupa huruf: ");
            }
        }
        return fillString;
    }

    // only integer (inputan hanya bisa angka)
    private static int only_number() throws IOException {
        int fillint = 0;
        while (true) {
            String inputString = input.readLine();
            if (inputString.matches("\\d+")) {
                fillint = Integer.parseInt(inputString);
                break;
            } else {
                System.out.println("");
                System.err.print("Inputan harus berupa angka: ");
            }
        }
        return fillint;
    }

    // Menambahkan data handphone

    private static void addData() throws IOException {
        clear();
        tableadddata();

        // Input data HP
        System.out.print("Merk HP         : ");
        String merkhp = only_abc();
        System.out.print("Warna HP        : ");
        String warnahp = only_abc();
        double hargahp;
        do {
            System.out.print("Harga HP        : ");
            hargahp = only_number();
            if (hargahp < 1) {
                System.out.println("Inputan tidak boleh < 1");
            }
        } while (hargahp < 1);

        int stok;
        do {
            System.out.print("Stok HP         : ");
            stok = only_number();
            if (stok < 1) {
                System.out.println("Inputan tidak boleh < 1");
            }
        } while (stok < 1);

        int tahun;
        do {
            System.out.print("Tahun Rilis     : ");
            tahun = only_number();
            if (tahun < 1) {
                System.out.println("Inputan tidak boleh < 1");
            }
        } while (tahun < 1);

        String jenis;
        do {
            System.out.print("Jenis HP (Android/Apple): ");
            jenis = input.readLine().trim().toLowerCase();
            if (jenis.isEmpty()) {
                System.out.println("Mohon masukkan jenis HP.");
            } else if (!jenis.equals("android") && !jenis.equals("apple")) {
                System.out.println("Jenis HP tidak valid.");
            }
        } while (jenis.isEmpty() || (!jenis.equals("android") && !jenis.equals("apple")));

        // Buat objek HP sesuai jenis yang dimasukkan pengguna
        if (jenis.equals("android")) {
            String versiAndroid = "";
            do {
                System.out.print("Versi Android       : ");
                versiAndroid = input.readLine().trim();
                if (versiAndroid.isEmpty()) {
                    System.out.println("Versi Android tidak boleh kosong. Silakan masukkan kembali.");
                }
            } while (versiAndroid.isEmpty());

            Android hp = new Android(merkhp, warnahp, hargahp, stok, tahun, versiAndroid);
            DataLonan.add(hp);
        } else if (jenis.equals("apple")) {
            String versiiOS = "";
            do {
                System.out.print("Versi iOS           : ");
                versiiOS = input.readLine().trim();
                if (versiiOS.isEmpty()) {
                    System.out.println("Versi iOS tidak boleh kosong. Silakan masukkan kembali.");
                }
            } while (versiiOS.isEmpty());

            Apple hp = new Apple(merkhp, warnahp, hargahp, stok, tahun, versiiOS);
            DataLonan.add(hp);
        } else {
            System.out.println("Jenis HP tidak valid.");
            return;
        }

        System.out.println("----------------------------------------------------");
        System.out.println("Data berhasil ditambahkan!");
        System.out.println("");
    }

    private static String selectedHPType = "";

    // Menampilkan informasi HP
    private static void display() {
        clear();
        boolean validChoice;
        do {
            validChoice = true;
            if (DataLonan.isEmpty() && DataLonan.isEmpty()) {
                System.out.println("----------------------------------------------------");
                System.out.println("                 DATA TIDAK TERSEDIA                ");
                System.out.println("----------------------------------------------------");
            } else {
                showdata();
                System.out.println("----------------------------------------------------");
                System.out.println("                  PILIH JENIS HP                    ");
                System.out.println("----------------------------------------------------");
                System.out.println("1. Data HP Apple                                    ");
                System.out.println("2. Data HP Android                                  ");
                System.out.println("----------------------------------------------------");
                System.out.print("Pilih jenis HP (1/2): ");

                try {
                    int choice = Integer.parseInt(input.readLine());
                    switch (choice) {
                        case 1:
                            selectedHPType = "apple";
                            displayApple();
                            break;
                        case 2:
                            selectedHPType = "android";
                            displayAndroid();
                            break;
                        default:
                            System.out.println("Pilihan tidak valid.");
                            validChoice = false; 
                            break;
                    }
                } catch (IOException | NumberFormatException e) {
                    System.out.println("Terjadi kesalahan saat membaca input.");
                    validChoice = false; 
                }
            }
        } while (!validChoice);
    }

    // Menampilkan informasi HP Android
private static void displayAndroid() {
    System.out.println("----------------------------------------------------");
    System.out.println("                 Data HP Android                    ");
    System.out.println("----------------------------------------------------");
    if (DataLonan.isEmpty()) {
        System.out.println("Data HP Android tidak tersedia.");
    } else {
        for (int i = 0; i < DataLonan.size(); i++) {
            HP hp = DataLonan.get(i);
            if (hp instanceof Android) { 
                Android androidPhone = (Android) hp;
                int id = androidPhone.getId(); 
                System.out.println("ID HP: " + id);
                androidPhone.printInfo("Android", androidPhone.getAndroidVersion());
                System.out.println("----------------------------------------------------");
            }
        }
    }
}

// Menampilkan informasi HP Apple
private static void displayApple() {
    System.out.println("----------------------------------------------------");
    System.out.println("                 Data HP Apple                      ");
    System.out.println("----------------------------------------------------");
    if (DataLonan.isEmpty()) {
        System.out.println("Data HP Apple tidak tersedia.");
    } else {
        for (int i = 0; i < DataLonan.size(); i++) {
            HP hp = DataLonan.get(i);
            if (hp instanceof Apple) { 
                Apple applePhone = (Apple) hp;
                int id = applePhone.getId(); 
                System.out.println("ID HP: " + id);
                applePhone.printInfo();
                System.out.println("----------------------------------------------------");
            }
        }
    }
}





    private static HP findHPById(int id) {
        for (HP hp : DataLonan) {
            if (hp.getId() == id) {
                return hp;
            }
        }
        for (HP hp : DataLonan) {
            if (hp.getId() == id) {
                return hp;
            }
        }
        return null;
    }

    private static void update_data() throws NumberFormatException, IOException {
        display();

        if (DataLonan.isEmpty() && DataLonan.isEmpty()) {
            System.out.println("Data HP Android dan Apple tidak tersedia.");
            return;
        }

        System.out.print("Masukkan ID data yang ingin diupdate : ");
        int id;
        try {
            id = Integer.parseInt(input.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Masukkan ID dalam bentuk angka.");
            return;
        }

        // Temukan HP sesuai ID
        HP hpToEdit = findHPById(id);

        if (hpToEdit != null) {
            // Periksa tipe HP yang dipilih sebelumnya
            String jenis = hpToEdit instanceof Android ? "android" : "apple";

            // Periksa apakah jenis HP yang dipilih sebelumnya sesuai dengan tipe HP yang tersedia
            if (!jenis.equals(selectedHPType)) {
                System.out.println("Anda tidak dapat mengedit data jenis HP yang berbeda.");
                return;
            }

            clear();
            tableupdate();
            System.out.print("Merk HP         : ");
            String merkhp = only_abc();
            System.out.print("Warna HP        : ");
            String warnahp = only_abc();
            double hargahp;
            do {
                System.out.print("Harga HP        : ");
                try {
                    hargahp = Double.parseDouble(input.readLine());
                    if (hargahp < 1) {
                        System.out.println("Harga harus lebih dari 0.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Masukkan harga dalam bentuk angka.");
                    hargahp = -1; 
                }
            } while (hargahp < 1);

            int stok;
            do {
                System.out.print("Stok HP         : ");
                try {
                    stok = Integer.parseInt(input.readLine());
                    if (stok < 1) {
                        System.out.println("Stok harus lebih dari 0.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Masukkan stok dalam bentuk angka.");
                    stok = -1; 
                }
            } while (stok < 1);

            int tahun;
            do {
                System.out.print("Tahun Rilis     : ");
                try {
                    tahun = Integer.parseInt(input.readLine());
                    if (tahun < 1) {
                        System.out.println("Tahun rilis harus lebih dari 0.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Masukkan tahun dalam bentuk angka.");
                    tahun = -1; 
                }
            } while (tahun < 1);

            if (jenis.equals("android")) {
                System.out.print("Versi Android       : ");
                String versiAndroid = "";
                do {
                    versiAndroid = input.readLine().trim();
                    if (versiAndroid.isEmpty()) {
                        System.out.println("Versi Android tidak boleh kosong. Silakan masukkan kembali.");
                    }
                } while (versiAndroid.isEmpty());

                Android androidPhone = (Android) hpToEdit;
                androidPhone.setMerkHp(merkhp);
                androidPhone.setWarnaHp(warnahp);
                androidPhone.setHargaHp(hargahp);
                androidPhone.setStokHp(stok);
                androidPhone.setTahunHp(tahun);
                androidPhone.setAndroidVersion(versiAndroid);
            } else if (jenis.equals("apple")) {
                System.out.print("Versi iOS           : ");
                String versiiOS = "";
                do {
                    versiiOS = input.readLine().trim();
                    if (versiiOS.isEmpty()) {
                        System.out.println("Versi iOS tidak boleh kosong. Silakan masukkan kembali.");
                    }
                } while (versiiOS.isEmpty());

                Apple applePhone = (Apple) hpToEdit;
                applePhone.setMerkHp(merkhp);
                applePhone.setWarnaHp(warnahp);
                applePhone.setHargaHp(hargahp);
                applePhone.setStokHp(stok);
                applePhone.setTahunHp(tahun);
                applePhone.setIOSVersion(versiiOS);
            }

            System.out.println("Data berhasil diperbarui!");
        } else {
            System.out.println("Data dengan ID tersebut tidak ditemukan.");
        }
    }

    // Hapus data hp berdasarkan ID
    private static void delete_data() throws IOException {
        display();

        if (DataLonan.isEmpty() && DataLonan.isEmpty()) {
            System.out.println("Data HP Android dan Apple tidak tersedia.");
            return;
        }

        System.out.print("Masukkan ID data yang ingin dihapus : ");
        int id;
        try {
            id = Integer.parseInt(input.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Masukkan ID dalam bentuk angka.");
            return;
        }

        HP hpToDelete = findHPById(id);

        if (hpToDelete != null) {
            String jenis = hpToDelete instanceof Android ? "android" : "apple";

            if (jenis.equals("android")) {
                for (int i = 0; i < DataLonan.size(); i++) {
                    Android androidPhone = (Android) DataLonan.get(i);
                    if (androidPhone.getId() == id) {
                        DataLonan.remove(i);
                        break;
                    }
                }
            } else if (jenis.equals("apple")) {
                for (int i = 0; i < DataLonan.size(); i++) {
                    Apple applePhone = (Apple) DataLonan.get(i);
                    if (applePhone.getId() == id) {
                        DataLonan.remove(i);
                        break;
                    }
                }
            }

            System.out.println("Data berhasil dihapus!");
        } else {
            System.out.println("Data dengan ID tersebut tidak ditemukan.");
        }
    }

}
