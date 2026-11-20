// CRUD behind an interface: swap the storage without changing the app code
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Db02CrudAbstraction {

    // Simple client record
    static class Client {
        private final int id;
        private String name;

        Client(int id, String name) {
            this.id = id;
            this.name = name;
        }

        int getId() { return id; }
        String getName() { return name; }
        void setName(String name) { this.name = name; }

        @Override
        public String toString() {
            return id + " - " + name;
        }
    }

    // The contract: app code only knows these four CRUD methods
    interface ClientRepository {
        void save(Client client);           // Create
        Client findById(int id);            // Read
        List<Client> findAll();             // Read all
        boolean update(int id, String name); // Update
        boolean delete(int id);             // Delete
    }

    // Today: stored in a HashMap. Later: JDBC, JPA or MongoDB
    static class InMemoryClientRepository implements ClientRepository {
        private final Map<Integer, Client> clients = new HashMap<>();

        public void save(Client client) {
            clients.put(client.getId(), client);
        }

        public Client findById(int id) {
            return clients.get(id);
        }

        public List<Client> findAll() {
            return new ArrayList<>(clients.values());
        }

        public boolean update(int id, String name) {
            Client client = clients.get(id);
            if (client == null) {
                return false;
            }
            client.setName(name);
            return true;
        }

        public boolean delete(int id) {
            return clients.remove(id) != null;
        }
    }

    public static void main(String[] args) {
        ClientRepository repo = new InMemoryClientRepository(); // only this line changes later

        repo.save(new Client(1, "Anita"));
        repo.save(new Client(2, "Thabo"));
        System.out.println("All: " + repo.findAll());

        repo.update(2, "Thabo M");
        System.out.println("After update: " + repo.findById(2));

        repo.delete(1);
        System.out.println("After delete: " + repo.findAll());
    }
}