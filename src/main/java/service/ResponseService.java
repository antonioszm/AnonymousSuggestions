package service;

import datasource.entity.ResponseEntity;

import java.util.List;

public interface ResponseService {
    public ResponseEntity save(ResponseEntity response);
    public ResponseEntity addResponseToSugestion(Long idSugestion,ResponseEntity response);
    public void update(Long id);
    public void removeById(Long id);
    public List<ResponseEntity> getAll();
    public ResponseEntity getById(Long id);
}
