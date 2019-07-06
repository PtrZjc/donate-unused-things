package pl.zajacp.donateunusedthings.view;

import lombok.Data;
import pl.zajacp.donateunusedthings.charity.Institution;

@Data
class InstitutionViewRow {
    private Institution left;
    private Institution right;
}
