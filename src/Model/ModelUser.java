package Model;

import ModelJSON.ModelJSONUser;
import Node.NodeUser;
import View.MenuSewa;

import java.util.ArrayList;
import Node.NodeUser;


public class ModelUser extends ModelTemplate{
    private ArrayList<NodeUser> datausers;
    private ModelJSONUser modelJSONUser;

    public ModelUser() {

        datausers = new ArrayList<>();
        modelJSONUser = new ModelJSONUser();
        loadUsers();
    }



    @Override
     public void loadUsers() {
        datausers = modelJSONUser.readFromJSON();
    }

    public void registerUser(String uname, String pass) {
        datausers.add(new NodeUser(uname, pass));
        modelJSONUser.writeToJSON(datausers);
    }
@Override
    public boolean loginUser(String uname, String pass){
        ArrayList<NodeUser> userList = modelJSONUser.readFromJSON();
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).uname.equals(uname)) {
                if (userList.get(i).pass.equals(pass)) {
                    return true;
                }
            }
        }
        return false;
    }

@Override
    public void viewAllUsers() {
        for (NodeUser user : datausers) {
            user.viewUser();
            System.out.println("===================");
        }
    }
@Override
    public void updateUser(String oldUname, String oldPass, String newUname, String newPass) {
        boolean userFound = false;

        for (NodeUser user : datausers) {
            if (user.getUname().equals(oldUname) && user.getPass().equals(oldPass)) {
                user.setUname(newUname);
                user.setPass(newPass);
                userFound = true;
                break;
            }
        }

        if (userFound) {
            modelJSONUser.writeToJSON(datausers);
            System.out.println("User berhasil diupdate.");
        } else {
            System.out.println("User tidak ditemukan.");
        }
    }
@Override
    public void deleteUser(String uname) {
        NodeUser userToRemove = null;
        for (NodeUser user : datausers) {
            if (user.getUname().equals(uname)) {
                userToRemove = user;
                break;
            }
        }

        if (userToRemove != null) {
            datausers.remove(userToRemove);
            modelJSONUser.writeToJSON(datausers);
            System.out.println("User berhasil dihapus.");
        } else {
            System.out.println("User tidak ditemukan.");
        }
    }
}
