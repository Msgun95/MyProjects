package myquiz.myfirstquiz.model;

public class PhoneNumber {

    private String phonenumber;
    public Myenum myenum;

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Myenum getMyenum() {
        return myenum;
    }

    public void setMyenum(Myenum myenum) {
        this.myenum = myenum;
    }

    public PhoneNumber(String phonenumber, Myenum myenum) {
        this.phonenumber = phonenumber;
        this.myenum = myenum;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "phonenumber=" + phonenumber +
                ", myenum=" + myenum +
                '}';
    }
}
