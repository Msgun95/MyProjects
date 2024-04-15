package myquiz.myfirstquiz.model;

public class EmailAdress {
    private String email;

    private Myenum myenum;

    public EmailAdress(String email, Myenum myenum) {
        this.email = email;
        this.myenum = myenum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Myenum getMyenum() {
        return myenum;
    }

    public void setMyenum(Myenum myenum) {
        this.myenum = myenum;
    }

    @Override
    public String toString() {
        return "EmailAdress{" +
                "email='" + email + '\'' +
                ", myenum=" + myenum +
                '}';
    }
}
