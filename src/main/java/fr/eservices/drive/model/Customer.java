package fr.eservices.drive.model;



import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Entity
public class Customer  implements Serializable {

    @Id
    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Cart activeCart;

    public Cart getActiveCart() {
        return activeCart;
    }

    public void setActiveCart(Cart activeCart) {
        this.activeCart = activeCart;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
