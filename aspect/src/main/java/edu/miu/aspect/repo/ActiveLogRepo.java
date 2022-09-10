package edu.miu.aspect.repo;

import edu.miu.aspect.entity.ActiveLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActiveLogRepo extends CrudRepository<ActiveLog,Integer> {
    List<ActiveLog> findAll();

}
