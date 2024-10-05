package controller;

import datasource.entity.ResponseEntity;
import datasource.entity.SugestionEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;
import service.ResponseServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/response")
public class ResponseController {
    private ResponseServiceImpl service;

    public ResponseController(ResponseServiceImpl service) {this.service = service;}

    @Operation(summary = "Get All Suggestions")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully"),
            @ApiResponse(responseCode = "404", description = "Response not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping
    public List<ResponseEntity> getAll(){
        return service.getAll();
    }
    @Operation(summary = "Get Suggestion By Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully"),
            @ApiResponse(responseCode = "404", description = "Suggestion not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/{id}")
    public ResponseEntity getById(@Parameter(description = "Response ID")@PathVariable Long id){
        return service.getById(id);
    }

    @Operation(summary = "Create Response")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Response created successfully"),
            @ApiResponse(responseCode = "404", description = "Response not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PostMapping
    public ResponseEntity save(@Parameter(description = "Response JSON")@RequestBody ResponseEntity response){
        return service.save(response);
    }
    @Operation(summary = "Delete Response")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Response deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Response not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @DeleteMapping("/{id}")
    public void removeById(@Parameter(description = "Response ID")@PathVariable Long id){
        service.removeById(id);
    }
    @Operation(summary = "Update Response")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Response updated successfully"),
            @ApiResponse(responseCode = "404", description = "Response not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PutMapping
    public void update(@Parameter(description = "Response JSON")@RequestBody ResponseEntity response){
        service.update(response.getId());
    }
}
