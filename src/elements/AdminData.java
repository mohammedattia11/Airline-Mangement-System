
//login_data كلاس الاراي بتاع اللوجن
package elements;


public class AdminData {
    private String username,password;

    public AdminData(String username, String password) {
        this.username =username;
        this.password = password;
    }

     public void setusername(String username) {
        this.username = username;
     }
    public String getusername() {
        return username;
    }

   
     public void setpassword(String password) {
        this.password = password;
    }
    

    public String getpassword() {
        return password;
    }

   
}
