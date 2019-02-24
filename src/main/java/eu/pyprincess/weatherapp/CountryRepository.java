package eu.pyprincess.weatherapp;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findAll();

}
