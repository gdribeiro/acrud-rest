package com.example.acrud.repo;

import com.example.acrud.domain.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TourRepository extends PagingAndSortingRepository<Tour, Integer> {

    Page<Tour> findByTourPackageCode(@Param("code")String code, Pageable pageable);
}
