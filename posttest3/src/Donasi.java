class Donasi {
    private String nama;

    public Donasi(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    @Override
    public String toString() {
        return "Donasi " + nama;
    }
}

class DonasiUang extends Donasi {
    private int nominal;

    public DonasiUang(String nama, int nominal) {
        super(nama);
        this.nominal = nominal;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    @Override
    public String toString() {
        return super.getNama() + " mendonasikan uang sebesar Rp." + nominal;
    }
}

class DonasiBarang extends Donasi {
    private int jumlahBarang;
    private String namaBarang;

    public DonasiBarang(String nama, int jumlahBarang, String namaBarang) {
        super(nama);
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

    @Override
    public String toString() {
        return super.getNama() + " mendonasikan " + jumlahBarang + " " + namaBarang;
    }
}


class DonasiMakanan extends Donasi {
    private int jumlahMakanan;
    private String namaMakanan;

    public DonasiMakanan(String nama, int jumlahMakanan, String namaMakanan, String jenisMakanan) {
        super(nama);
        this.jumlahMakanan = jumlahMakanan;
        this.namaMakanan = namaMakanan;
    }

    public int getJumlahMakanan() {
        return jumlahMakanan;
    }

    public void setJumlahMakanan(int jumlahMakanan) {
        this.jumlahMakanan = jumlahMakanan;
    }

    public String getNamaMakanan() {
        return namaMakanan;
    }

    public void setNamaMakanan(String namaMakanan) {
        this.namaMakanan = namaMakanan;
    }

    @Override
    public String toString() {
        return super.getNama() + " mendonasikan " + jumlahMakanan + " " + namaMakanan;
    }
}
