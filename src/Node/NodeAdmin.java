package Node;
import Interface.Node;
public class NodeAdmin implements Node {
    String admin;
    String pass1;

    public NodeAdmin() {
        this.admin = "admin";
        this.pass1 = "admin";
    }

    public String getAdmin() {
        return admin;
    }

    public String getPass1() {
        return pass1;
    }
}
