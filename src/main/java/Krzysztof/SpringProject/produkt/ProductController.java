package Krzysztof.SpringProject.produkt;

import Krzysztof.SpringProject.user.User;
import Krzysztof.SpringProject.user.UserService;
import Krzysztof.SpringProject.utilities.UserUtilities;
import Krzysztof.SpringProject.validators.ProduktValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    MessageSource messageSource;

    @GET
    @RequestMapping(value = "/addproductform")
    public String addProdukt(Model model)
    {
        String username = UserUtilities.gedLoggedUser();
        User user = userService.findUserByEmail(username);

        Produkt produkt = new Produkt();
        produkt.setSprzedajacy(user.getId());

        List<Category> categories = categoryService.findAllCategories();
        model.addAttribute("produkt", produkt);
        model.addAttribute("categories",categories);
        return "addproduct";
    }

    @POST
    @RequestMapping(value = "addproduct")
    public String saveProdukt(Produkt produkt, BindingResult result, Model model, Locale locale)
    {
        Category category = categoryService.findByIdCat(produkt.getCat());
        produkt.setCategory(new HashSet<Category>(Arrays.asList(category)));

        new ProduktValidator().validate(produkt,result);
        String returnPage = null;
        if(result.hasErrors())
        {
            returnPage = "/error";
        }else
        {
            productService.saveProduct(produkt);
            model.addAttribute("message",messageSource.getMessage("product.add.success",null,locale));
            model.addAttribute("user", new Produkt());
            returnPage = "/profil/sprzedane";
        }


        return returnPage;
    }



    @GET
    @RequestMapping(value = "/profil/sprzedane")
    public String printSprzedane(Model model)
    {
        String sprzedajacy = UserUtilities.gedLoggedUser();
        User user = userService.findUserByEmail(sprzedajacy);

        List<Produkt> sprzedane = getProducts(user.getId());
        model.addAttribute("sprzedaneList",sprzedane);
        return "profilsprzedane";
    }

    private List<Produkt> getProducts(int id)
    {
        List<Produkt> sprzedane = productService.findProduktBySprzedajacy(id - 1);
        for (Produkt pp:sprzedane)
        {
            pp.setCateg(pp.getCategory().iterator().next().getCategory());

        }

        return sprzedane;
    }

    private List<Produkt> getAllProducts()
    {
        List<Produkt> sprzedane = productService.findAll();
        for (Produkt pp:sprzedane)
        {
            pp.setCateg(pp.getCategory().iterator().next().getCategory());

        }

        return sprzedane;
    }

    @GET
    @RequestMapping(value = "/all")
    public String printAll(Model model)
    {

        List<Produkt> sprzedane = getAllProducts();
        model.addAttribute("sprzedaneList",sprzedane);
        return "allproducts";
    }


}
