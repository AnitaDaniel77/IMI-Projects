import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ApiRoutingDemo {

    // a list standing in for a database
    private static final List<String> transactions = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8081), 0); // listen on port 8081
        server.createContext("/transactions", ApiRoutingDemo::handle); // send /transactions requests to handle
        server.start();
        System.out.println("Listening on http://localhost:8081/transactions");
    }

    private static void handle(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod(); // GET, POST and so on
        if ("GET".equals(method)) {
            send(exchange, 200, transactions.toString()); // read: return the list
        } else if ("POST".equals(method)) {
            String body = new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8); // read the body
            transactions.add(body); // create: store it
            send(exchange, 201, "created"); // 201 Created
        } else {
            send(exchange, 405, "method not allowed"); // no PUT or DELETE here
        }
    }

    private static void send(HttpExchange exchange, int status, String text) throws IOException {
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
        exchange.sendResponseHeaders(status, bytes.length); // status code and reply length
        try (OutputStream out = exchange.getResponseBody()) {
            out.write(bytes); // write the reply
        }
    }
}