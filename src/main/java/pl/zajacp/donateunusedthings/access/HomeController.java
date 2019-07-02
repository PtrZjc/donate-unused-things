package pl.zajacp.donateunusedthings.access;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {

    @GetMapping("/")
    public String mainPage(Model model) {
        return "index";
    }

    @GetMapping("/steps")
    public String stepsPage() {
        return "redirect:/#steps";
    }

    @GetMapping("/about-us")
    public String aboutUsPage() {
        return "redirect:/#about-us";
    }

    @GetMapping("/help")
    public String helpPage() {
        return "redirect:/#help";
    }

    @GetMapping("/form")
    public String formPage() {
        return "form";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "redirect:/#contact";
    }
}