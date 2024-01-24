package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.FarmDto;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.services.FarmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Farm controller.
 */
@RestController
@RequestMapping(value = "/farms")
public class FarmController {

  private final FarmService farmService;

  /**
   * Instantiates a new Farm controller.
   *
   * @param farmService the farm service
   */
  @Autowired
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  /**
   * Create farm response entity.
   *
   * @param farmDto the farm dto
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<FarmDto> createFarm(@RequestBody FarmDto farmDto) {
    Farm newFarm = farmService.insertFarm(farmDto.toFarm());
    return ResponseEntity.status(HttpStatus.CREATED).body(FarmDto.toDto(newFarm));
  }

  /**
   * Gets all farms.
   *
   * @return the all farms
   */
  @GetMapping
  public ResponseEntity<List<FarmDto>> getAllFarms() {
    List<Farm> farms = farmService.getAllFarms();
    List<FarmDto> farmsDto = farms.stream().map(FarmDto::toDto).toList();
    return ResponseEntity.ok(farmsDto);
  }
}
