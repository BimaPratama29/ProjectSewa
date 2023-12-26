package Model;

public abstract class  ModelTemplate {

    public ModelTemplate(){

    }

    abstract void loadUsers();
    public abstract void registerUser(String uname, String pass);
    public abstract boolean loginUser(String uname, String pass);
    public abstract void viewAllUsers();
    public abstract void updateUser(String oldUname, String oldPass, String newUname, String newPass);
    public abstract void deleteUser(String uname);


}
