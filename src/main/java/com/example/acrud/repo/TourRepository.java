package com.example.acrud.repo;

import com.example.acrud.domain.Tour;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TourRepository extends CrudRepository<Tour, Integer> {

    List<Tour> findByTourPackageCode(@Param("code")String code);
}
