package com.scbcompany.cruddemo.dao;

import com.scbcompany.cruddemo.entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepository extends JpaRepository<Cars,Integer> {

}
