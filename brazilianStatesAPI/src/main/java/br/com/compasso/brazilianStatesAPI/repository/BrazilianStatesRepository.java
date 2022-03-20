package br.com.compasso.brazilianStatesAPI.repository;

import br.com.compasso.brazilianStatesAPI.models.BrazilianState;
import br.com.compasso.brazilianStatesAPI.models.CountryZone;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BrazilianStatesRepository extends JpaRepository<BrazilianState, Long>{

    //Query method that filters states by zone
    List<BrazilianState> findByCountryZone(CountryZone countryZone, Sort sort);
    //Query method that fetches a state by id
    Optional<BrazilianState> findById(Long stateID);
}
