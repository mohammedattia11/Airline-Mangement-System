//class PassengerFlight_DB
//void PASSENGER_BOOK_FLIGHT(String passengerUSERNAME,String flightFCODE)
// void PASSENGER_CANCLE_FLIGHT(String passengerUSERNAME,String flightFCODE)
//ArrayList<flights_data> PASSENGER_SHOW_BOOKED_FLIGHTS(String passengerUSERNAME)
package DB;

import elements.flightsData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PassengerFlight_DB
{
     public static Connection connect() throws SQLException
    {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/java1",
                "root", "root");
    }
     
     public static void PASSENGER_BOOK_FLIGHT(String passengerUSERNAME,String flightFCODE)
     {
           try {
            Connection c;
            c = connect();
            PreparedStatement p;
            p = c.prepareStatement("insert into passengerflight values(?,?)");
            p.setString(1,passengerUSERNAME);
            p.setString(2,flightFCODE);
            p.execute( );
        } catch (SQLException ex) {System.out.println(ex.getMessage());}
     }
     
      public static void PASSENGER_CANCLE_FLIGHT(String passengerUSERNAME,String flightFCODE)
      {
            try {
            Connection c;
            c = connect();
            PreparedStatement p;
            p = c.prepareStatement("DELETE FROM `passengerflight` WHERE passenger=? and flight=?");
            p.setString(1,passengerUSERNAME);
            p.setString(2,flightFCODE);
            p.execute( );
        } catch (SQLException ex) {System.out.println(ex.getMessage());}

      }
      
      public static ArrayList<flightsData> PASSENGER_SHOW_BOOKED_FLIGHTS(String passengerUSERNAME)
      {
           ArrayList<flightsData>arr=new ArrayList<>();
           try {
            Connection c;
            c = connect();
            PreparedStatement p;
            p = c.prepareStatement("select fcode,ffrom,tto,price,date,time from flights join passengerflight on fcode=flight where passenger = ? ");
            p.setString(1,passengerUSERNAME);
            ResultSet r=p.executeQuery(); 
            while(r.next())
            {
                arr.add(new flightsData(r.getString("fcode"),r.getString("ffrom"),r.getString("tto"),r.getInt("price"),r.getString("date"),r.getString("time")));
            }
        } catch (SQLException ex) {System.out.println(ex.getMessage());}  
         
           return arr;
    }
      
    
}
