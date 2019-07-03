package pl.zajacp.donateunusedthings.presental;

import org.springframework.stereotype.Service;
import pl.zajacp.donateunusedthings.model.Institution;
import pl.zajacp.donateunusedthings.model.InstitutionRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ViewDataService {
    private final InstitutionRepository institutionRepository;

    public ViewDataService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
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
}
