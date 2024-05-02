abstract class Donasi {
    private final int kode;
    protected String nama;
    public Donasi(int kode, String nama) {
        this.kode = kode;
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }
    public abstract String toString();
}

final class DonasiUang extends Donasi {
    private int nominal;

    public DonasiUang(int kode, String nama, int nominal) {
        super(kode,nama);
        this.nominal = nominal;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public final String toString() {
        return "Donasi " + nama + " mendonasikan uang sebesar Rp." + nominal;
    }
}

final class DonasiBarang extends Donasi {
    private int jumlahBarang;
    private String namaBarang;

    public DonasiBarang(int kode, String nama, int jumlahBarang, String namaBarang) {
        super(kode, nama);
        this.jumlahBarang = jumlahBarang;
        this.namaBarang = namaBarang;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public final String toString() {
        return "Donasi " + nama + " mendonasikan " + jumlahBarang + " " + namaBarang;
    }
}


final class DonasiMakanan extends Donasi {
    private int jumlahMakanan;
    private String namaMakanan;
    private String jenisMakanan;

    public DonasiMakanan(int kode, String nama, int jumlahMakanan, String namaMakanan, String jenisMakanan) {
        super(kode,nama);
        this.jumlahMakanan = jumlahMakanan;
        this.namaMakanan = namaMakanan;
        this.jenisMakanan = jenisMakanan;
    }

    // Metode overload untuk menambahkan opsi update jenis makanan
    public void updateDonasi(int jumlahMakanan, String namaMakanan) {
        this.jumlahMakanan = jumlahMakanan;
        this.namaMakanan = namaMakanan;
    }

    // Metode override untuk mencetak informasi donasi makanan beserta jenisnya
    public final String toString() {
        return "Donasi " + nama + " mendonasikan " + jumlahMakanan + " " + namaMakanan + " (" + jenisMakanan + ")";
    }
}
