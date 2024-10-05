package datasource.repository;

import datasource.entity.SugestionEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
@Repository
public interface ResponseRepository {
    @Modifying
    @Transactional
    @Query("UPDATE RepositoryEntity r SET r.text = :text, r.uploadDate = :upload_date, r.id_sugestion = :id_sugestion WHERE r.id = :id")
    void update(@Param("id") Long id,
                @Param("title") String text,
                @Param("upload_date") LocalDate uploadDate,
                @Param("update_date") SugestionEntity id_sugestion
    );
}
