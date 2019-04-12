package com.academy.mdq.webFinal.pages.amazon.readWrite;

import com.fasterxml.jackson.dataformat.yaml.snakeyaml.Yaml;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class YamlWriter {

    private Yaml yaml = new Yaml();
    private String path;
    private int keyValuen;
    Map<String, Object> data = new HashMap<>();

    public YamlWriter() {
    }

    public void create(String path, String key, String value) {
        this.path = path;

        data.put(key, value);
        FileWriter writer;

        try {
            writer = new FileWriter(path);
            yaml.dump(data, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int setKeyValues(int n) {
        return this.keyValuen = n;
    }

}
