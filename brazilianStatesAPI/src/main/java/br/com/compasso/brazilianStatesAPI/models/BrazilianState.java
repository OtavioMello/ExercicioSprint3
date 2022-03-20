package br.com.compasso.brazilianStatesAPI.models;

import br.com.compasso.brazilianStatesAPI.controllers.forms.BrazilianStateFORM;

import javax.persistence.*;

//State Entity Class

@Entity
public class BrazilianState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stateID;
    private String stateName;
    @Enumerated(EnumType.STRING)
    private CountryZone countryZone;
    private Long statePopulationAmount;
    private String stateCapital;
    private Double stateArea;

    public BrazilianState(){
        //Default Constructor
    }

    //Constructor
    public BrazilianState(String stateName, CountryZone countryZone,
                          Long statePopulationAmount, String stateCapital, Double stateArea) {

        this.stateName = stateName;
        this.countryZone = countryZone;
        this.statePopulationAmount = statePopulationAmount;
        this.stateCapital = stateCapital;
        this.stateArea = stateArea;
    }

    //Constructor that receives the form parameters
    public BrazilianState(BrazilianStateFORM form){
        this.stateName = form.getStateName();
        this.countryZone = form.getCountryZone();
        this.statePopulationAmount = form.getStatePopulationAmount();
        this.stateCapital = form.getStateCapital();
        this.stateArea = form.getStateArea();
    }

    //Getters and Setters
    public Long getStateID() {
        return stateID;
    }

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
