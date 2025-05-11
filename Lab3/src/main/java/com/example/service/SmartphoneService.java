package com.example.service;

import com.example.model.Smartphone;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SmartphoneService {
    private final String FILE_PATH = "src/main/resources/data.json";
    private final Gson gson = new Gson();
    private List<Smartphone> smartphones;

    public SmartphoneService() {
        smartphones = readSmartphones();
    }

    private List<Smartphone> readSmartphones() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, new TypeToken<List<Smartphone>>() {}.getType());
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private void writeSmartphones() {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(smartphones, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Smartphone> getAll() {
        return smartphones;
    }

    public void add(Smartphone smartphone) {
        smartphone.setId(generateId());
        smartphones.add(smartphone);
        writeSmartphones();
    }

    public void update(Smartphone updated) {
        for (int i = 0; i < smartphones.size(); i++) {
            if (smartphones.get(i).getId() == updated.getId()) {
                smartphones.set(i, updated);
                writeSmartphones();
                return;
            }
        }
    }

    public void delete(int id) {
        smartphones.removeIf(s -> s.getId() == id);
        writeSmartphones();
    }

    private int generateId() {
        return smartphones.stream()
                .mapToInt(Smartphone::getId)
                .max()
                .orElse(0) + 1;
    }
}
