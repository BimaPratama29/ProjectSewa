package Node;

public class NodeBarang {
    String kodeBarang;
    String namaBarang;
    int stok;
    float hargaSewa;

    public NodeBarang(String kodeBarang, String namaBarang, int stok , float hargaSewa) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.stok = stok;
        this.hargaSewa = hargaSewa;
    }

    public float getHargaSewa() {
        return hargaSewa;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}
