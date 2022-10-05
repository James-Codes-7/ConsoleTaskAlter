import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnect {

    Connection connection;
    public Statement jdbcConnection() throws SQLException {

        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql:"
                            + "//localhost:3306/students?useSSL=false",
                    "root", "James124@");
            return connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }  }