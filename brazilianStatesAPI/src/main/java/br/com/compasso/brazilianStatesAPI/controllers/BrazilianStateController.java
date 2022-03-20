package br.com.compasso.brazilianStatesAPI.controllers;

import br.com.compasso.brazilianStatesAPI.controllers.dto.BrazilianStateDTO;
import br.com.compasso.brazilianStatesAPI.controllers.forms.BrazilianStateFORM;
import br.com.compasso.brazilianStatesAPI.controllers.forms.BrazilianStateUpdateFORM;
import br.com.compasso.brazilianStatesAPI.models.BrazilianState;
import br.com.compasso.brazilianStatesAPI.models.CountryZone;
import br.com.compasso.brazilianStatesAPI.repository.BrazilianStatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/states")
public class BrazilianStateController {

    @Autowired
    BrazilianStatesRepository brazilianStateRepository;

    //POST method, to create a new entity
    @PostMapping
    @Transactional
    public ResponseEntity<BrazilianStateDTO> create
            (@RequestBody @Valid BrazilianStateFORM form, UriComponentsBuilder uriComponentsBuilder){

        BrazilianState brazilianState = new BrazilianState(form);
        brazilianStateRepository.save(brazilianState);

        URI uri = uriComponentsBuilder.path("api/states/{id}")
                .buildAndExpand(brazilianState.getStateID()).toUri();

        return ResponseEntity.created(uri).body(new BrazilianStateDTO(brazilianState));
    }

    //GET method, to get all entities, filters and sort parameters can be applied
    @GetMapping
    public List<BrazilianStateDTO>find
            (@RequestParam(required = false) CountryZone filterZone,
             @RequestParam(required = false) String orderBy) {

        //The filterZone param receives as value only the CountryZone enum values:
        // NORTE, NORDESTE, SUL, SUDESTE, CENTRO_OESTE

        //The orderBy param receives two values: population (to order by statePopulationAmount attribute) and
        //area (to order by stateArea attribute), both from the highest value to the lowest

        //if orderBy == null, the default sort value will be the stateId, in ascending order
        Sort sort = Sort.by(Sort.Direction.ASC, "stateID");

        if(orderBy != null){
            if (orderBy.equals("population")){
                //if orderBy == population, then the sort param will be the statePopulationAmount attribute,
                // in descending order
                sort = Sort.by(Sort.Direction.DESC, "statePopulationAmount");
            }else if(orderBy.equals("area")){
                //if orderBy == area, then the sort param will be the stateArea attribute, in descending order
                sort = Sort.by(Sort.Direction.DESC, "stateArea");
            }
        }

        if(filterZone == null){
            //if filterZone == null, the query method will fetch all entities by sorting by the parameter sort
            List<BrazilianState> brazilianStates = brazilianStateRepository.findAll(sort);
            return BrazilianStateDTO.convert(brazilianStates);
        }else {
            //if filterZone != null, the query method will fetch all entities with the countryZone == filterZone
            // value sorting by the parameter sort
            List<BrazilianState> brazilianStates = brazilianStateRepository.findByCountryZone(filterZone, sort);
            return BrazilianStateDTO.convert(brazilianStates);
        }
    }

    //GET method with id, to get a entity by the specified id
    @GetMapping("/{id}")
    public ResponseEntity<BrazilianStateDTO> findByID(@PathVariable Long id){

        Optional<BrazilianState> optional = brazilianStateRepository.findById(id);

        if(optional.isPresent()){
            //If the entity with the specified id exists, then it is returned
            return ResponseEntity.ok(new BrazilianStateDTO(optional.get()));
        } else {
            //Else, the 204 Not Content error is returned
            return ResponseEntity.noContent().build();
        }
    }

    //PUT method, to update an entity by id
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<BrazilianStateDTO> updateByID
            (@PathVariable Long id, @RequestBody @Valid BrazilianStateUpdateFORM form){

        Optional<BrazilianState> optional = brazilianStateRepository.findById(id);

        if (optional.isPresent()){
            //If the entity with the specified id exists, then it is updated by the update method
            BrazilianState brazilianState = form.update(id, brazilianStateRepository);
            return ResponseEntity.ok(new BrazilianStateDTO(brazilianState));
        } else{
            //Else, the 404 Not Found error is returned
            return ResponseEntity.notFound().build();
        }
    }

    //DELETE method with id specification
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteByID(@PathVariable Long id){

        Optional<BrazilianState> optional = brazilianStateRepository.findById(id);

        if(optional.isPresent()){
            //If the entity with the specified id exists, then it is deleted by the deleteById method
            brazilianStateRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }else {
            //Else, the 404 Not Found error is returned
            return ResponseEntity.notFound().build();
        }
    }
}
