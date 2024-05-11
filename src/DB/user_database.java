//user_database اسم الكلاس
// كلاس اللوجين

package DB;

import elements.AdminData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class user_database {

    public static Connection connect() throws SQLException {

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/java1",
                "root", "root");

    }

    public static void insert_data(String user, String pass) throws SQLException {
        try {
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("insert into sign_up values(?,?)");
            p.setString(1, user);
            p.setString(2, pass);
            p.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static ArrayList<AdminData> get_users() {
        ArrayList<AdminData> list = new ArrayList<>();
        try {
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("select * from sign_up");
            ResultSet r = p.executeQuery();
            while (r.next()) {
                list.add(new AdminData(r.getString("username"), r.getString("password")));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return list;
    }

    public static int check_users(String user, String pass) {
        ArrayList<AdminData> arr = get_users();
        int x = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getusername().equalsIgnoreCase(user)) {
                if (arr.get(i).getpassword().equalsIgnoreCase(pass)) {
                    x = 1;//الباس واليوزر صح
                    break;
                } else {
                    x = 2;//الباس غلط
                    break;
                }
            } else {
                x = 0;//make register
            }
        }
        return x;

    }
}
