package pl.zajacp.donateunusedthings.view;

import org.springframework.stereotype.Service;
import pl.zajacp.donateunusedthings.charity.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class ViewDataService {
    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;
    private final CategoryRepository categoryRepository;

    public ViewDataService(InstitutionRepository institutionRepository, DonationRepository donationRepository, CategoryRepository categoryRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
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

    List<Institution> getCharities(){
        return institutionRepository.findAllByOrderByNameAsc();
    }

    List<Category> getCategories(){
        return categoryRepository.findAll();
    }
}
