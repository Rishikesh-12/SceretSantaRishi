import java.io.*;
import java.util.*;

public class SecretSantaService {
    private List<User> users = new ArrayList<>();
    private List<Assignment> assignments = new ArrayList<>();

    public void loadUsers(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                users.add(new User(Integer.parseInt(details[0]), details[1], details[2]));
            }
        }
    }

    public void generateAssignments() {
        List<User> receivers = new ArrayList<>(users);
        Collections.shuffle(receivers);
        for (int i = 0; i < users.size(); i++) {
            assignments.add(new Assignment(users.get(i), receivers.get(i)));
        }
    }

    public void saveAssignments(String filePath) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Assignment assignment : assignments) {
                bw.write(String.format("%d,%s,%s,%d,%s,%s\n",
                        assignment.getGiver().getId(),
                        assignment.getGiver().getName(),
                        assignment.getGiver().getEmail(),
                        assignment.getReceiver().getId(),
                        assignment.getReceiver().getName(),
                        assignment.getReceiver().getEmail()));
            }
        }
    }
}
