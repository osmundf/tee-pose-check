package com.github.osmundf.tpc.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LargeFileCreator {

    @Test
    void create() throws IOException {
        File file = new File("large.csv");
        FileWriter writer = new FileWriter(file);
        writer.write("Line,Name,Unit,Cost\n");
        for (int i = 1; i <= 500; i++) {
            writer.write(String.format("%s,%s,%s,%s\n", i, "Name", "ea", "9.99"));
        }
        writer.close();
    }

}
