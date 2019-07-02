package pl.zajacp.donateunusedthings.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
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
    private LocalDate pickUpDate;

    @NotNull
    private LocalTime pickUpTime;

    private String pickUpComment;

    @ManyToMany(mappedBy = "donations", cascade = CascadeType.ALL)
    private List<Category> categories;

    @ManyToOne
    @JoinColumn(name = "donations")
    private Institution institution;
}