package Krzysztof.SpringProject.produkt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("categoryRepository")
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    @Override
    List<Category> findAll();
    Category findById(int id);
    Category findByCategory(String cat);
}
