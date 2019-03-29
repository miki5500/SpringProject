package Krzysztof.SpringProject.apis;

import Krzysztof.SpringProject.produkt.ProductRepository;
import Krzysztof.SpringProject.produkt.Produkt;
import Krzysztof.SpringProject.user.User;
import Krzysztof.SpringProject.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class restApi {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/api/getproducts/all")
    List<Produkt> all()
    {
        return productRepository.findAll();
    }

    @GetMapping(value = "/api/getproducts/{category}")
    List<Produkt> getByProductCategory(@PathVariable String category)
    {
        return productRepository.findByCategory(category);
    }

    @PostMapping(value = "/api/addproduct")
    Produkt addProductByApi(@RequestBody Produkt newProduct)
    {
        return productRepository.save(newProduct);
    }

    @PostMapping(value = "/api/register")
    User registerUser(@RequestBody User newUser)
    {
        return userRepository.save(newUser);
    }

    @GetMapping(value = "/api/getuserlist")
    @Secured(value = "ROLE_ADMIN")
    List<User> getAllUserR()
    {
        return userRepository.findAll();
    }

    @PutMapping(value = "/api/updateuser")
    @Secured(value = "ROLE_ADMIN")
    User updateUserData(@RequestBody User uptUser)
    {
        userRepository.updateUserProfile(uptUser.getName(),uptUser.getLastName(),uptUser.getEmail(),uptUser.getId());
        return uptUser;
    }

}
