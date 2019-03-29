package Krzysztof.SpringProject.produkt;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Produkt findProduktById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Produkt> findAll()
    {
        return productRepository.findAll();
    }

    @Override
    public List<Produkt> findProduktByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Produkt> findProduktBySprzedajacy(int id) {
        return productRepository.findBySprzedajacy(id);
    }

    @Override
    public void saveProduct(Produkt produkt) {
        productRepository.save(produkt);
    }

    @Override
    public void buyProduct(int id) {

    }
}
