public class akunlonan {
    protected String username;
    protected String password;

    akunlonan(String user, String pass){
        this.username = user;
        this.password = pass;
    }

    public String getusername(){
        return username;
    }

    public String getPass(){
        return password;
    }
}
