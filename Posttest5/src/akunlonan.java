import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class akunlonan {
    protected String username;
    protected String password;
    private Role role;
    private Map<HP, Integer> keranjangPemesanan;
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    akunlonan(String user, String pass, Role role) {
        this.username = user;
        this.password = pass;
        this.role = role;
        this.keranjangPemesanan = new HashMap<>();
    }

    public String getusername() {
        return username;
    }

    public String getPass() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void tambahKeKeranjang(HP hp) {
        keranjangPemesanan.put(hp, keranjangPemesanan.getOrDefault(hp, 0) + 1);
        System.out.println("Produk " + hp.getMerkHp() + " telah ditambahkan ke keranjang.");
    }

    public void lihatKeranjang() {
        if (keranjangPemesanan.isEmpty()) {
            System.out.println("Keranjang pemesanan kosong.");
        } else {
            System.out.println("------------------------------------------------");
            System.out.println("|        Isi Keranjang Pemesanan               |");
            System.out.println("|----------------------------------------------|");
            System.out.println("| Nama HP                | Jumlah | Harga      |");
            System.out.println("|------------------------|--------|------------|");
            for (Map.Entry<HP, Integer> entry : keranjangPemesanan.entrySet()) {
                HP hp = entry.getKey();
                int jumlah = entry.getValue();
                System.out.printf("| %-23s | %-6d | Rp %-8.2f |%n", hp.getMerkHp(), jumlah, hp.getHargaHp());
            }
            System.out.println("------------------------------------------------");
        }
    }

    public void prosesPembayaran() {
        if (keranjangPemesanan.isEmpty()) {
            System.out.println("Keranjang pemesanan kosong.");
            Main.pause();
            return;
        }
    
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            double totalPembelian = 0;
            for (Map.Entry<HP, Integer> entry : keranjangPemesanan.entrySet()) {
                HP hp = entry.getKey();
                int jumlah = entry.getValue();
                totalPembelian += hp.getHargaHp() * jumlah;
            }
    
            System.out.println("Total Pembelian: Rp " + totalPembelian);
    
            double jumlahTunai = 0;
            boolean validInput = false;
            do {
                System.out.print("Masukkan jumlah uang tunai: Rp ");
                try {
                    jumlahTunai = Double.parseDouble(reader.readLine());
                    validInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("Format jumlah uang tunai tidak valid. Harap masukkan angka.");
                } catch (IOException e) {
                    System.out.println("Terjadi kesalahan saat membaca input.");
                }
    
            } while (!validInput);
    
            if (jumlahTunai < totalPembelian) {
                System.out.println("Jumlah uang tunai kurang dari total pembelian.");
            } else {
                double kembalian = jumlahTunai - totalPembelian;
                System.out.println("Pembayaran berhasil.");
                System.out.println("Kembalian: Rp " + kembalian);
                keranjangPemesanan.clear();
            }
    
            System.out.print("Tekan enter untuk kembali...");
            input.readLine();
            Main.mainmenu();
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca input.");
        }
    }
    
    
    enum Role {
        PELANGGAN,
        ADMIN
    }
}
