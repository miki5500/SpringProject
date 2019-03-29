package Krzysztof.SpringProject.mainController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.GET;

@Controller
public class loginController {

    @GET
    @RequestMapping(value="/login")
    public String getLoginPage()
    {
        return "login";
    }
}
