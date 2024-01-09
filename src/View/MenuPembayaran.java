package View;

import Controller.ControllerUser;
import Model.ModelPembayaran;
import ModelJSON.ModelJSONPembayaran;
import ModelJSON.ModelJSONSewa;
import Node.NodePembayaran;
import Node.NodeUser;
import NodeJSON.NodeJSONSewa;

import java.util.Scanner;

public class MenuPembayaran {
    static Scanner input = new Scanner(System.in);
    private ControllerUser controllerUser;
    private static ModelPembayaran modelPembayaran;

    public MenuPembayaran(ControllerUser controllerUser, ModelPembayaran modelPembayaran) {
        this.controllerUser = controllerUser;
        this.modelPembayaran = modelPembayaran;
    }


    public void viewBayar(String[] args) {

        int pil;
        do {
            System.out.println(" ============================= ");
            System.out.println("        Menu Pembayaran ");
            System.out.println(" ============================= ");
            System.out.println(warna.color_green + " 1. Lihat Transaksi \n 2. Proses Pembayaran \n 3. Kembali" + warna.text_reset);
            System.out.print(" Masukan Opsi : ");
            pil = input.nextInt(); input.nextLine();

            switch (pil) {
                case 1:
                    System.out.println(" ========================= ");
                    System.out.println("     Lihat Transaksi ");
                    System.out.println(" ========================= ");
                    modelPembayaran.viewTransaksi();
                    // Panggil method untuk menampilkan transaksi
                    break;
                case 2:
                    System.out.println(" ========================= ");
                    System.out.println("        Pembayaran ");
                    System.out.println(" ========================= ");
                    System.out.print("Masukkan kode barang yang dibooking: ");
                    String kodesewa = input.nextLine();
                    ModelJSONSewa modelJSONSewa = new ModelJSONSewa();
                    // Panggil metode untuk mendapatkan data sewa berdasarkan kode barang
                    NodeJSONSewa sewa = modelJSONSewa.cariDataSewa(kodesewa);


                    if (sewa != null) {
                        float hargaBarang = sewa.getHargaBarang();

                        System.out.println("Harga Sewa: " + hargaBarang); // Tampilkan harga sewa

                        System.out.print("Masukkan uang yang dibayarkan: ");
                        float totalPembayaran = input.nextFloat();
                        float kembalian = modelPembayaran.prosesPembayaran(MenuUser.username, totalPembayaran, hargaBarang);

                        if (kembalian > 0) {
                            System.out.println("Kembalian: " + kembalian);
                        }

                        ModelJSONPembayaran modelJSONPembayaran = new ModelJSONPembayaran();
                        modelJSONPembayaran.tambahBayarJSON(new NodePembayaran(MenuUser.username, totalPembayaran, hargaBarang, kembalian));
                    } else {
                        System.out.println("Data sewa tidak ditemukan.");
                    }
                    break;
                case 3:
                    System.out.println(" Kembali ke Menu User....");
                    break;
                default:
                    System.out.println(" Pilihan Tidak Tersedia.");
            }
        } while (pil != 3);
    }
}
