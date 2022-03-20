package br.com.compasso.brazilianStatesAPI.controllers.forms;

import br.com.compasso.brazilianStatesAPI.models.BrazilianState;
import br.com.compasso.brazilianStatesAPI.models.CountryZone;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

//FORM Class used to receive client data, following good practice
public class BrazilianStateFORM {

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

    //Method that converts a BrazilianStateFORM to an BrazilianState entity
    public BrazilianState convert() {
        return new BrazilianState(this.stateName, this.getCountryZone(), this.getStatePopulationAmount(), this.getStateCapital(), this.getStateArea());
    }

}
