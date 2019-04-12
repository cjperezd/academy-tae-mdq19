package com.academy.mdq.JSONFiles;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class WriteJSONFile {

  @SuppressWarnings("unchecked")
  public static void main( String[] args ) {

    JSONObject obj1 = new JSONObject();
    obj1.put("search", "Embracing the Power of AI");
    obj1.put("filter", "Books");
    obj1.put("price", "17.96");

    JSONObject obj2 = new JSONObject();
    obj2.put("search","handbag");
    obj2.put("filter", "Women's Fashion");
    obj2.put("price", "15.96");

    JSONObject obj3 = new JSONObject();
    obj3.put("search", "Ray-Ban");
    obj3.put("filter", "Men's Fashion");
    obj3.put("price", "178");

    JSONObject obj4 = new JSONObject();
    obj4.put("search", "Yoyo");
    obj4.put("filter", "Toys & Games");
    obj4.put("price", "9.39");

    JSONObject obj5 = new JSONObject();
    obj5.put("search", "Bob Ross");
    obj5.put("filter", "Arts & Crafts");
    obj5.put("price", "9.99");

    JSONArray amazonList = new JSONArray();
    amazonList.add(obj1);
    amazonList.add(obj2);
    amazonList.add(obj3);
    amazonList.add(obj4);
    amazonList.add(obj5);

    try (
      FileWriter file = new FileWriter("amazon.json")) {
        file.write(amazonList.toJSONString());
        file.flush();

      System.out.println("File written");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
