package com.abhishek.service;
import com.abhishek.modal.Command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author abhishek-m-gowda12
 */
public class FileProcessorService {
    private final File file;

    public FileProcessorService(String filePath) {
        file = new File(filePath);
    }

    public List<Command> processLine() throws IOException {
        List<Command> commandList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                commandList.add(CommandService.getInstance().getCommandFromString(line));
            }
        }

        return commandList;
    }
}
