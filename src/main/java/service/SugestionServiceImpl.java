package service;

import datasource.entity.SugestionEntity;
import datasource.repository.SugestionRepository;
import infra.exception.SugestionNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SugestionServiceImpl implements SugestionService {
    private final SugestionRepository repository;

    public SugestionServiceImpl(SugestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public SugestionEntity save(SugestionEntity sugestion) {
        sugestion.setId(null);
        return repository.save(sugestion);
    }

    @Override
    public void update(Long id) {
        SugestionEntity sugestion = getById(id);
        repository.update(sugestion.getId(), sugestion.getTitle(), sugestion.getDescription(), sugestion.getUploadDate(), sugestion.getUpdateDate());
    }

    @Override
    public void removeById(Long id) {
        SugestionEntity sugestion = getById(id);
        repository.delete(sugestion);
    }

    @Override
    public List<SugestionEntity> getAll() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "updateDate"));
    }

    @Override
    public SugestionEntity getById(Long id) {
        try {
            return repository.findById(id).orElseThrow(() -> new SugestionNotFoundException(id));
        } catch (SugestionNotFoundException e){
            log.error("Erro: {}",  e.getMessage());
            throw e;
        }
    }
    @Override
    public SugestionEntity getByTitle(String title) {
        return repository.getByTitle(title);
    }
}

