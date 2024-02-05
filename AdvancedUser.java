package main;

public abstract class AdvancedUser extends User {

    protected String name;
    protected String mobileNumber;
    protected String emailAddress;

    public AdvancedUser(String Username, String Password, String Name, String MobileNumber, String EmailAddress) {
        super(Username, Password);
        this.name = Name;
        this.mobileNumber = MobileNumber;
        this.emailAddress = EmailAddress;
    }

    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

}
