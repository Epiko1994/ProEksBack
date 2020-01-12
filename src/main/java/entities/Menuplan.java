package entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Menuplan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shoppingList;

    @OneToMany
    private List<Dayplan> dayplans;

    @OneToMany
    private List<User> users;

    public Menuplan() {
    }


    public Menuplan(String shoppingList) {
        this.shoppingList = shoppingList;
    }

    public Long getId() {
        return id;
    }

    public String getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(String shoppingList) {
        this.shoppingList = shoppingList;
    }

    public List<Dayplan> getDayplans() {
        return dayplans;
    }

    public void setDayplans(List<Dayplan> dayplans) {
        this.dayplans = dayplans;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
