package Node;

public class NodeBarang {
    String kodeBarang;
    String namaBarang;
    int stok;
    float listharga;


    public NodeBarang(String kodeBarang, String namaBarang, int stok , float listharga) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.stok = stok;
        this.listharga = listharga;

    }


    public float getListharga() {
        return listharga;
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
