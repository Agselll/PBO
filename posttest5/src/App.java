import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

interface DonasiService {
    void tampilkanStatistikDonasi();
    int hitungTotalDonasi();
}


public class App implements DonasiService{
    static ArrayList<Donasi> dataDonasi = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int totalDonasi = 0; // Variabel static untuk menyimpan jumlah total donasi

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tampilkan Donasi");
            System.out.println("2. Tambah Donasi");
            System.out.println("3. Update Donasi");
            System.out.println("4. Hapus Donasi");
            System.out.println("5. Tampilkan Statistik Donasi");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();  // Membersihkan buffer

            switch (pilihan) {
                case 1:
                    tampilkanDonasi();
                    break;
                case 2:
                    tambahDonasi();
                    break;
                case 3:
                    updateDonasi();
                    break;
                case 4:
                    hapusDonasi();
                    break;
                case 5:
                    tampilkanStatistikDonasi(); // Memanggil method dari interface
                    break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan program donasi.");
                    System.exit(0);
                default:
                    System.out.println("Menu tidak valid. Silakan pilih menu yang sesuai.");
            }
        }
    }

    public static void tambahDonasi() {
        System.out.println("Jenis donasi:");
        System.out.println("1. Uang");
        System.out.println("2. Barang");
        System.out.println("3. Makanan");
        System.out.print("Pilih jenis donasi: ");
        int jenisDonasi = scanner.nextInt();
        scanner.nextLine();  // Membersihkan buffer

        System.out.print("Masukkan nama donatur: ");
        String nama = scanner.nextLine();

        if (jenisDonasi == 1) {
            System.out.print("Masukkan kode donasi: ");
            int kode = scanner.nextInt();
            System.out.print("Masukkan nominal uang: ");
            int nominal = scanner.nextInt();
            scanner.nextLine();  // Membersihkan buffer
            Donasi donasiBaru = new DonasiUang(kode, nama, nominal);
            dataDonasi.add(donasiBaru);
            System.out.println("Donasi uang berhasil ditambahkan.");
        } else if (jenisDonasi == 2) {
            System.out.print("Masukkan kode donasi: ");
            int kode = scanner.nextInt();
            System.out.print("Masukkan jumlah barang: ");
            int jumlahBarang = scanner.nextInt();
            scanner.nextLine();  // Membersihkan buffer
            System.out.print("Masukkan nama barang: ");
            String namaBarang = scanner.nextLine();
            Donasi donasiBaru = new DonasiBarang(kode,nama, jumlahBarang, namaBarang);
            dataDonasi.add(donasiBaru);
            System.out.println("Donasi barang berhasil ditambahkan.");
        } else if (jenisDonasi == 3) {
            System.out.print("Masukkan kode donasi: ");
            int kode = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Masukkan jenis makanan: ");
            String jenisMakanan = scanner.nextLine();
            System.out.print("Masukkan jumlah makanan: ");
            int jumlahMakanan = scanner.nextInt();
            scanner.nextLine();  // Membersihkan buffer
            System.out.print("Masukkan nama makanan: ");
            String namaMakanan = scanner.nextLine();
            Donasi donasiBaru = new DonasiMakanan(kode,nama, jumlahMakanan, namaMakanan, jenisMakanan);
            dataDonasi.add(donasiBaru);
            System.out.println("Donasi makanan berhasil ditambahkan.");
        } else {
            System.out.println("Pilihan tidak valid. Donasi gagal ditambahkan.");
        }
        catch (InputMismatchException e) {
        System.out.println("Input tidak valid. Harap masukkan angka.");
        scanner.nextLine(); // Membersihkan buffer
    }
    }

    public static void tampilkanDonasi() {
        if (dataDonasi.isEmpty()) {
            System.out.println("Belum ada data donasi.");
        } else {
            System.out.println("Data Donasi:");
            for (int i = 0; i < dataDonasi.size(); i++) {
                System.out.println((i + 1) + ". " + dataDonasi.get(i));
            }
        }
    }

    public static void updateDonasi() {
        tampilkanDonasi();
        if (dataDonasi.isEmpty()) {
            System.out.println("Tidak ada data donasi untuk diperbarui.");
            return;
        }
    
        System.out.print("Masukkan nomor indeks donasi yang ingin diperbarui: ");
        int nomor = scanner.nextInt();
        scanner.nextLine();  // Membersihkan buffer
    
        if (nomor < 1 || nomor > dataDonasi.size()) {
            System.out.println("Nomor donasi tidak valid.");
            return;
        }
    
        Donasi donasi = dataDonasi.get(nomor - 1);
        if (donasi instanceof DonasiUang) {
            System.out.print("Masukkan nominal uang baru: ");
            int nominal = scanner.nextInt();
            scanner.nextLine();  // Membersihkan buffer
            ((DonasiUang) donasi).setNominal(nominal);
            System.out.println("Data donasi uang berhasil diperbarui.");
        } else if (donasi instanceof DonasiBarang) {
            System.out.print("Masukkan jumlah barang baru: ");
            int jumlahBarang = scanner.nextInt();
            scanner.nextLine();  // Membersihkan buffer
            ((DonasiBarang) donasi).setJumlahBarang(jumlahBarang);
            System.out.print("Masukkan nama barang baru: ");
            String namaBarang = scanner.nextLine();
            ((DonasiBarang) donasi).setNamaBarang(namaBarang);
            System.out.println("Data donasi barang berhasil diperbarui.");
        } else if (donasi instanceof DonasiMakanan) {
            // Memanggil metode overload baru untuk donasi makanan
            System.out.print("Masukkan jumlah makanan baru: ");
            int jumlahMakanan = scanner.nextInt();
            scanner.nextLine();  // Membersihkan buffer
            System.out.print("Masukkan nama makanan baru: ");
            String namaMakanan = scanner.nextLine();
            ((DonasiMakanan) donasi).updateDonasi(jumlahMakanan, namaMakanan);
            System.out.println("Data donasi makanan berhasil diperbarui.");
        }
    }
    

    public static void hapusDonasi() {
        tampilkanDonasi();
        if (dataDonasi.isEmpty()) {
            System.out.println("Tidak ada data donasi untuk dihapus.");
            return;
        }

        System.out.print("Masukkan nomor indeks donasi yang ingin dihapus: ");
        int nomor = scanner.nextInt();
        scanner.nextLine();  // Membersihkan buffer

        if (nomor < 1 || nomor > dataDonasi.size()) {
            System.out.println("Nomor donasi tidak valid.");
            return;
        }

        dataDonasi.remove(nomor - 1);
        System.out.println("Data donasi berhasil dihapus.");
    }

    // Implementasi method dari interface DonasiService
    @Override
    public void tampilkanStatistikDonasi() {
        System.out.println("Total Donasi: " + totalDonasi);
    }

    // Implementasi method dari interface DonasiService
    @Override
    public int hitungTotalDonasi() {
        return totalDonasi;
    }
}