//class flights_DB
//Void ADMIN_ADD_FLIGHT(String fcode,String from,String to,int price,String date,String time,int addition,String Avilability) 
//Void ADMIN_UPDATE_FLIGHT(String fcode,String from,String to,int price,String date,String time,String addition,String Avilability)
//Void ADMIN_DELETE_FLIGHT(String fcode)
//ArrayList<flights_data> ADMIN_SHOW_ALL_FLIGHTS()
//ArrayList<flights_data> PASSENGER_SHOW_FromTO_FLIGHTS(String from,String to)
package DB;

import elements.flightsData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class flights_DB 
{
    public static Connection connect() throws SQLException
    {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/java1",
                "root", "root");
    }
    public static void ADMIN_ADD_FLIGHT(String fcode,String from,String to,int price,String date,String time,int Avilability)
    {

        Boolean flage;
        if(Avilability==0)
        {
            flage =false;
        }
        else{
            flage =true;
        }
        try {
            Connection c;
            c = connect();
            PreparedStatement p=c.prepareStatement("insert into flights values(?,?,?,?,?,?,?)");
            p.setString(1,fcode);
            p.setString(2,from);
            p.setString(3,to);
            p.setInt(4,price);
            p.setString(5,date);
            p.setString(6,time);
            p.setBoolean(7,flage);
            p.execute( );
        } catch (SQLException ex) {System.out.println(ex.getMessage());}
    }
    
    public static void ADMIN_UPDATE_FLIGHT(String fcode,String from,String to,int price,String date,String time,int Avilability)

    {
        Boolean flage;
        if(Avilability==0)
        {
            flage =false;
        }
        else{
            flage =true;
        }
          try {
            Connection c;
            c = connect();
            PreparedStatement p;
            p = c.prepareStatement("update flights set ffrom=? , tto=?  , price=? , date=? , time=? , Avilability=?  where fcode=? ");
            p.setString(1,from);
            p.setString(2,to);
            p.setInt(3,price);
            p.setString(4,date);
            p.setString(5,time);
            p.setBoolean(6,flage);
            p.setString(7,fcode);
            p.execute( );
        } catch (SQLException ex) {
              System.out.println("hiiiiiiii");
              System.out.println(ex.getMessage());}
    }
     
    public static void ADMIN_DELETE_FLIGHT(String fcode)
    {
           try {
            Connection c;
            c = connect();
            PreparedStatement p;
            p = c.prepareStatement("DELETE FROM `flights` WHERE fcode=?");
            p.setString(1,fcode);
            p.execute( );
        } catch (SQLException ex) {System.out.println(ex.getMessage());}
         
          
    }
    
    public static ArrayList<flightsData> ADMIN_SHOW_ALL_FLIGHTS()
    { 
        ArrayList<flightsData>arr=new ArrayList<>();
           try {
            Connection c;
            c = connect();
            PreparedStatement p;
            p = c.prepareStatement("SELECT * FROM `flights` ");
            ResultSet r=p.executeQuery(); 
            while(r.next())
            {
                arr.add(new flightsData(r.getString("fcode"),r.getString("ffrom"),r.getString("tto"),r.getInt("price"),r.getString("date"),r.getString("time"),r.getBoolean("Avilability")));
            }
        } catch (SQLException ex) {System.out.println(ex.getMessage());}  
         
           return arr;
    }
    
     public static ArrayList<flightsData> PASSENGER_SHOW_FromTO_FLIGHTS(String from, String to)
    { 
        ArrayList<flightsData>arr=new ArrayList<>();
           try {
            Connection c;
            c = connect();
            PreparedStatement p;
            p = c.prepareStatement("SELECT fcode,ffrom,tto,price,date,time FROM flights where ffrom=? and tto=? and Avilability=?");
            p.setString(1,from);
            p.setString(2,to);
            p.setBoolean(3,true);
            ResultSet r=p.executeQuery(); 
            while(r.next())
            {
                arr.add(new flightsData(r.getString("fcode"),r.getString("ffrom"),r.getString("tto"),
                      r.getInt("price"),r.getString("date"),r.getString("time")));
            }
        } catch (SQLException ex) {System.out.println(ex.getMessage());}  
         
           return arr;
    }
     
     /////
     public static  ArrayList<flightsData> Admin_SHOW_FCode_FLIGHTS(String fcode)
    { 
        ArrayList<flightsData>arr=new ArrayList<>();
           try {
            Connection c;
            c = connect();
            PreparedStatement p;
            p = c.prepareStatement("SELECT fcode,ffrom,tto,price,date,time,Avilability FROM flights where fcode=? ");
            p.setString(1,fcode);
           
            ResultSet r=p.executeQuery(); 
            while(r.next())
            {
                arr.add(new flightsData(r.getString("fcode"),r.getString("ffrom"),r.getString("tto"),
                      r.getInt("price"),r.getString("date"),r.getString("time"),r.getBoolean("Avilability")));
            }
        } catch (SQLException ex) {System.out.println(ex.getMessage());}  
         
           return arr;
    }
    
}
