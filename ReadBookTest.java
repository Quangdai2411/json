package Json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadBookTest {
    public static void main(String[] args) {
        JSONParser jsonParser = new JSONParser();
        try(FileReader reader = new FileReader("book.json")){
            Object obj = jsonParser.parse(reader);
            JSONArray empList = (JSONArray) obj;
            System.out.println(empList);

            empList.forEach(book -> parseEmployeeObject((JSONObject) book));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static void parseEmployeeObject(JSONObject book) {
        JSONObject epl = (JSONObject) book.get("employee");
        String ID = (String) epl.get("ID");
        System.out.println(ID);

        String Name = (String) epl.get("Name");
        System.out.println(Name);

        String Price = (String) epl.get("Price");
        System.out.println(Price);

        String Author = (String) epl.get("Author");
        System.out.println(Author);
    }
}
