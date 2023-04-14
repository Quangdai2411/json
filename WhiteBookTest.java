package Json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class WhiteBookTest {
    public static void main(String[] args) {
        JSONObject eplD = new JSONObject();
        eplD.put("ID", "A1");
        eplD.put("Name", "Kỷ Luật Tự Giác");
        eplD.put("Price", "62500");
        eplD.put("Author", "Tiểu Dã");

        JSONObject eplO = new JSONObject();
        eplO.put("Book", eplD);

        JSONObject eplD2 = new JSONObject();
        eplD2.put("ID", "A2");
        eplD2.put("Name", "Thao túng tâm lý");
        eplD2.put("Price", "99000");
        eplD2.put("Author", "Shannon Thomas");

        JSONObject eplO2 = new JSONObject();
        eplO2.put("Book", eplD2);


        JSONArray eplList = new JSONArray();
        eplList.add(eplD);
        eplList.add(eplO2);

        try(FileWriter file = new FileWriter("book.json")){
            file.write(eplList.toJSONString());
            file.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
