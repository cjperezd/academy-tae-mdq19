package com.academy.mdq.webFinal.pages.amazon.readWrite;

import com.fasterxml.jackson.dataformat.yaml.snakeyaml.Yaml;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class YamlWriter {

    private Yaml yaml = new Yaml();
    private String path;

    public YamlWriter() {
    }

    public void create(String path) throws IOException {
        this.path = path;
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("Embracing the Power of AI", "Books");
        data.put("Notebook", "Computers");
        data.put("Optical Illusioon 3D Glow LED", "Home & Kitchen");
        data.put("Slide It In", "Music, CDs & Vinyl");
        data.put("Arduino", "Industrial & Scientific");

        FileWriter writer;

        writer = new FileWriter(path);
        yaml.dump(data, writer);
    }

}
