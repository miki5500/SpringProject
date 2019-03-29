package Krzysztof.SpringProject.produkt;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "product")
public class Produkt {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private int id;

    @Column(name = "product_name")
    @NotNull
    private String pName;

    @Column(name = "product_opis")
    @NotNull
    private String pDescription;

    @Column(name = "product_price")
    @NotNull
    private double price;

    @Column(name = "product_amount")
    @NotNull
    private int amount;

    @Column(name = "sprzedane")
    @NotNull
    private boolean sprzedane;

    @Column(name = "user_id")
    private int sprzedajacy;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"),inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> category;

    @Transient
    private int cat;

    @Transient String categ;

    public String getCateg() {
        return categ;
    }

    public void setCateg(String categ) {
        this.categ = categ;
    }

    public int getCat() {
        return cat;
    }

    public void setCat(int cat) {
        this.cat = cat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isSprzedane() {
        return sprzedane;
    }

    public void setSprzedane(boolean sprzedane) {
        this.sprzedane = sprzedane;
    }

    public int getSprzedajacy() {
        return sprzedajacy;
    }

    public void setSprzedajacy(int sprzedajacy) {
        this.sprzedajacy = sprzedajacy;
    }

    public Set<Category> getCategory() {
        return category;
    }

    public void setCategory(Set<Category> category) {
        this.category = category;
    }
}
