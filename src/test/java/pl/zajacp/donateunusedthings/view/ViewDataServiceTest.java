package pl.zajacp.donateunusedthings.view;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.zajacp.donateunusedthings.charity.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ViewDataServiceTest {

    @Mock
    private InstitutionRepository institutionRepository;

    @Mock
    private DonationRepository donationRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private ViewDataService viewDataService;

    private static List<Donation> donations = new ArrayList<>();
    private static List<Institution> institutions = new ArrayList<>();

    @BeforeClass
    public static void prepareData() {

        for (int i = 0; i < 5; i++) {
            institutions.add(new Institution());
            donations.add(new Donation());

            institutions.get(i).setId((long) (i + 1));
            donations.get(i).setId((long) (i + 1));
        }

        donations.get(0).setQuantity(1L);
        donations.get(1).setQuantity(2L);
        donations.get(2).setQuantity(2L);
        donations.get(3).setQuantity(3L);
        donations.get(4).setQuantity(4L);

        donations.get(0).setInstitution(institutions.get(0));
        donations.get(1).setInstitution(institutions.get(0));
        donations.get(2).setInstitution(institutions.get(1));
        donations.get(3).setInstitution(institutions.get(2));
        donations.get(4).setInstitution(institutions.get(3));
    }

    @Test
    public void getRowSortedCharities() {
        //given
        when(institutionRepository.findAllByOrderByNameAsc()).thenReturn(institutions);
        //when
        List<InstitutionViewRow> dataToShow = viewDataService.getRowSortedCharities();
        //then
        assertThat(dataToShow.size(), is(3));
        assertThat(dataToShow.get(1).getRight(), is(institutions.get(3)));
    }

    @Test
    public void getCollectedBagsNumber() {
        //given
        when(donationRepository.findAll()).thenReturn(donations);
        //when
        Long bagsNumber = viewDataService.getCollectedBagsNumber();
        //then
        assertThat(bagsNumber, is(12L));
    }

    @Test
    public void getHelpedCharitiesNumber() {
        //given
        when(donationRepository.findAll()).thenReturn(donations);
        //when
        Long charitiesHelped = viewDataService.getHelpedCharitiesNumber();
        //then
        assertThat(charitiesHelped, is(4L));
    }
}