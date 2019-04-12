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

  public static Collection<Object[]> readAmazonFile(String nameOfFile, String[] keys) {
    JSONParser jsonParser = new JSONParser();
    List<Object[]> list = new ArrayList<>();

    try (FileReader reader = new FileReader(nameOfFile)) {

      JSONArray array = (JSONArray)jsonParser.parse(reader);

      for (Object o : array) {
        list.add(createObject((JSONObject)o, keys));
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

  private static Object[] createObject(JSONObject obj, String[] keys) {
    List<Object> finalObject = new ArrayList<>();
    for (int i=0; i<keys.length; i++) {
      finalObject.add(obj.get(keys[i]));
    }
    return finalObject.toArray();
  }

}
