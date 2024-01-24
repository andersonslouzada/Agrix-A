package com.betrybe.agrix.services;

import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.models.repositories.FarmRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
   */
  @Autowired
  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  /**
   * Insert farm farm.
   *
   * @param farm the farm
   * @return the farm
   */
  public Farm insertFarm(Farm farm) {
    return farmRepository.save(farm);
  }

  /**
   * Update farm optional.
   *
   * @param id   the id
   * @param farm the farm
   * @return the optional
   */
  public Optional<Farm> updateFarm(Long id, Farm farm) {
    Optional<Farm> optionalFarm = farmRepository.findById(id);

    if (optionalFarm.isPresent()) {
      Farm farmFromDb = optionalFarm.get();
      farmFromDb.setName(farm.getName());
      farmFromDb.setSize(farm.getSize());

      Farm updatedFarm = farmRepository.save(farmFromDb);

      return Optional.of(updatedFarm);
    }
    return optionalFarm;
  }

  /**
   * Remove farm by id optional.
   *
   * @param id the id
   * @return the optional
   */
  public Optional<Farm> removeFarmById(Long id) {
    Optional<Farm> optionalFarm = farmRepository.findById(id);

    if (optionalFarm.isPresent()) {
      farmRepository.deleteById(id);
    }

    return optionalFarm;
  }

  /**
   * Get farm by id optional.
   *
   * @param id the id
   * @return the optional
   */
  public Optional<Farm> getFarmById(Long id) {
    return farmRepository.findById(id);
  }

  /**
   * Gets all farms.
   *
   * @return the all farms
   */
  public List<Farm> getAllFarms() {
    return farmRepository.findAll();
  }

}
