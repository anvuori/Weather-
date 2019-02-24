package eu.pyprincess.weatherapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface WeatherUserRepository extends JpaRepository<WeatherUser, String> {
}
