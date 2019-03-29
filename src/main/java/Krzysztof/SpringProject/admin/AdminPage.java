package Krzysztof.SpringProject.admin;

import Krzysztof.SpringProject.user.User;
import Krzysztof.SpringProject.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.GET;
import java.util.List;

@Controller
public class AdminPage {

    @Autowired
    private UserService userService;

    @GET
    @RequestMapping(value = "/admin")
    @Secured(value = {"ROLE_ADMIN"})
    public String openAdminPage()
    {
        return "admin/admin";
    }

    @GET
    @RequestMapping(value = "/admin/users")
    @Secured(value = {"ROLE_ADMIN"})
    public String openAdminAllUsersPage(Model model)
    {
        List<User> userList = getAllUsers();
        model.addAttribute("userList",userList);
        return "admin/users";
    }

    private List<User> getAllUsers()
    {
        List<User> userList = userService.findAll();
        for(User users:userList)
        {
            int numerRoli = users.getRoles().iterator().next().getId();
            users.setNrRoli(numerRoli);
        }
        return userList;
    }

}
