package Model;

import ModelJSON.ModelJSONPembayaran;
import Node.NodePembayaran;
import View.warna;

import java.util.ArrayList;

public class ModelPembayaran {
    private ArrayList<NodePembayaran> pembayaran ;
    private final ModelJSONPembayaran modelJSONPembayaran;



    public ModelPembayaran(){
        pembayaran = new ArrayList<>();
        modelJSONPembayaran = new ModelJSONPembayaran();
        pembayaran = modelJSONPembayaran.readFromJSON();
    }

    public float prosesPembayaran(String uname, float totalPembayaran, float hargabarang) {
        float kembalian = 0.0f;
        if ( totalPembayaran < hargabarang) {
            System.out.println(warna.color_red + "Uang yang dibayarkan kurang. Pembayaran gagal." + warna.text_reset);
        } else {
            kembalian = totalPembayaran - hargabarang;
            NodePembayaran transaksi = new NodePembayaran(uname ,totalPembayaran,hargabarang,kembalian);
            pembayaran.add(transaksi);
            modelJSONPembayaran.writeToJSON(pembayaran);
            System.out.println(warna.color_green + "Pembayaran berhasil." + warna.text_reset);

        }
        return kembalian;
    }

    public void viewTransaksi() {
        System.out.println(" ========================= ");
        System.out.println("       Struk Pembayaran ");
        System.out.println(" ========================= ");
        for(NodePembayaran transaksi : pembayaran) {
            System.out.println("Username: " + transaksi.getUname());
            System.out.println("harga sewa : " + transaksi.getHargabarang());
            System.out.println("Masukkan uang yang dibayarkan : " + transaksi.getTotalpembayaran());
            System.out.println("Kembalian: " + transaksi.getKembalian());
            System.out.println(" ========================= ");
        }
    }


}