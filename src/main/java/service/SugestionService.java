package service;

import datasource.entity.SugestionEntity;

import java.util.List;

public interface SugestionService {
    public SugestionEntity save(SugestionEntity sugestion);
    public void update(Long id);
    public void removeById(Long id);
    public List<SugestionEntity> getAll();
    public SugestionEntity getById(Long id);
    public SugestionEntity getByTitle(String title);
}
