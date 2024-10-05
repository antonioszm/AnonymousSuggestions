package service;

import datasource.entity.ResponseEntity;
import datasource.entity.SugestionEntity;
import datasource.repository.ResponseRepository;
import datasource.repository.SugestionRepository;
import infra.exception.ResponseNotFoundException;
import infra.exception.SugestionNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class ResponseServiceImpl implements ResponseService {
    private final ResponseRepository repository;
    private final SugestionServiceImpl sugestionService;

    public ResponseServiceImpl(ResponseRepository repository, SugestionServiceImpl sugestionService) {
        this.repository = repository;
        this.sugestionService = sugestionService;
    }

    @Override
    public ResponseEntity save(ResponseEntity response) {
        response.setId(null);
        return repository.save(response);
    }

    @Override
    public ResponseEntity addResponseToSugestion(Long idSugestion,ResponseEntity response) {
        SugestionEntity sugestion = sugestionService.getById(idSugestion);

        response.setUploadDate(LocalDate.now());
        response.setSugestion(sugestion);
        sugestion.setUpdateDate(LocalDate.now());
        repository.save(response);
        sugestionService.save(sugestion);
        return response;
    }

    @Override
    public void update(Long id) {
        ResponseEntity response = getById(id);

        repository.update(response.getId(), response.getText(), response.getUploadDate(), response.getSugestion());
    }

    @Override
    public void removeById(Long id) {
        ResponseEntity response = getById(id);
        repository.delete(response);
    }

    @Override
    public List<ResponseEntity> getAll() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "uploadDate"));
    }

    @Override
    public ResponseEntity getById(Long id) {
        try {
            return repository.findById(id).orElseThrow(() -> new ResponseNotFoundException(id));
        } catch (ResponseNotFoundException e){
            log.error("Erro: {}",  e.getMessage());
            throw e;
        }
    }
}
