package pl.zajacp.donateunusedthings.presental;

import lombok.Data;
import pl.zajacp.donateunusedthings.model.Institution;

@Data
class InstitutionViewRow {
    private Institution left;
    private Institution right;
}
