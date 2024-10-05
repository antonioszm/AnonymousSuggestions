package controller;

import datasource.entity.ResponseEntity;
import datasource.entity.SugestionEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Get All Suggestions")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully"),
            @ApiResponse(responseCode = "404", description = "Suggestion not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping
    public List<SugestionEntity> getAll(){
        return service.getAll();
    }
    @Operation(summary = "Create Suggestion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Suggestion created successfully"),
            @ApiResponse(responseCode = "404", description = "Suggestion not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PostMapping
    public SugestionEntity save(@Parameter(description = "Suggestion JSON")@RequestBody SugestionEntity sugestion){
        return service.save(sugestion);
    }
    @Operation(summary = "Delete Suggestion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Suggestion deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Suggestion not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @DeleteMapping("/{id}")
    public void removeById(@Parameter(description = "Suggestion ID")@PathVariable Long id){
        service.removeById(id);
    }
    @Operation(summary = "Get Suggestion By Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully"),
            @ApiResponse(responseCode = "404", description = "Suggestion not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/{id}")
    public SugestionEntity getById(@Parameter(description = "Suggestion ID")@PathVariable Long id){
       return service.getById(id);
    }
    @Operation(summary = "Get Suggestion By Title")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully"),
            @ApiResponse(responseCode = "404", description = "Suggestion not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/{title}")
    public SugestionEntity getByTitle(@Parameter(description = "Suggestion Title")@PathVariable String title){
        return service.getByTitle(title);
    }

    @Operation(summary = "Update Suggestion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Suggestion updated successfully"),
            @ApiResponse(responseCode = "404", description = "Suggestion not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PutMapping
    public void update(@Parameter(description = "Suggestion JSON")@RequestBody SugestionEntity sugestion){
        service.update(sugestion.getId());
    }

    @Operation(summary = "Add a Response to a Suggestion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Response added successfully"),
            @ApiResponse(responseCode = "404", description = "Suggestion not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PostMapping("/{id}/response")
    public ResponseEntity addResponseToSugestion(@Parameter(description = "Suggestion ID") @PathVariable Long id,@Parameter(description = "Response JSON")@RequestBody ResponseEntity response){
        return responseService.addResponseToSugestion(id,response);
    }
}
