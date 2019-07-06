package pl.zajacp.donateunusedthings.charity;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class DonationController {

    @PostMapping("/form")
    public String addDonation(@ModelAttribute("donation") Donation donation){


        int x = 1;

        System.out.println(1);

        return "form-confirmation";
    }
}

//    public String addDonation(@ModelAttribute("donation") @Valid Donation donation,