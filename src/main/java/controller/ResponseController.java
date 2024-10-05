package controller;

import datasource.entity.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ResponseServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/response")
public class ResponseController {
    private ResponseServiceImpl service;

    public ResponseController(ResponseServiceImpl service) {this.service = service;}

    @GetMapping
    public List<ResponseEntity> getAll(){
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ResponseEntity response){
        return service.save(response);
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable Long id){
        service.removeById(id);
    }

    @PutMapping
    public void update(@RequestBody ResponseEntity response){
        service.update(response.getId());
    }
}
