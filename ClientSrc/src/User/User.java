package User;

import java.io.Serializable;

public class User implements Serializable {
    public int id=0;
    public String login="0";
    public String password="0";
    public int isLocked=0;
    public int isAdmin=0;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(User ob)
    {
        this.id=ob.id;
        this.login = ob.login;
        this.password = ob.password;
        this.isLocked = ob.isLocked;
        this.isAdmin = ob.isAdmin;
    }

    public User(int id,String login, String password, int isLocked, int isAdmin) {
        this.id=id;
        this.login = login;
        this.password = password;
        this.isLocked = isLocked;
        this.isAdmin = isAdmin;
    }
    public User(String login, String password, int isLocked, int isAdmin) {
        this.login = login;
        this.password = password;
        this.isLocked = isLocked;
        this.isAdmin = isAdmin;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(int isLocked) {
        this.isLocked = isLocked;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

}
