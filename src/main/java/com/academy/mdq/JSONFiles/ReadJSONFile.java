package com.academy.mdq.JSONFiles;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReadJSONFile {

  public static Collection<Object[]> readFile(String nameOfFile) {
    JSONParser jsonParser = new JSONParser();
    List<Object[]> list = new ArrayList<>();

    try (FileReader reader = new FileReader(nameOfFile)) {

      JSONArray array = (JSONArray)jsonParser.parse(reader);

      for (Object o : array) {
        list.add(createObject((JSONObject)o));
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }

    return (list);
  }

  private static Object[] createObject(JSONObject obj) {
    return new Object[] {
        obj.get("search"), obj.get("filter"), obj.get("price")
    };
  }

}
