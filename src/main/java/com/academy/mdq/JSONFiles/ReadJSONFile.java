package com.academy.mdq.JSONFiles;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class ReadJSONFile {

  private static final Logger LOGGER = getLogger(ReadJSONFile.class);

  public static Collection<Object[]> readFile(String filePath, String[] keys) {
    JSONParser jsonParser = new JSONParser();
    List<Object[]> list = new ArrayList<>();

    try (FileReader reader = new FileReader(filePath)) {

      JSONArray array = (JSONArray)jsonParser.parse(reader);

      for (Object o : array) {
        list.add(createObject((JSONObject)o, keys));
      }

    } catch (FileNotFoundException e) {
      LOGGER.error(e.getMessage(), e);
    } catch (IOException e) {
      LOGGER.error(e.getMessage(), e);
    } catch (ParseException e) {
      LOGGER.error(e.getMessage(), e);
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
