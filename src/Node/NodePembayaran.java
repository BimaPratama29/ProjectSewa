package Node;

public class NodePembayaran {
    private String uname;
    private float hargabarang;
    private float totalpembayaran;
    private float kembalian;

    public NodePembayaran(String uname, float totalpembayaran, float hargabarang, float kembalian) {
        this.uname = uname;
        this.hargabarang = hargabarang;
        this.totalpembayaran = totalpembayaran;
        this.kembalian = kembalian;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public float getHargabarang() {
        return hargabarang;
    }

    public void setHargabarang(float hargabarang) {
        this.hargabarang = hargabarang;
    }

    public float getTotalpembayaran() {
        return totalpembayaran;
    }

    public void setTotalpembayaran(float totalpembayaran) {
        this.totalpembayaran = totalpembayaran;
    }

    public float getKembalian() {
        return kembalian;
    }

    public void setKembalian(float kembalian) {
        this.kembalian = kembalian;
    }


}
