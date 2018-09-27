package mangomax.demo.model;

public class User {

    private int userId;
    private String userName;
    private String userMail;
    private String userPhoneNumber;
    private String userPassword;
    private int fkRoleId;

    public User(int userId, String userName, String userMail,
                String userPhoneNumber, String userPassword, int fkRoleId) {
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
    public void setUserName() {
        this.userName = userName;
    }

    public String getUserMail() {
        return userMail;
    }
    public void setUserMail() {
        this.userMail = userMail;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {

        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword() {
        this.userPassword = userPassword;
    }

    public int getFkRoleId() {
        return fkRoleId;
    }
    public void setFkRoleId(int fkRoleId) {
        this.fkRoleId = fkRoleId;
    }
}
