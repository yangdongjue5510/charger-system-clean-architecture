package com.example.chargersystem.adapter.in.web;

import com.example.chargersystem.adapter.in.web.dto.AddStationDto;
import com.example.chargersystem.application.command.UpdateStationCommand;
import com.example.chargersystem.application.port.in.QueryStationUseCase;
import com.example.chargersystem.application.port.in.UpdateStationUseCase;
import com.example.chargersystem.application.response.StationResponse;
import com.example.chargersystem.adapter.in.web.dto.UpdateStationDto;
import com.example.chargersystem.application.command.AddStationCommand;
import com.example.chargersystem.application.port.in.AddStationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/charging-stations")
public class ChargingStationController {

    private final UpdateStationUseCase updateStationUseCase;

    private final AddStationUseCase addStationUseCase;

    private final QueryStationUseCase queryStationUseCase;

    @GetMapping("/{id}")
    public StationResponse findById(@PathVariable Long id) {
        return queryStationUseCase.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> addStation(@RequestBody AddStationDto addStationDto) {
        AddStationCommand addStationCommand = new AddStationCommand(
                addStationDto.getName(),
                addStationDto.getAddress(),
                addStationDto.getFeeRate()
        );
        Long id = addStationUseCase.addStation(addStationCommand);
        return ResponseEntity.created(URI.create("/charging-stations/" + id)).build();
    }

    @PutMapping
    public ResponseEntity<?> updateStation(@RequestBody UpdateStationDto updateStationDto) {
        UpdateStationCommand command = new UpdateStationCommand(
                updateStationDto.getId(),
                updateStationDto.getName(),
                updateStationDto.getAddress(),
                updateStationDto.getFeeRate()
        );
        updateStationUseCase.update(command);
        return ResponseEntity.noContent().build();
    }
}
