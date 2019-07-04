package pl.zajacp.donateunusedthings.presental;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import pl.zajacp.donateunusedthings.model.Donation;
import pl.zajacp.donateunusedthings.model.DonationRepository;
import pl.zajacp.donateunusedthings.model.Institution;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ViewDataServiceTest {

    public final DonationRepository donationRepository;
    public final ViewDataService viewDataService;

    private static List<Donation> donations;
    private static List<Institution> institutions;

    public ViewDataServiceTest() {
        this.donationRepository = mock(DonationRepository.class);
        this.viewDataService = mock(ViewDataService.class);

        when(donationRepository.findAll()).thenReturn(donations);
    }

    private void PrepareData() {
        Donation dnt1 = new Donation();
        Donation dnt2 = new Donation();
        Donation dnt3 = new Donation();
        Donation dnt4 = new Donation();

        Institution instA = new Institution();
        Institution instB = new Institution();
        Institution instC = new Institution();
        Institution instD = new Institution();

        instA.setId(1L);
        instB.setId(2L);
        instC.setId(3L);
        instD.setId(4L);

        dnt1.setQuantity(1L);
        dnt2.setQuantity(2L);
        dnt3.setQuantity(3L);
        dnt4.setQuantity(4L);

        dnt1.setInstitution(instA);
        dnt2.setInstitution(instB);
        dnt3.setInstitution(instB);
        dnt4.setInstitution(instC);

        donations = List.of(dnt1, dnt2, dnt3, dnt4);
    }

    @Test
    public void getRowSortedCharities() {
    }

    @Test
    public void getCollectedBagsNumber() {
        //given
        PrepareData();
        when(donationRepository.findAll()).thenReturn(donations);
        //when
        Long bagsNumber = viewDataService.getCollectedBagsNumber();
        //then
        assertThat(bagsNumber, is(7L));
    }

    @Test
    public void getHelpedCharitiesNumber() {
        //given
        PrepareData();
        when(donationRepository.findAll()).thenReturn(donations);
        //when
        Long charitiesHelped = viewDataService.getHelpedCharitiesNumber();
        //then
        assertThat(charitiesHelped, is(3L));
    }
}