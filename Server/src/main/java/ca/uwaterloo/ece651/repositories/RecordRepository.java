package ca.uwaterloo.ece651.repositories;

import ca.uwaterloo.ece651.models.Record;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends CrudRepository<Record, Long> {
    List<Record> findByUid(Long uid);
}
