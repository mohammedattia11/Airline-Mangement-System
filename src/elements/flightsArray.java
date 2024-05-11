//flights_data اراي ليست جدول 
package elements;


public class flightsArray {
    public String fcode;
    public String ffrom;
    public String tto;
    public int price;
    public String date;
    public String time;
    public String Avilability;

    public flightsArray(String fcode, String ffrom, String tto, int price, String date, String time) {
        this.fcode = fcode;
        this.ffrom = ffrom;
        this.tto = tto;
        this.price = price;
        this.date = date;
        this.time = time;
        
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }

    public String getFfrom() {
        return ffrom;
    }

    public void setFfrom(String ffrom) {
        this.ffrom = ffrom;
    }

    public String getTto() {
        return tto;
    }

    public void setTto(String tto) {
        this.tto = tto;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public String getAvilability() {
        return Avilability;
    }

    public void setAvilability(String avilability) {
        this.Avilability = Avilability;
    }
    
    
    
}
