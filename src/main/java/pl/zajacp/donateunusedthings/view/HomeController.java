package pl.zajacp.donateunusedthings.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.zajacp.donateunusedthings.charity.Donation;

import java.util.List;


@Controller
public class HomeController {

    private final ViewDataService viewDataService;

    public HomeController(ViewDataService viewDataService) {
        this.viewDataService = viewDataService;
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("rowSortedCharities", viewDataService.getRowSortedCharities());
        model.addAttribute("collectedBagsNumber", viewDataService.getCollectedBagsNumber());
        model.addAttribute("helpedCharitiesNumber", viewDataService.getHelpedCharitiesNumber());
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
    public String formPage(Model model, Donation donation) {
        model.addAttribute("charities", viewDataService.getCharities());
        model.addAttribute("categories",viewDataService.getCategories());
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "redirect:/#contact";
    }
}