package com.aziz.voyages.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aziz.voyages.entities.Image;
import com.aziz.voyages.entities.voyage;
import com.aziz.voyages.repos.ImageRepository;
import com.aziz.voyages.repos.voyageRepository;

@Service
public abstract class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    voyageRepository voyageRepository;

	/*
	 * public Image uploadImage(MultipartFile file) throws IOException { return
	 * imageRepository.save( Image.builder() .name(file.getOriginalFilename())
	 * .type(file.getContentType()) .image(file.getBytes()) .build() ); }
	 */

    @Override
    public Image getImageDetails(Long id) throws IOException {
        Optional<Image> dbImage = imageRepository.findById(id);
        return dbImage.map(image -> 
            Image.builder()
                .idImage(image.getIdImage())
                .name(image.getName())
                .type(image.getType())
                .image(image.getImage())
                .build()
        ).orElse(null);
    }

    @Override
    public ResponseEntity<byte[]> getImage(Long id) throws IOException {
        Optional<Image> dbImage = imageRepository.findById(id);
        return dbImage.map(image -> 
            ResponseEntity.ok()
                .contentType(MediaType.valueOf(image.getType()))
                .body(image.getImage())
        ).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }

    public Image uploadImageForvoyage(MultipartFile file, Long voyageId) throws IOException {
        voyage voyage = voyageRepository.findById(voyageId).orElseThrow(() -> new RuntimeException("voyage not found"));
        return imageRepository.save(
            Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(file.getBytes())
                .voyage(voyage)
                .build()
        );
    }

    public List<Image> getImagesByvoyage(Long voyageId) {
        voyage voyage = voyageRepository.findById(voyageId).orElseThrow(() -> new RuntimeException("voyage not found"));
        return voyage.getImages();
    }
}
