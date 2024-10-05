package controller;

import datasource.entity.ResponseEntity;
import datasource.entity.SugestionEntity;
import org.springframework.web.bind.annotation.*;
import service.ResponseServiceImpl;
import service.SugestionServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/sugestion")
public class SugestionController {
    private SugestionServiceImpl service;
    private ResponseServiceImpl responseService;


    public SugestionController(SugestionServiceImpl service) {this.service = service;}

    @GetMapping
    public List<SugestionEntity> getAll(){
        return service.getAll();
    }

    @PostMapping
    public SugestionEntity save(@RequestBody SugestionEntity sugestion){
        return service.save(sugestion);
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable Long id){
        service.removeById(id);
    }

    @PutMapping
    public void update(@RequestBody SugestionEntity sugestion){
        service.update(sugestion.getId());
    }

    @PostMapping("/{id}/response")
    public ResponseEntity addResponseToSugestion(@PathVariable Long id,@RequestBody ResponseEntity response){
        return responseService.addResponseToSugestion(id,response);
    }
}
