package Krzysztof.SpringProject.produkt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Produkt,Integer> {

    Produkt findById(int id);
    List<Produkt> findByCategory(String category);
    List<Produkt> findBySprzedajacy(int id);
}
