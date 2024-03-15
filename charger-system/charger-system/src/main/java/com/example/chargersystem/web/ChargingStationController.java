package com.example.chargersystem.web;

import com.example.chargersystem.service.ChargingStationService;
import com.example.chargersystem.service.dto.AddStationDto;
import com.example.chargersystem.service.dto.StationResponse;
import com.example.chargersystem.service.dto.UpdateStationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/charging-stations")
public class ChargingStationController {

    private final ChargingStationService chargingStationService;

    @GetMapping("/{id}")
    public StationResponse findById(@PathVariable Long id) {
        return chargingStationService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> addStation(@RequestBody AddStationDto addStationDto) {
        Long id = chargingStationService.addStation(addStationDto);
        return ResponseEntity.created(URI.create("/charging-stations/" + id)).build();
    }

    @PutMapping
    public ResponseEntity<?> updateStation(@RequestBody UpdateStationDto updateStationDto) {
        chargingStationService.updateStation(updateStationDto);
        return ResponseEntity.noContent().build();
    }
}
