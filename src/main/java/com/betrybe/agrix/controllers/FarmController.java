package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.FarmDTO;
import com.betrybe.agrix.controllers.dto.ResponseDTO;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.services.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/farms")
public class FarmController {

  private final FarmService farmService;
  @Autowired
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  @PostMapping()
  public ResponseEntity<ResponseDTO<Farm>> createFarm(@RequestBody FarmDTO farmDTO) {
    Farm newFarm = farmService.insertFarm(farmDTO.toFarm());
    ResponseDTO<Farm> responseDTO = new ResponseDTO<>("Fazenda criada com sucesso", newFarm);
    return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
  }

}
