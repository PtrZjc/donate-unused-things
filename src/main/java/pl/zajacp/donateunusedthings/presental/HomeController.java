package pl.zajacp.donateunusedthings.presental;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.zajacp.donateunusedthings.model.Institution;
import pl.zajacp.donateunusedthings.model.InstitutionRepository;

import javax.swing.text.View;
import java.util.List;
import java.util.Map;


@Controller
public class HomeController {

    private final ViewDataService viewDataService;

    public HomeController(ViewDataService viewDataService) {
        this.viewDataService = viewDataService;
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        List<InstitutionViewRow> rowSortedCharities = viewDataService.getRowSortedCharities();
        model.addAttribute("rowSortedCharities", rowSortedCharities);
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