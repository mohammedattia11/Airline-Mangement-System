//class passengers_data
package elements;

public class passengersData
{
    public String userName,pass,email,name,address,nationality,passportNumber;
    public int age;

    public passengersData(String username, String pass, String email, String name, String address, String nationality, String passportnumber, int age)
    {
        this.userName = username;
        this.pass = pass;
        this.email = email;
        this.name = name;
        this.address = address;
        this.nationality = nationality;
        this.passportNumber = passportnumber;
        this.age = age;
    }
    
    
}
