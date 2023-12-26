package ModelJSON;

import Node.NodeBarang;
import NodeJSON.NodeJSONSewa;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ModelJSONSewa {
    private String fname = "src/Database/sewabarang.json";
    List<NodeJSONSewa> dataSewa;

    public ModelJSONSewa() {
        this.dataSewa = readFromJSON();
    }

    public void writeToJSON(List<NodeJSONSewa> dataSewa) {
        try (FileWriter file = new FileWriter(fname)) {
            JSONArray arraySewa = convertListToJSONArray(dataSewa);
            file.write(arraySewa.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to write to JSON file: " + e.getMessage());
        }
    }

    public List<NodeJSONSewa> readFromJSON() {
        // Implementasi pembacaan dari JSON
        // ...
        JSONParser parser = new JSONParser();
        List<NodeJSONSewa> listSewa = new ArrayList<>();

        try (FileReader reader = new FileReader(fname)) {
            Object obj = parser.parse(reader);
            JSONArray arraySewa = (JSONArray) obj;

            for (Object o : arraySewa) {
                JSONObject jsonObject = (JSONObject) o;
                String kodeSewa = (String) jsonObject.get("kodeSewa");
                String kodeBarang = (String) jsonObject.get("kodeBarang");
                String namaBarang = (String) jsonObject.get("namaBarang");
                int jumlah = Integer.parseInt(jsonObject.get("jumlah").toString());
                String username = (String) jsonObject.get("username");
                float hargaSewa = Float.parseFloat(jsonObject.get("hargaSewa").toString());


                listSewa.add(new NodeJSONSewa(kodeSewa, kodeBarang, namaBarang, jumlah, username,hargaSewa));
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return listSewa;
    }

    private JSONArray convertListToJSONArray(List<NodeJSONSewa> dataSewa) {
        JSONArray arraySewa = new JSONArray();
        for (NodeJSONSewa sewa : dataSewa) {
            JSONObject objSewa = new JSONObject();
            objSewa.put("kodeSewa", sewa.kodeSewa);
            objSewa.put("kodeBarang", sewa.kodeBarang);
            objSewa.put("namaBarang", sewa.namaBarang);
            objSewa.put("jumlah", sewa.jumlah);
            objSewa.put("username", sewa.username);
            objSewa.put("hargaSewa", sewa.hargaSewa);
            arraySewa.add(objSewa);
        }
        return arraySewa;
    }
    public NodeJSONSewa cariDataSewa(String kodeBarang) {
        List<NodeJSONSewa> sewaList = readFromJSON();

        for (NodeJSONSewa sewa : sewaList) {
            if (sewa.getKodeBarang().equals(kodeBarang)) {
                return sewa;
            }
        }
        return null;
    }

    public void tambahDataJSON(NodeJSONSewa sewa) {
        try {
            // Read existing data
            List<NodeJSONSewa> dataSewa = readFromJSON();

            // Add new data
            dataSewa.add(sewa);

            // Write back to JSON file
            writeToJSON(dataSewa);
            System.out.println("Data sewa added successfully and written to the JSON file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
