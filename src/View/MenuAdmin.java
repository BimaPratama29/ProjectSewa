package View;

import Controller.ControllerUser;
import Model.ModelAdmin;
import Model.ModelPembayaran;
import Model.ModelUser;
import ModelJSON.ModelJSONUser;
import Node.NodeUser;
import NodeJSON.NodeJSONSewa;
import ModelJSON.ModelJSONAdmin;
import Model.ModelBarang;
import ModelJSON.ModelJSONBarang;
import Node.NodeBarang;

import java.util.List;
import java.util.Scanner;

public class MenuAdmin {
    public static Scanner input = new Scanner(System.in);
    static ModelUser modelUser = new ModelUser();
    static ModelAdmin modelAdmin = new ModelAdmin();
    private ControllerUser controller;
    static ModelPembayaran modelPembayaran;

    public MenuAdmin(ControllerUser controller, ModelPembayaran modelPembayaran ) {
        this.controller = controller;
        this.modelPembayaran = modelPembayaran;

    }

    public static void main(String[] args) {
        loginAdmin(); // Call the login method to start
    }

    public static void loginAdmin() {
        System.out.print("Masukkan Username Admin: ");
        String user = input.nextLine();
        System.out.print("Masukkan Password Admin: ");
        String pass1 = input.nextLine();

        if (modelAdmin.cekLogin(user, pass1)) {
            System.out.println("Anda Berhasil Login");
            listMenuAdmin(); // Call the main menu after successful login
        } else {
            System.out.println("Username atau password salah");
            loginAdmin(); // Retry login if unsuccessful
        }
    }

    public static void listMenuAdmin() {
        int plh;

        do {
            System.out.println("=====================================");
            System.out.println("            Menu Admin ");
            System.out.println("=====================================");
            System.out.println(warna.color_green + " 1.View Transaksi\n 2.Update User\n 3.Delete User \n 4.Tambah Barang \n 5.View User Sewa\n 6.Kembali" + //
                    "");
            System.out.print(" Input Pilihan : ");
            plh = input.nextInt();

            switch (plh) {
                case 1:
                    modelPembayaran.viewTransaksi();
                    break;
                case 2:
                    input.nextLine(); // Consume the newline character
                    System.out.print("Masukkan username lama: ");
                    String oldUname = input.nextLine();
                    System.out.print("Masukkan password lama: ");
                    String oldPass = input.nextLine();
                    System.out.print("Masukkan username baru: ");
                    String newUname = input.nextLine();
                    System.out.print("Masukkan password baru: ");
                    String newPass = input.nextLine();
                    modelUser.updateUser(oldUname, oldPass, newUname, newPass);
                    break;
                case 3:
                    input.nextLine(); // Consume the newline character
                    System.out.print("Masukkan username yang akan dihapus: ");
                    String unameToDelete = input.nextLine();
                    System.out.print("Masukkan password pengguna: ");
                    String passToDelete = input.nextLine();
                    modelUser.deleteUser(unameToDelete);
                    break;
                case 4:
                    tambahBarang();
                    break;
                case 5:
                    viewUserSewa();
                    break;
                case 6:
                    System.out.println(" Kembali Ke Menu Login ");
                    Main.main(null);
                    break;
                default:
                    System.out.println(" Pilihan Tidak Tersedia.");
            }
        } while (plh != 5);
    }

    // Metode untuk menambahkan barang
    public static void tambahBarang() {
        input.nextLine(); // Consume the newline character
        System.out.print("Masukkan kode barang: ");
        String kodeBarang = input.nextLine();
        System.out.print("Masukkan nama barang: ");
        String namaBarang = input.nextLine();
        System.out.print("Masukkan jumlah stok barang: ");


        int stokBarang;
        while (true) {
            try {
                stokBarang = Integer.parseInt(input.nextLine());
                if (stokBarang >= 0) {
                    break;
                } else {
                    System.out.println("Jumlah stok barang harus lebih besar atau sama dengan 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid.");
            }
        }
        System.out.print("Masukkan Harga Sewa : ");
        float hargaSewa = input.nextFloat();


        ModelBarang modelBarang = new ModelBarang();
        modelBarang.tambahStokBarang(kodeBarang, namaBarang, stokBarang , hargaSewa );

        // Tambahkan baris berikut untuk menyimpan data ke JSON
        ModelJSONBarang modelJSONBarang = new ModelJSONBarang();
        modelJSONBarang.tambahDataJSON(new NodeBarang(kodeBarang, namaBarang, stokBarang , hargaSewa));

        System.out.println("Barang berhasil ditambahkan.");
    }


    private static void viewUserSewa() {
    ModelBarang modelBarang = new ModelBarang();
    List<NodeJSONSewa> dataSewa = modelBarang.getSewaList();

    if (dataSewa.isEmpty()) {
        System.out.println("Tidak ada data user yang sedang menyewa.");
    } else {
        System.out.println("=====================================");
        System.out.println("     Data User yang Sedang Menyewa");
        System.out.println("=====================================");
        for (NodeJSONSewa sewa : dataSewa) {
            System.out.println("Kode Barang: " + sewa.getKodeBarang());
            System.out.println("Nama Barang: " + sewa.getNamaBarang());
            System.out.println("Harga Barang: " + sewa.getHargaBarang());
            System.out.println("Username User: " + sewa.getUsername());
            System.out.println("-------------------------------");
        }
    }
}
}
