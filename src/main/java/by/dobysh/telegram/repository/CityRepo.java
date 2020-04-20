package by.dobysh.telegram.repository;

import by.dobysh.telegram.model.City;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

//public interface CityRepo extends JpaRepository<City, Long> {
//
//    @Query("SELECT t FROM City t where t.name = :name")
//    public Optional<City> findByName(@Param("name") String name);
//Optional<Passenger> findFirstByOrderByIdAsc();
//}


public interface CityRepo extends CrudRepository<City, Long> {

//    List<City> findFirstByName(String name);

    City findFirstByName(String name);

}