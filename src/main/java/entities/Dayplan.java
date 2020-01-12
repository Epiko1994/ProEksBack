package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Dayplan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dayofweek;

    @OneToOne
    private Ingredient ingredient;

    @ManyToOne
    private Menuplan menuplan;

    public Dayplan(Ingredient ingredient, String dayofweek) {
        this.ingredient = ingredient;
        this.dayofweek = dayofweek;
    }

    public Dayplan() {
    }

    public Long getId() {
        return id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setrecipe(String email) {
        this.ingredient = ingredient;
    }

    public String getDayofweek() {
        return dayofweek;
    }

    public void setDayofweek(String dayofweek) {
        this.dayofweek = dayofweek;
    }

}
