package Model;
import Node.NodeUser;

import java.util.ArrayList;

public class ModelUser {
   // public static NodeAdmin admin = new NodeAdmin();
    ArrayList<NodeUser> userslist = new ArrayList<>();

    public ModelUser() {
        initUser();
    }

    public void initUser() {
        userslist.add(new NodeUser("admin","admin123"));
    }
    public void ViewAllUserSewa(){
        for(int i=0 ; i < userslist.size();i++){
            this.userslist.get(i).ViewUserSewa();
        }
    }
    public void registrasi (String uname , String pass){
        userslist.add(new NodeUser(uname, pass));
    }
}


