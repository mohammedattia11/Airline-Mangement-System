//class passengers_DB
//Void PASSENGER_ADD_DATA(String username, String pass, String email, String name, String address, String nationality, String passportnumber, int age) 
//void PASSENGER_UPDATE_DATA(String username, String pass, String email, String name, String address, String nationality, String passportnumber, int age) 
// void ADMIN_DELETE_PASSENGER(String username) 
//ArrayList<passengers_data> ADMIN_SHOW_ALL_PASSENGERS()
// ArrayList<passengers_data> ADMIN_SEARCH_PASSENGERS_ByUsername(String userName)
//int PASSENGER_LOGIN(String userName,String pass)-->[0->wrong user name ; -1 -> wrong pass ; 1 -> correct username,pass ]
package DB;

import elements.passengersData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class passengers_DB
{
    public static Connection connect() throws SQLException
    {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/java1",
                "root", "root");    }
     
    public static void  PASSENGER_ADD_DATA(String username, String pass, String email, String name, String address, String nationality, String passportnumber, int age) 
    {
        try {
            Connection c;
            c = connect();
            PreparedStatement p=c.prepareStatement("insert into passenger values(?,?,?,?,?,?,?,?)");
            p.setString(1,username);
            p.setString(2,pass);
            p.setString(3,email);
            p.setString(4,name);
            p.setString(5,address);
            p.setString(6,nationality);
            p.setString(7,passportnumber);
            p.setInt(8,age);
            p.execute( );
        } catch (SQLException ex) {System.out.println(ex.getMessage());}
    }
    
     public static void  PASSENGER_UPDATE_DATA(String username, String pass, String email, String name, String address, String nationality, String passportnumber, int age) 
    {
        try {
            Connection c;
            c = connect();
            PreparedStatement p=c.prepareStatement("update passenger set pass=? , email=? , name=? , address=? , nationality=?  ,  passportNumber=? , age=? where userName=? ");
            p.setString(1,pass);
            p.setString(2,email);
            p.setString(3,name);
            p.setString(4,address);
            p.setString(5,nationality);
            p.setString(6,passportnumber);
            p.setInt(7,age);
            p.setString(8,username);
            p.execute( );
        } catch (SQLException ex) {System.out.println(ex.getMessage());}
    }
     
      public static void  ADMIN_DELETE_PASSENGER(String username) 
    {
        try {
            Connection c;
            c = connect();
            PreparedStatement p=c.prepareStatement("DELETE FROM `passenger` WHERE userName=?");
            p.setString(1,username);
            p.execute( );
        } catch (SQLException ex) {System.out.println(ex.getMessage());}
    }
      
       public static ArrayList<passengersData> ADMIN_SHOW_ALL_PASSENGERS()
    { 
        ArrayList<passengersData>arr=new ArrayList<>();
           try {
            Connection c;
            c = connect();
            PreparedStatement p;
            p = c.prepareStatement("SELECT * FROM `passenger` ");
            ResultSet r=p.executeQuery(); 
            while(r.next())
            {
                arr.add(new passengersData(r.getString("userName"),r.getString("pass"),r.getString("email"),r.getString("name"),r.getString("address"),r.getString("nationality"),r.getString("passportNumber"),r.getInt("age")));
            }
        } catch (SQLException ex) {System.out.println(ex.getMessage());}  
         
           return arr;
    }
       
         public static ArrayList<passengersData> ADMIN_SEARCH_PASSENGERS_ByUsername(String userName )
    { 
        ArrayList<passengersData>arr=new ArrayList<>();
           try {
            Connection c;
            c = connect();
            PreparedStatement p;
            p = c.prepareStatement(" SELECT * FROM passenger where userName=? ");
            p.setString(1,userName);
            ResultSet r=p.executeQuery(); 
            while(r.next())
            {
                arr.add(new passengersData(r.getString("userName"),r.getString("pass"),r.getString("email"),r.getString("name"),r.getString("address"),r.getString("nationality"),r.getString("passportNumber"),r.getInt("age")));
            }
        } catch (SQLException ex) {System.out.println(ex.getMessage());}  
         
           return arr;
    }
         
         public static int PASSENGER_LOGIN(String userName,String pass)
         {
            ArrayList<passengersData>arr = ADMIN_SHOW_ALL_PASSENGERS();
            int flag=0;
            for(int i=0;i<arr.size();i++)
            {
                  if(arr.get(i).userName.equals(userName))
                {
                    if(arr.get(i).pass.equals(pass))
                    {
                         flag=1;
                         break;
                    }            
                    else
                    {
                         flag=-1;
                         break;
                    }   
                }
                else
                    flag=0;
            }
            return flag;
            
         }
}
