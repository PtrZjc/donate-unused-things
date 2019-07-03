package pl.zajacp.donateunusedthings.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {
    List<Institution> findAllByOrderByNameAsc();
}

