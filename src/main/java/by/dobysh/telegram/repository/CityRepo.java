package by.dobysh.telegram.repository;

import by.dobysh.telegram.model.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepo extends CrudRepository<City, Long> {

    City findFirstByName(String name);

}