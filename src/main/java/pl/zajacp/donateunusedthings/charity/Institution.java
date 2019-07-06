package pl.zajacp.donateunusedthings.charity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
@Table(name = "institutions")
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(length = 100)
    private String name;

    @NotBlank
    @Column(length = 100)
    private String description;

    @OneToMany(mappedBy = "institution", cascade = CascadeType.ALL)
    private List<Donation> donations;
}
