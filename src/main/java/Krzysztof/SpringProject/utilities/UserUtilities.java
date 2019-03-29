package Krzysztof.SpringProject.utilities;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtilities {

    public static String gedLoggedUser()
    {
        String username = null;

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!(auth instanceof AnonymousAuthenticationToken))
        {
           username=auth.getName();
        }
        return username;
    }
}
