package ModelJSON;

import NodeJSON.NodeJSONSewa;
//import com.github.cliftonlabs.json_simple.JsonArray;
//import com.github.cliftonlabs.json_simple.JsonObject;

import java.io.File;
import java.util.ArrayList;

public class ModelJSONAdmin {
    public String userf;
    NodeJSONSewa nodeJSONSewa = new NodeJSONSewa(userf, userf, userf, 0, userf , 0);

    public ModelJSONAdmin() {
        this.userf = "src/Database/admin.json";
    }
    
    public boolean cekFile() {
        boolean cek = false;
        File file = new File(this.userf);
        if (file.exists()){
            cek = true;
        }else{

        }
        return  cek;
    }


}

