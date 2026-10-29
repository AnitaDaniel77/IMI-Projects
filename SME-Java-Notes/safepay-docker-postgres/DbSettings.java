public class DbSettings {

    // read from the environment so the password never lives in the repo
    private static String env(String name, String fallback) {
        String value = System.getenv(name);
        return (value == null || value.isBlank()) ? fallback : value;
    }

    public static void main(String[] args) {
        String url = env("SPRING_DATASOURCE_URL", "jdbc:h2:file:./data/safepay-db-version2");
        String user = env("SPRING_DATASOURCE_USERNAME", "sa");
        boolean passwordSet = !env("SPRING_DATASOURCE_PASSWORD", "").isEmpty();

        System.out.println("Connecting to " + url + " as " + user);
        // only say if it exists, never print the password itself
        System.out.println("Password provided: " + passwordSet);
    }
}