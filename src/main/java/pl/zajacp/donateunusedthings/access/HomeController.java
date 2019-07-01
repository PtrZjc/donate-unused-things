package pl.zajacp.donateunusedthings.access;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {


    @RequestMapping("/")
    public String homeAction(Model model){
        return "index";
    }

}
