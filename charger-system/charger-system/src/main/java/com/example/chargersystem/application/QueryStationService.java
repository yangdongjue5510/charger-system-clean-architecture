package com.example.chargersystem.application;

import com.example.chargersystem.application.port.in.QueryStationUseCase;
import com.example.chargersystem.application.port.out.QueryStationPort;
import com.example.chargersystem.application.response.StationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryStationService implements QueryStationUseCase {

    private final QueryStationPort queryStationPort;

    @Override
    public StationResponse findById(Long id) {
        return queryStationPort.findById(id);
    }
}
