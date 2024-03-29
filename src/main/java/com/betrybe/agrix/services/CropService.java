package com.betrybe.agrix.services;

import com.betrybe.agrix.exception.CropNotFoundException;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.repositories.CropRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Crop service.
 */
@Service
public class CropService {

  private final CropRepository cropRepository;

  /**
   * Instantiates a new Crop service.
   *
   * @param cropRepository the crop repository
   */
  @Autowired
  public CropService(CropRepository cropRepository) {
    this.cropRepository = cropRepository;
  }

  /**
   * Gets all crops.
   *
   * @return the all crops
   */
  public List<Crop> getAllCrops() {
    return cropRepository.findAll();
  }


  /**
   * Gets crop by id.
   *
   * @param id the crop id
   * @return the crop by id
   */
  public Crop getCropById(Long id) {
    Optional<Crop> cropOptional = cropRepository.findById(id);
    if (cropOptional.isEmpty()) {
      throw new CropNotFoundException();
    }

    return cropOptional.get();
  }
}
