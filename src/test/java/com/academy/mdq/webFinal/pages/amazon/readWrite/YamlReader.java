package com.academy.mdq.webFinal.pages.amazon.readWrite;

import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class YamlReader {
    private static Yaml yaml = new Yaml();
    private String path;

    public YamlReader() {

    }

    public Map<String, Object> read(String path) {
        FileReader reader = null;
        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.path = path;
        return yaml.load(reader);
    }

    public List<Object[]> getList(String path) {
        List<Object[]> li = new ArrayList<>();
        Map<String, Object> m;
        m = read(path);
        m.forEach((k, v) -> li.add(new Object[]{k, v}));
        return li;
    }




}
