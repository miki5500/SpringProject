package Krzysztof.SpringProject.produkt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findByCategory(String category) {
        return categoryRepository.findByCategory(category);
    }

    @Override
    public Category findByIdCat(int id) {
        return categoryRepository.findById(id);
    }
}
