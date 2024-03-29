package pl.zajacp.donateunusedthings.charity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.zajacp.donateunusedthings.user.User;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@Table(name = "donations")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(1)
    @Max(100)
    @NotNull
    private Long quantity;

    @NotBlank
    private String street;

    @NotBlank
    private String city;

    @Pattern(regexp = "\\d{2}-\\d{3}")
    private String zipCode;

    @Future
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    @NotNull
    private LocalTime pickUpTime;

    @NotNull
    private String phone;

    private String pickUpComment;

    @NotNull
    @ManyToMany(mappedBy = "donations", cascade = CascadeType.ALL)
    private List<Category> categories;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}