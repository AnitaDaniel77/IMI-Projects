// A pretend connection pool: borrow a connection, use it, give it back
import java.util.ArrayDeque;
import java.util.Deque;

public class Db08PoolSimulation {

    // Stands in for a real database connection
    static class FakeConnection {
        final int id;

        FakeConnection(int id) {
            this.id = id;
            System.out.println("Opening connection " + id + " (slow, done once)");
        }
    }

    static class SimplePool {
        private final Deque<FakeConnection> available = new ArrayDeque<>();

        SimplePool(int initialSize) {
            for (int i = 1; i <= initialSize; i++) {
                available.push(new FakeConnection(i)); // open them up front
            }
        }

        // Hand out a free connection, or null if all are busy
        FakeConnection borrow() {
            if (available.isEmpty()) {
                System.out.println("Pool empty, request must wait");
                return null;
            }
            return available.pop();
        }

        // Put it back so the next request can reuse it
        void giveBack(FakeConnection conn) {
            available.push(conn);
        }

        int free() {
            return available.size();
        }
    }

    public static void main(String[] args) {
        SimplePool pool = new SimplePool(2);
        System.out.println("Free at start: " + pool.free());

        FakeConnection a = pool.borrow();
        FakeConnection b = pool.borrow();
        System.out.println("Customer 1 using connection " + a.id);
        System.out.println("Customer 2 using connection " + b.id);

        pool.borrow(); // third customer has to wait

        pool.giveBack(a);
        FakeConnection c = pool.borrow();
        System.out.println("Customer 3 reusing connection " + c.id + " (no new connection opened)");

        pool.giveBack(b);
        pool.giveBack(c);
        System.out.println("Free at end: " + pool.free());
    }
}