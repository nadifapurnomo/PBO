import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static List<akunlonan> Dataakunlonan = new ArrayList<>(); // untuk menyimpan objek dari kelas Akun
    private static List<Lonan> DataLonan = new ArrayList<>();// untuk menyimpan objek dari kelas Lonan

    public static void main(String[] args) throws NumberFormatException, IOException {
        account();
    }

    // clear screen
    private static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // pause program
    private static void pause() {
        System.out.print("Tekan enter untuk kembali...");
        try {
            input.readLine(); // Menunggu sampai pengguna menekan sesuatu
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
    
        // Get non-empty username
        do {
            System.out.print("Username   : ");
            user = input.readLine().trim();
            if (user.isEmpty()) {
                System.out.println("Error: Username tidak boleh kosong.");
            }
        } while (user.isEmpty());
    
        // Get non-empty password
        do {
            System.out.print("Password   : ");
            pass = input.readLine().trim();
            if (pass.isEmpty()) {
                System.out.println("Error: Password tidak boleh kosong.");
            }
        } while (pass.isEmpty());
    
        // Register akun
        akunlonan new_akun = new akunlonan(user, pass);
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
                break;
            }
        }

        if (isLogIn) {
            clear();
            System.out.println("----------------------------------------------------");
            System.out.println("                 Login Succesful!                   ");
            System.out.println("----------------------------------------------------");
            pause();
            mainmenu();
        } else {
            clear();
            System.out.println("----------------------------------------------------");
            System.out.println("             Username / Password Invalid!           ");
            System.out.println("----------------------------------------------------");
            pause();
        }
    }

    // menu akun
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

    // menu crud handphone
    private static void menu() {
        System.out.println("====================================================");
        System.out.println("|                       WELCOME                    |");
        System.out.println("|                      LONAN CELL                  |");
        System.out.println("====================================================");
        System.out.println("|          1. Tambah Data                          |");
        System.out.println("|          2. Tampilkan Data                       |");
        System.out.println("|          3. Edit Data                            |");
        System.out.println("|          4. Hapus Data                           |");
        System.out.println("|          5. Keluar                               |");
        System.out.println("====================================================");
    }

    // main menu
    private static void mainmenu() throws IOException {
        boolean continuemenu = true;
        while (continuemenu) {
            clear();
            menu();
            System.out.print("Masukkan pilihan anda : ");
            try {
                int choose = Integer.parseInt(input.readLine());
    
                switch (choose) {
                    case 1:
                        addadata();
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

    // table akun
    private static void tableacc() {
        System.out.println("====================================================");
        System.out.println("|                     WELCOME                      |");
        System.out.println("|--------------------------------------------------|");
        System.out.println("|                    LONAN CELL                    |");
        System.out.println("====================================================");
    }

    // table tambah data
    private static void tableadddata() {
        System.out.println("====================================================");
        System.out.println("|                    LONAN CELL                    |");
        System.out.println("|--------------------------------------------------|");
        System.out.println("|                    Tambah Data                   |");
        System.out.println("====================================================");
    }

    // table menampilkan data
    private static void showdata() {
        System.out.println("----------------------------------------------------");
        System.out.println("|                    LONAN CELL                    |");
        System.out.println("----------------------------------------------------");
    }

    // table update data
    private static void tableupdate() {
        System.out.println("====================================================");
        System.out.println("|                    LONAN CELL                    |");
        System.out.println("|--------------------------------------------------|");
        System.out.println("|                     Edit Data                    |");
        System.out.println("====================================================");
    }

    // table keluar program
    private static void exitprogram() {
        System.out.println("====================================================");
        System.out.println("|                    LONAN CELL                    |");
        System.out.println("|--------------------------------------------------|");
        System.out.println("|              See u in the next promo !           |");
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

    // menmabah data handphone
    private static void addadata() throws IOException {
        clear();
        tableadddata();
        System.out.print("Merk HP         : ");
        String merkhp = only_abc();
        System.out.print("Warna HP        : ");
        String warnahp = only_abc();
        double hargahp;
        do {
            System.out.print("Harga HP        : ");
            hargahp = only_number();
            if (hargahp < 1) {
                System.out.println("Inputan tidak boleh <1");
            }
        } while (hargahp < 1);

        int stok;
        do {
            System.out.print("Stok HP         : ");
            stok = only_number();
            if (stok < 1) {
                System.out.println("Inputan tidak boleh <1");
            }
        } while (stok < 1);
    
        int tahun;
        do {
            System.out.print("Tahun Rilis     : ");
            tahun = only_number();
            if (tahun < 1) {
                System.out.println("Inputan tidak boleh <1");
            }
        } while (tahun < 1);
    
        Lonan hplonan = new Lonan(merkhp, warnahp, hargahp, stok, tahun);
        DataLonan.add(hplonan);
    
        System.out.println("----------------------------------------------------");
        System.out.println("Data berhasil ditambahkan!");
        System.out.println("");
    }
    

    // menampilkan data handphone
    private static void display() {
        clear();
        if (DataLonan.isEmpty()) {
            System.out.println("----------------------------------------------------");
            System.out.println("                DATA TIDAK TERSEDIA                 ");
            System.out.println("----------------------------------------------------");
        } else
            showdata();
        for (int i = 0; i < DataLonan.size(); i++) {
            Lonan hpLonan = DataLonan.get(i);
            System.out.println("Data " + (i + 1));
            System.out.println("----------------------------------------------------");
            System.out.println("Merk Hp          : " + hpLonan.getMerkHp());
            System.out.println("Warna Hp         : " + hpLonan.getwarna());
            System.out.println("Harga HP         : " + hpLonan.getharga());
            System.out.println("Stok HP          : " + hpLonan.getstok());
            System.out.println("Tahun HP         : " + hpLonan.gettahun());
            System.out.println("----------------------------------------------------");
        }
    }

    // update data handphone
    private static void update_data() throws NumberFormatException, IOException {
        clear();
        display();
    
        if (DataLonan.isEmpty()) {
            return;
        }
    
        display();
        System.out.print("Masukkan ID data yang ingin diupdate : ");
        int no = Integer.parseInt(input.readLine()) - 1; 
    
        if (no >= 0 && no < DataLonan.size()) {
            Lonan hpToEdit = DataLonan.get(no);
            clear();
            tableupdate();
            System.out.print("Merk HP         : ");
            String merkhp = only_abc();
            System.out.print("Warna HP        : ");
            String warnahp = only_abc();
            double hargahp;
            do {
                System.out.print("Harga HP        : ");
                hargahp = only_number();
                if (hargahp < 1) {
                    System.out.println("Inputan tidak boleh <1");
                }
            } while (hargahp < 1);
    
            int stok;
            do {
                System.out.print("Stok HP         : ");
                stok = only_number();
                if (stok < 1) {
                    System.out.println("Inputan tidak boleh <1");
                }
            } while (stok < 1);
        
            int tahun;
            do {
                System.out.print("Tahun Rilis     : ");
                tahun = only_number();
                if (tahun < 1) {
                    System.out.println("Inputan tidak boleh <1");
                }
            } while (tahun < 1);
    
            hpToEdit.MerkHp = merkhp;
            hpToEdit.WarnaHp = warnahp;
            hpToEdit.HargaHp = hargahp;
            hpToEdit.StokHp = stok;
            hpToEdit.TahunHp = tahun;
    
            System.out.println("");
            System.out.println("Data Berhasil diubah !");
        } else {
            System.out.println("Pilihan tidak tersedia.");
        }
    
        System.out.println("----------------------------------------------------");
    }

    private static void delete_data() throws NumberFormatException, IOException {
        showdata();
        display();
    
        if (DataLonan.isEmpty()) {
            return;
        }
        System.out.print("Masukkan ID data yang ingin dihapus : ");
        int no = Integer.parseInt(input.readLine()) - 1; 
        if (no >= 0 && no < DataLonan.size()) {
            DataLonan.remove(no);
            System.out.println("");
            System.out.println("Data berhasil dihapus !");
        } else {
            System.out.println("");
            System.out.println("Pilihan tidak tersedia.");
        }
    
        System.out.println("----------------------------------------------------");
    }
    
}
