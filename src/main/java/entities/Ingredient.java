package entities;

import javax.persistence.*;
import java.util.List;


@Entity
public class Ingredient {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private int price;

    @ManyToOne
    private Dayplan dayplan;

    public Ingredient() {
    }

    public Ingredient(String description, int price) {
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Dayplan getDayplan() {
        return dayplan;
    }

    public void setDayplan(Dayplan dayplan) {
        this.dayplan = dayplan;
    }
}
