package datasource.repository;

import datasource.entity.ResponseEntity;
import datasource.entity.SugestionEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
@Repository
public interface ResponseRepository extends JpaRepository<ResponseEntity, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE RepositoryEntity r SET r.text = :text, r.uploadDate = :upload_date, r.sugestion = :id_sugestion WHERE r.id = :id")
    void update(@Param("id") Long id,
                @Param("title") String text,
                @Param("upload_date") LocalDate uploadDate,
                @Param("update_date") SugestionEntity id_sugestion
    );
}
