package pl.zajacp.donateunusedthings.access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import pl.zajacp.donateunusedthings.user.UserDto;
import pl.zajacp.donateunusedthings.user.UserService;
import pl.zajacp.donateunusedthings.user.validation.EmailExistsException;

import javax.validation.Valid;

@Controller
public class AccessController {

    UserService userService;

    @Autowired
    public AccessController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "register";
    }

    @PostMapping("/register")
    public String registerUserAccount
            (@ModelAttribute("user") @Valid UserDto userDto,
             BindingResult result, Model model) {

        if (!result.hasErrors()) {
            try {
                userService.registerNewUserAccount(userDto);
            } catch (EmailExistsException e) {
                result.rejectValue("email", "error.emailExists");
            }
        }

        model.addAttribute("user", userDto);

        if (result.hasErrors()) {
            return "registration";
        }
        model.addAttribute("registered", true);
        return "login";
    }

    @GetMapping("/logged")
    public String loggedInfo() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
        } else {
            String username = principal.toString();
        }

        System.out.println(principal);

        return "index";
    }
}
