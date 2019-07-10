package pl.zajacp.donateunusedthings.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.zajacp.donateunusedthings.charity.Category;
import pl.zajacp.donateunusedthings.charity.Donation;
import pl.zajacp.donateunusedthings.charity.DonationRepository;
import pl.zajacp.donateunusedthings.charity.Institution;

import javax.validation.Valid;
import java.util.List;


@Controller
public class HomeController {

    private final ViewDataService viewDataService;
    private final DonationRepository donationRepository;

    public HomeController(ViewDataService viewDataService, DonationRepository donationRepository) {
        this.viewDataService = viewDataService;
        this.donationRepository = donationRepository;
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
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping("/form")
    public String addDonation(@ModelAttribute("donation") @Valid Donation donation, BindingResult result){
        if (result.hasErrors()) {
            return "form";
        }
        donationRepository.save(donation);

        return "form-confirmation";
    }


    @GetMapping("/contact")
    public String contactPage() {
        return "redirect:/#contact";
    }

    @ModelAttribute("charities")
    public List<Institution> getCharities() {
        return viewDataService.getCharities();
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return viewDataService.getCategories();
    }
}