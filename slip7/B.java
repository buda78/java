import java.sql.*;

public class B {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/bcs";
    static final String USER = "bcs";
    static final String PASS = "bcs";
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("PostgreSQL JDBC Driver loaded successfully.");

            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
                if (conn != null) {
                    System.out.println("Connected to the PostgreSQL database!");
                   displayRecords(conn);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    private static void displayRecords(Connection conn) throws SQLException {
        String sql = "SELECT * FROM Product";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Product Table:");
            System.out.println("===============");
            System.out.println("Pid\tPname\tPrice");
            while (rs.next()) {
                int pid = rs.getInt("Pid");
                String pname = rs.getString("Pname");
                double price = rs.getDouble("Price");
                System.out.println(pid + "\t" + pname + "\t" + price);
            }
        }
    }
}

