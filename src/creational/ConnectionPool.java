package creational;

import java.util.ArrayList;
import java.util.List;

class Connection {}

public class ConnectionPool {
    private List<Connection> available = new ArrayList<>();

    public Connection acquire() {
        if (available.isEmpty()) return new Connection();
        return available.remove(available.size() - 1);
    }
    public void release(Connection c) {
        available.add(c);
    }
}