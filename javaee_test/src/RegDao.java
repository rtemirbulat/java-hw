import java.sql.*;


public class RegDao {
    public static Connection getConnection() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:8082/user_db?user=root&password=root");
            return connection;
        } catch (SQLException e  ) {
            e.printStackTrace();
            return null;
        }
    }
    public boolean validateLogin(User user)
    {
        Connection conn = getConnection();
        boolean canLogin=false;
        try
        {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM user where uname=? AND password=?");
            ps.setString(1, user.getUname());
            ps.setString(2, user.getPassword());

            ResultSet rs = ps.executeQuery();
            canLogin= rs.next();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return canLogin;
    }


    public boolean insert(User user){
        Connection conn = getConnection();
        boolean res = false;

        String ins ="INSERT INTO user_db.user VALUES (?,?)";
        String chck_duplicate = "SELECT COUNT(*) FROM user where uname='"+user.getUname()+"'";
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(chck_duplicate);
            rs.next();
            String countrows = rs.getString(1);
            if(countrows.equals("0")) {

                PreparedStatement stmt = conn.prepareStatement(ins);
                stmt.setString(1, user.getUname());
                stmt.setString(2, user.getPassword());
                stmt.executeUpdate();
                res = true;
            }
        }
         catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

}
