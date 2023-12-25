package View;

import Controller.ControllerUser;
import Model.ModelUser;
import ModelJSON.ModelJSONUser;
import Node.NodeUser;

import java.util.ArrayList;
import java.util.Scanner;
import View.warna;

import javax.swing.*;

public class MenuUser {
    private final Scanner input = new Scanner(System.in);
    private final ControllerUser controllerUser;
    public static String username;

    public MenuUser(ControllerUser controller){
        this.controllerUser = controller;
    }
    // ModelUser cUser = new ModelUser();
    // ModelJSONUser cUserJSON = new ModelJSONUser();

    public void ListMenuUser() {
        int plh;
        do {
            System.out.println(" ============================== ");
            System.out.println("           Menu User ");
            System.out.println(" ============================== ");
            System.out.println(warna.color_green +"\n 1. Buat Akun  \n 2. Login \n 3. Kembali"+ warna.text_reset);
            System.out.print(" Pilih Opsi : ");

            plh = input.nextInt();
            input.nextLine();



            if (plh == 1) {
                System.out.println(warna.color_blue+"--- Registrasi Akun ---"+warna.text_reset);
                System.out.print(warna.color_purple+"Masukkan username : ");
                String username = input.nextLine();
                System.out.print("Masukkan password : ");
                String password = input.nextLine();
                
                controllerUser.registerUser(username, password);
                System.out.println(warna.color_green+"Akun berhasil didaftarkan"+warna.text_reset);
                ListMenuUser();
            } else if (plh == 2) {
                System.out.print(warna.color_purple+"Masukkan username : ");
                username = input.nextLine();
                System.out.print("Masukkan password : ");
                String password = input.nextLine();
                controllerUser.loginUser(username, password);
            } else {
                Main.main(null);
                break;
            }
        }while (plh != 3);
    }
}
