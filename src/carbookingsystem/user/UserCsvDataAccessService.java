package carbookingsystem.user;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserCsvDataAccessService implements UserDao {

    public UserCsvDataAccessService() {
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        String filePath = "src/carbookingsystem/users.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 2) {
                    UUID id = UUID.fromString(values[0].trim());
                    String name = values[1].trim();
                    users.add(new User(id, name));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        return users;
    }
}
