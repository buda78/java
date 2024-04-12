import java.sql.*;

public class TeacherDatabase {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/bcs";
        String username = "bcs"; 
        String password = "bcs"; 
        try {
            Connection conn = DriverManager.getConnection(url, username, password);


            String insertQuery = "INSERT INTO Teacher(TNo, TName, Subject) VALUES (?, ?, ?)";
            PreparedStatement insertStatement = conn.prepareStatement(insertQuery);


            for (int i = 1; i <= 5; i++) {
                insertStatement.setInt(1, i);
                insertStatement.setString(2, "Teacher" + i);
                insertStatement.setString(3, (i % 2 == 0) ? "JAVA" : "Math");
                insertStatement.executeUpdate();
            }


            String selectQuery = "SELECT * FROM Teacher WHERE Subject = ?";
            PreparedStatement selectStatement = conn.prepareStatement(selectQuery);
            selectStatement.setString(1, "JAVA");
            ResultSet resultSet = selectStatement.executeQuery();

            System.out.println("Details of teachers teaching 'JAVA' subject:");
            System.out.println("TNo\tTName\tSubject");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("TNo") + "\t" + resultSet.getString("TName") + "\t" + resultSet.getString("Subject"));
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

