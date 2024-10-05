package datasource.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface SugestionRepository {
    @Modifying
    @Transactional
    @Query("UPDATE SugentionEntity s SET s.title = :title, s.description = :description, s.uploadDate = :upload_date, s.updateDate = :update_date WHERE s.id = :id")
    void update(@Param("id") Long id,
                @Param("title") String title,
                @Param("description") String description,
                @Param("upload_date") LocalDate uploadDate,
                @Param("update_date") LocalDate updateDate
                );
}
