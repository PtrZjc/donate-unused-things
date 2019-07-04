package pl.zajacp.donateunusedthings.presental;

import org.springframework.stereotype.Service;
import pl.zajacp.donateunusedthings.model.Donation;
import pl.zajacp.donateunusedthings.model.DonationRepository;
import pl.zajacp.donateunusedthings.model.Institution;
import pl.zajacp.donateunusedthings.model.InstitutionRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ViewDataService {
    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    public ViewDataService(InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }

    List<InstitutionViewRow> getRowSortedCharities() {
        List<Institution> institutions = institutionRepository.findAllByOrderByNameAsc();
        List<InstitutionViewRow> listRows = new ArrayList<>();

        for (int i = 0; i < institutions.size(); i += 2) {
            InstitutionViewRow row = new InstitutionViewRow();
            row.setLeft(institutions.get(i));
            if (i != institutions.size() - 1) {
                row.setRight(institutions.get(i + 1));
            }
            listRows.add(row);
        }
        return listRows;
    }

    Long getCollectedBagsNumber(){
        return donationRepository.findAll().stream()
                .map(Donation::getQuantity)
                .reduce(0L, Long::sum);
    }

    Long getHelpedCharitiesNumber(){
        return donationRepository.findAll().stream()
                .map(Donation::getInstitution)
                .distinct()
                .count();
    }
}
