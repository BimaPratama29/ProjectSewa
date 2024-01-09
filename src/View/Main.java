package View;
import Controller.ControllerUser;
import Model.ModelAdmin;
import Model.ModelPembayaran;
import Model.ModelUser;
import ModelJSON.ModelJSONUser;
import Node.NodeUser;
import Model.ModelPembayaran;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static ModelUser modelUser = new ModelUser();
    public  static ControllerUser controllerUser = new ControllerUser(modelUser);
    static ModelPembayaran modelPembayaran = new ModelPembayaran();
    //public static ModelPembayaran modelPembayaran;
    static MenuUser menuUser = new MenuUser(controllerUser);
    static MenuAdmin menuAdmin = new MenuAdmin(controllerUser );


    public static void main(String[] args) {
        ModelAdmin admin = new ModelAdmin();



        Scanner input = new Scanner(System.in);
        int plh;

        System.out.println(" ============================== ");
        System.out.println("      ! Selamat Datang di ! ");
        System.out.println("        Rental PS ITATS ");
        System.out.println(" ============================== ");

        do {
            System.out.println("\n 1. Penyewa \n 2. Admin \n 3. Exit");
            System.out.println("=====================================");
            System.out.print(" Pilih Menu Login : ");
            plh = input.nextInt();
            input.nextLine();

            switch (plh) {
                case 1:
                    // User
                    menuUser.ListMenuUser();
                    break;
                case 2:
                    // Admin
                    menuAdmin.loginAdmin();
                    break;
                case 3:
                    //exit
                    exit(0);
                    break;
            }
        } while (plh != 2);

    }
}
