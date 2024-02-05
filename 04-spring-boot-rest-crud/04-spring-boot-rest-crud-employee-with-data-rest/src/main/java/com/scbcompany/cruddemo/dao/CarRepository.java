package com.scbcompany.cruddemo.dao;

import com.scbcompany.cruddemo.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface CarRepository extends JpaRepository<Car,Integer> {

}
