package carbookingsystem.user;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserCsvDataAccessService implements UserDao {
    private final  String fileName;
    public UserCsvDataAccessService(final String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<User> getAllUsers() {

        String filePath = getClass().getClassLoader().getResource(fileName).getPath();

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            return  lines
                    .map(line -> line.split(","))
                    .filter(values -> values.length == 2)
                    .map(values -> new User(UUID.fromString(values[0].trim()),values[1].trim()))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
            return List.of();
        }
    }
}
