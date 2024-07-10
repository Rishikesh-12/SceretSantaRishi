public class Main {
    public static void main(String[] args) {
        SecretSantaService service = new SecretSantaService();
        try {
            service.loadUsers("users.csv");
            service.generateAssignments();
            service.saveAssignments("assignments.csv");
            System.out.println("Secret Santa assignments have been generated and saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
