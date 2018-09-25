package mangomax.demo.model;

public class User {

    private int userId;
    private String userName;
    private String userMail;
    private int userPhoneNumber;
    private String userPassword;
    private String fkRoleId;

    public User(int userId, String userName, String userMail,
                int userPhoneNumber, String userPassword, String fkRoleId) {
        this.userId = userId;
        this.userName = userName;
        this.userMail = userMail;
        this.userPhoneNumber = userPhoneNumber;
        this.userPassword = userPassword;
        this.fkRoleId = fkRoleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public int getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(int userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getFkRoleId() {
        return fkRoleId;
    }

    public void setFkRoleId(String fkRoleId) {
        this.fkRoleId = fkRoleId;
    }
}
