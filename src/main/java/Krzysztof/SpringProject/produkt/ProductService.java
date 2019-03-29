package Krzysztof.SpringProject.produkt;

import java.util.List;

public interface ProductService {
    Produkt findProduktById(int id);
    List<Produkt> findAll();
    List<Produkt> findProduktByCategory(String category);
    List<Produkt> findProduktBySprzedajacy(int id);
    void saveProduct(Produkt produkt);
    void buyProduct(int id);

}
