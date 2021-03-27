public class User {
    private String uname;
    private String password;

    public User() {
        super();
    }

    public User(String uname, String password) {
        super();
        this.uname = uname;
        this.password = password;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
