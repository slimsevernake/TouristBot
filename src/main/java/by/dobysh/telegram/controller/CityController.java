package by.dobysh.telegram.controller;

import by.dobysh.telegram.model.City;
import by.dobysh.telegram.repository.CityRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("city")
public class CityController {

    private CityRepo cityRepo;

    @Autowired
    public CityController(CityRepo cityRepo){
        this.cityRepo = cityRepo;
    }

    @GetMapping
    public Iterable<City> list() {
        return cityRepo.findAll();
    }

    @GetMapping("{id}")
    public City getOne(@PathVariable("id") City city) {
        return city;
    }

    @PostMapping
    public City create(@RequestBody City city) {
        return cityRepo.save(city);
    }

    @PutMapping("{id}")
    public City update(
            @PathVariable("id") City cityFromDb,
            @RequestBody City city
    ) {
        BeanUtils.copyProperties(city, cityFromDb, "id");

        return cityRepo.save(cityFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") City city) {
        cityRepo.delete(city);
    }
}
