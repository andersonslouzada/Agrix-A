package com.betrybe.agrix.services;

import com.betrybe.agrix.exception.NotFoundException;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.models.repositories.CropRepository;
import com.betrybe.agrix.models.repositories.FarmRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * The type Farm service.
 */
@Service
public class FarmService {

  private final FarmRepository farmRepository;

  /**
   * Instantiates a new Farm service.
   *
   * @param farmRepository the farm repository
   * @param cropRepository the crop repository
   */
  public FarmService(FarmRepository farmRepository, CropRepository cropRepository) {
    this.farmRepository = farmRepository;
  }

  /**
   * Create farm farm.
   *
   * @param farm the farm
   * @return the farm
   */
  public Farm createFarm(Farm farm) {
    return farmRepository.save(farm);
  }

  /**
   * Gets all farms.
   *
   * @return the all farms
   */
  public List<Farm> getAllFarms() {
    return farmRepository.findAll();
  }

  /**
   * Gets farm by id.
   *
   * @param id the farm id
   * @return the farm by id
   */
  public Farm getFarmById(Long id) {
    Optional<Farm> optionalFarm = farmRepository.findById(id);
    if (optionalFarm.isEmpty()) {
      throw new NotFoundException();
    }

    return optionalFarm.get();
  }

  /**
   * Gets crops by farm id.
   *
   * @param id the id
   * @return the crops by farm id
   */
  public List<Crop> getCropsByFarmId(Long id) {
    Optional<Farm> farmOptional = farmRepository.findById(id);
    if (farmOptional.isEmpty()) {
      throw new NotFoundException();
    }

    Farm farm = farmOptional.get();
    return farm.getCrops();
  }
}