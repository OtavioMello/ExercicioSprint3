package br.com.compasso.brazilianStatesAPI.controllers.forms;

import br.com.compasso.brazilianStatesAPI.models.BrazilianState;
import br.com.compasso.brazilianStatesAPI.models.CountryZone;
import br.com.compasso.brazilianStatesAPI.repository.BrazilianStatesRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

//FORM Class used to receive customer data to update an entity, following good practice
public class BrazilianStateUpdateFORM {

    @NotNull @NotEmpty
    private String stateName;
    @NotNull
    private CountryZone countryZone;
    @NotNull
    private Long statePopulationAmount;
    @NotNull @NotEmpty
    private String stateCapital;
    @NotNull
    private Double stateArea;

    //Method that updates a BrazilianState entity with the BrazilianStateUpdateFORM data
    public BrazilianState update(Long id, BrazilianStatesRepository brazilianStateRepository) {

        BrazilianState brazilianState = brazilianStateRepository.getById(id);

        brazilianState.setStateName(this.stateName);
        brazilianState.setCountryZone(this.countryZone);
        brazilianState.setStatePopulationAmount(this.statePopulationAmount);
        brazilianState.setStateCapital(this.stateCapital);
        brazilianState.setStateArea(this.stateArea);

        return brazilianState;

    }

    //Getters and Setters
    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public CountryZone getCountryZone() {
        return countryZone;
    }

    public void setCountryZone(CountryZone countryZone) {
        this.countryZone = countryZone;
    }

    public Long getStatePopulationAmount() {
        return statePopulationAmount;
    }

    public void setStatePopulationAmount(Long statePopulationAmount) {
        this.statePopulationAmount = statePopulationAmount;
    }

    public String getStateCapital() {
        return stateCapital;
    }

    public void setStateCapital(String stateCapital) {
        this.stateCapital = stateCapital;
    }

    public Double getStateArea() {
        return stateArea;
    }

    public void setStateArea(Double stateArea) {
        this.stateArea = stateArea;
    }
}
