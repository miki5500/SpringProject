package Krzysztof.SpringProject.produkt;

import java.util.List;

public interface CategoryService {


    List<Category> findAllCategories();
    Category findByCategory(String category);
    Category findByIdCat(int id);
}
