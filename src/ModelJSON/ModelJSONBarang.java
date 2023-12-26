package ModelJSON;

import Node.NodeBarang;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ModelJSONBarang {
    private String fname = "src/Database/barang.json";
    List<NodeBarang> stokBarang;

    public ModelJSONBarang() {
        // Constructor
        this.stokBarang = readFromJSON(); // Read data when the object is created
    }

    public void writeToJSON(List<NodeBarang> stokBarang) {
        try (FileWriter file = new FileWriter(fname)) {
            JSONArray arrayBarang = convertListToJSONArray(stokBarang);
            file.write(arrayBarang.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to write to JSON file: " + e.getMessage());
        }
    }

    public List<NodeBarang> readFromJSON() {
        JSONParser parser = new JSONParser();
        List<NodeBarang> stokBarang = new ArrayList<>();

        try (FileReader reader = new FileReader(fname)) {
            Object obj = parser.parse(reader);
            JSONArray arrayBarang = (JSONArray) obj;

            for (Object o : arrayBarang) {
                JSONObject jsonObject = (JSONObject) o;
                String kodeBarang = (String) jsonObject.get("kodeBarang");
                String namaBarang = (String) jsonObject.get("namaBarang");
                long stok = (long) jsonObject.get("stok");
                float hargaSewa = Float.parseFloat(jsonObject.get("hargaSewa").toString());

                NodeBarang barang = new NodeBarang(kodeBarang, namaBarang, (int) stok ,  hargaSewa);
                stokBarang.add(barang);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return stokBarang;
    }

    private JSONArray convertListToJSONArray(List<NodeBarang> stokBarang) {
        JSONArray arrayBarang = new JSONArray();
        for (NodeBarang barang : stokBarang) {
            JSONObject objBarang = new JSONObject();
            objBarang.put("kodeBarang", barang.getKodeBarang());
            objBarang.put("namaBarang", barang.getNamaBarang());
            objBarang.put("stok", barang.getStok());
            objBarang.put("hargaSewa",barang.getHargaSewa());
            arrayBarang.add(objBarang);
        }
        return arrayBarang;
    }

    public void tambahDataJSON(NodeBarang barang) {
        try {
            // Read existing data
            List<NodeBarang> stokBarang = readFromJSON();

            // Add new data
            stokBarang.add(barang);

            // Write back to JSON file
            writeToJSON(stokBarang);
            System.out.println("Data added successfully and written to the JSON file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStokBarang(List<NodeBarang> updatedStokBarang) {
        // Write the updated data back to the JSON file
        writeToJSON(updatedStokBarang);
    }
}
