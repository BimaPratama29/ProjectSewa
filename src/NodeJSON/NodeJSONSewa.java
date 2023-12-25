package NodeJSON;

public class NodeJSONSewa {
    public String kodeSewa;
    public String kodeBarang;
    public float hargaSewa;
    public String namaBarang;
    public String username;
    public int jumlah;

    public NodeJSONSewa(String kodeSewa, String kodeBarang, String namaBarang, int jumlah, String username , float hargaSewa) {
        this.kodeSewa = kodeSewa;
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.jumlah = jumlah;
        this.username = username;
        this.hargaSewa = hargaSewa;

    }

    public float getHargaSewa() {
        return hargaSewa;
    }

    public String getNamaBarang() {
        return null;
}

public String getUsername() {
    return null;
}

    public String getKodeSewa() {
        return kodeSewa;
    }

    public void setKodeSewa(String kodeSewa) {
        this.kodeSewa = kodeSewa;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }


}
