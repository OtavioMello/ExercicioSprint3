package br.com.compasso.brazilianStatesAPI.controllers.dto;

import br.com.compasso.brazilianStatesAPI.models.BrazilianState;
import br.com.compasso.brazilianStatesAPI.models.CountryZone;

import java.util.List;
import java.util.stream.Collectors;

//DTO Class used to return data from the API server to the client, following good practice
public class BrazilianStateDTO {

    private Long stateID;
    private String stateName;
    private CountryZone countryZone;
    private Long statePopulationAmount;
    private String stateCapital;
    private Double stateArea;

    //Constructor that receives the BrazilianState entity data
    public BrazilianStateDTO(BrazilianState brazilianState){

        this.stateID = brazilianState.getStateID();
        this.stateName = brazilianState.getStateName();
        this.countryZone = brazilianState.getCountryZone();
        this.statePopulationAmount = brazilianState.getStatePopulationAmount();
        this.stateCapital = brazilianState.getStateCapital();
        this.stateArea = brazilianState.getStateArea();

    }

    //Getters and Setters
    public Long getStateID() {
        return stateID;
    }

    public void setStateID(Long stateID) {
        this.stateID = stateID;
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

    //Method that builds a list of BrazilianStateDTO with each entity in the brazilianStates List
    public static List<BrazilianStateDTO> convert(List<BrazilianState> brazilianStates) {
        return brazilianStates.stream().map(BrazilianStateDTO::new).collect(Collectors.toList());
    }
}
