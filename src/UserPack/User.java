package UserPack;

public class User {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String ssn;

    public User(String firstName, String lastName, String phoneNumber, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSsn() {
        return ssn;
    }

    public boolean authenticate(String username, String password){
        return true;
    }

}
