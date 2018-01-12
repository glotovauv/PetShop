package shop.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.animals.Animal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataStoringJob {

    public void saveAnimals(PetShopStorage storage) {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference types = new TypeReference<ArrayList<Animal>>() {
        };
        ObjectWriter writer = mapper.writerFor(types);

        try {
            List<Animal> animals = storage.getAnimals();
            String jsonInString = writer.writeValueAsString(animals);
            FileWriter fileWriter = new FileWriter("file.json", false);
            fileWriter.write(jsonInString);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void uploadAnimals(PetShopStorage storage) {
        File file = new File("file.json");
        int fileLength = (int) file.length();

        if (fileLength != 0) {
            char[] buffer = new char[fileLength];
            try {
                FileReader reader = new FileReader("file.json");
                int readByte = reader.read(buffer);
                reader.close();
                String jsonInString = new String(buffer, 0, readByte);
                ObjectMapper mapper = new ObjectMapper();
                TypeReference types = new TypeReference<ArrayList<Animal>>() {
                };
                List<Animal> list = mapper.readValue(jsonInString, types);
                storage.setAnimals(list);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
