package com.aziz.voyages.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aziz.voyages.entities.Image;
public interface ImageRepository extends JpaRepository<Image , Long> {
}