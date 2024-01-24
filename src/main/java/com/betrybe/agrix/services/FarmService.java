package com.betrybe.agrix.services;

import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.models.repositories.FarmRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmService {

  private final FarmRepository farmRepository;

  @Autowired
  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  public Farm insertFarm(Farm farm) {
    return farmRepository.save(farm);
  }

  public Optional<Farm> updateFarm(Long id, Farm farm) {
    Optional<Farm> optionalFarm = farmRepository.findById(id);

    if(optionalFarm.isPresent()) {
      Farm farmFromDB = optionalFarm.get();
      farmFromDB.setName(farm.getName());
      farmFromDB.setSize(farm.getSize());

      Farm updatedFarm = farmRepository.save(farmFromDB);

      return Optional.of(updatedFarm);
    }
    return optionalFarm;
  }

  public Optional<Farm> removeFarmById(Long id) {
    Optional<Farm> optionalFarm = farmRepository.findById(id);

    if(optionalFarm.isPresent()) {
      farmRepository.deleteById(id);
    }

    return optionalFarm;
  }

  public Optional<Farm> getFarmById(Long id){
    return farmRepository.findById(id);
  }

  public List<Farm> getAllFarms () {
    return farmRepository.findAll();
  }

}
