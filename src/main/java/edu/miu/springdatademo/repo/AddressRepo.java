package edu.miu.springdatademo.repo;

import edu.miu.springdatademo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AddressRepo extends JpaRepository<Address,Integer> {
//    Optional<Address> findByZipBetween(Integer min, Integer max);
//
//    @Query("SELECT a from Address a WHERE a.zip > ?1 AND a.zip < ?2")
//    Optional<Address> myCustomFinder(Integer min, Integer max);
//
//    @Query(value = "SELECT * from Address a WHERE a.zip > ?1 AND a.zip < ?2", nativeQuery = true)
//    Optional<Address> myCustomFinderSQL(Integer min, Integer max);
}
