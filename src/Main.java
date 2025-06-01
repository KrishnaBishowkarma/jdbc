import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception {

        /*
        7 steps for JDBC:
            1. import package (java.sql)
            2. load and register
            3. create connection
            4. create statement
            5. execute statement
            6. process the result
            7. close
         */

        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String pass = "admin";
        String sql = "select sname from student where sid = 2";


        Connection con = DriverManager.getConnection(url, uname, pass);
        System.out.println("Connection Established");

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        System.out.println(rs.next());

        con.close();
        System.out.println("Connection Closed!");

    }
}
