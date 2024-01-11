package NodeJSON;

public class NodeJSONSewa {

    public String kodeBarang;
    public String namaBarang;
    public String username;
    public int jumlah;
    public float hargaBarang;

    public NodeJSONSewa( String kodeBarang, String namaBarang, int jumlah, String username , float hargaBarang) {

        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.jumlah = jumlah;
        this.username = username;
        this.hargaBarang = hargaBarang;

    }

    public float getHargaBarang() {
        return hargaBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
}

public String getUsername() {
    return username;
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
