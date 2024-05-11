//class flights_data
package elements;

public class flightsData
{
    public String fcode;
    public String ffrom;
    public String tto;
    public int price;
    public String date;
    public String time;
    public String status;
    
    //SHOW ALL
     public flightsData(String fcode, String ffrom, String tto, int price, String date, String time, boolean status)
    {
        this.fcode=fcode;
        this.ffrom=ffrom;
        this.tto=tto;
        this.price=price;
        this.date=date;
        this.time=time;
        if(status)
        {
            this.status ="true";
        }
        else{
            this.status ="false";
        }
       
        
    }

    //SHOW FOR USER(without addition,status)
    public flightsData(String fcode, String ffrom, String tto, int price, String date, String time) {
        this.fcode=fcode;
        this.ffrom=ffrom;
        this.tto=tto;
        this.price=price;
        this.date=date;
        this.time=time;
    }
}
 