package Krzysztof.SpringProject.produkt;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pcategory")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private int id;

    @Column(name = "category_name")
    @NotNull
    private String category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
