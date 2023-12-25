package Model;

import Node.NodeBarang;
import NodeJSON.NodeJSONSewa;
import ModelJSON.ModelJSONBarang;
import ModelJSON.ModelJSONSewa;
import View.warna;

import java.util.ArrayList;
import java.util.List;

public class ModelBarang {
    private List<NodeBarang> stokBarang = new ArrayList<>();
    private List<NodeJSONSewa> sewaList = new ArrayList<>();

    public ModelBarang() {
        ModelJSONBarang modelJSONBarang = new ModelJSONBarang();
        this.stokBarang = modelJSONBarang.readFromJSON();
        ModelJSONSewa modelJSONSewa = new ModelJSONSewa();
        this.sewaList = modelJSONSewa.readFromJSON();
    }

    public void ViewStok() {
        for (NodeBarang barang : stokBarang) {
            System.out.println(barang.getKodeBarang() + " - " + barang.getNamaBarang() +
                    warna.color_purple + " - Stok: " + warna.text_reset + barang.getStok());
        }
    }

    public void tambahStokBarang(String kodeBarang, String namaBarang, int stok , float hargaSewa) {
        stokBarang.add(new NodeBarang(kodeBarang, namaBarang, stok,hargaSewa));
    }

    public void bookingSewa(String kodeBarang, int jumlah, String username , float hargaSewa) {
        NodeBarang stok = cariBarang(kodeBarang);
        if (stok != null) {
            if (stok.getStok() >= jumlah) {
                stok.setStok(stok.getStok() - jumlah);
                System.out.println("Booking berhasil! Terima kasih.");

                // Tambah data pemesanan ke list
                sewaList.add(new NodeJSONSewa(generateKodeSewa(), stok.getKodeBarang(), stok.getNamaBarang(), jumlah, username,stok.getHargaSewa()));

                // Tambahkan baris berikut untuk menyimpan data ke JSON
                ModelJSONSewa modelJSONSewa = new ModelJSONSewa();
                modelJSONSewa.writeToJSON(sewaList);

                // Update stok yang telah berubah ke dalam file JSON
                ModelJSONBarang modelJSONBarang = new ModelJSONBarang();
                modelJSONBarang.updateStokBarang(getStokBarang());
            } else {
                System.out.println("Stok tidak mencukupi untuk booking.");
            }
        } else {
            System.out.println("Barang tidak ditemukan dalam stok.");
        }
    }

    private NodeBarang cariBarang(String kodeBarang) {
        for (NodeBarang barang : stokBarang) {
            if (barang.getKodeBarang().equals(kodeBarang)) {
                return barang;
            }
        }
        return null;
    }

    private String generateKodeSewa() {
        return "SEWA" + System.currentTimeMillis();
    }

    public List<NodeBarang> getStokBarang() {
        return stokBarang;
    }

    public List<NodeJSONSewa> getSewaList() {
        return sewaList;
    }

    public void bookingSewa(String kodeBarang, int jumlah) {
    }
}
