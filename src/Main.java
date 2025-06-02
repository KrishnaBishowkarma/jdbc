import java.sql.*;

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

        int sid = 102;
        String sname = "Bhim";
        int marks = 100;

        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String pass = "admin";
        String sql = "insert into student values(?, ?, ?)";

        Connection con = DriverManager.getConnection(url, uname, pass);

        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, sid);
        st.setString(2, sname);
        st.setInt(3, marks);

        st.execute();

        con.close();

    }
}
