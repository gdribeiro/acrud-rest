package com.example.acrud.service;

import com.example.acrud.domain.Difficulty;
import com.example.acrud.domain.Region;
import com.example.acrud.domain.Tour;
import com.example.acrud.domain.TourPackage;
import com.example.acrud.repo.TourPackageRepository;
import com.example.acrud.repo.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService {
    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    public Tour createTour(String title, String description, String blurb, Integer price,
                           String duration, String bullets,
                           String keywords, String tourPackageName, Difficulty difficulty, Region region ) {

        TourPackage tourPackage = tourPackageRepository.findById(tourPackageName)
                .orElseThrow(() -> new RuntimeException("Tour Package does not exist!"));

        return tourRepository.save(
                new Tour(title, description,blurb, price, duration, bullets, keywords, tourPackage, difficulty, region)
        );
    }

    public Tour createTourByName(String title, String description, String blurb, Integer price,
                           String duration, String bullets,
                           String keywords, String tourPackageName, Difficulty difficulty, Region region ) {

        TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName)
                .orElseThrow(() -> new RuntimeException("Tour Package does not exist!"));

        return tourRepository.save(
                new Tour(title, description,blurb, price, duration, bullets, keywords, tourPackage, difficulty, region)
        );
    }

    public long total() {
        return tourRepository.count();
    }

}