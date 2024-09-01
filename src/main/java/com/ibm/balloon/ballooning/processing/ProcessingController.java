package com.ibm.balloon.ballooning.processing;

import com.ibm.balloon.ballooning.data.BalloonStrategyEnum;
import com.ibm.balloon.ballooning.processing.dto.CreateTestFileDto;
import com.ibm.balloon.ballooning.processing.dto.TestSocketDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/ballooning")
public class ProcessingController {
    private final ProcessingService service;

    @PostMapping("/probability")
    public String printProbability(@RequestParam BalloonStrategyEnum strategy) throws IOException {
        return service.printProbability(strategy);
    }

    @PostMapping("/create-file")
    public ResponseEntity<String> createTestFile(@RequestBody CreateTestFileDto dto) {
        Integer numberOfFiles = dto.getNumberOfFiles();
        if (numberOfFiles == null || numberOfFiles < 1) numberOfFiles = 1;

        try {
            log.info("[ProcessingController] Creating {} files with {} objects for {} database...", numberOfFiles, dto.getBalloonStrategyEnum(), dto.getFileSize());
            final String response = service.createTestFile(dto.getBalloonStrategyEnum(), dto.getFileSize(), numberOfFiles, dto.getIsJsonList());
            log.info("[ProcessingController] Test file status: {}", response);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error during test execution!", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/balloon-test")
    public ResponseEntity<String> balloonTest(@RequestBody TestSocketDto dto) {
        try {
            log.info("[ProcessingController] Opening connection to: {}", dto.getSocketPort());
            final String filename = String.format("%s---%s---%s---%s",
                    dto.getDatasetStrategy(),
                    dto.getRecordsToSend(),
                    dto.getProcessingStrategy(),
                    new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date())
            ).toLowerCase();
            final String response = service.connection(dto.getProcessingStrategy(), dto.getSocketPort(), dto.getServerPort(), filename);

            log.info("[ProcessingController] [{}] Processing...", response);
            service.processing(
                    dto.getDatasetStrategy(),
                    dto.getSocketPort(),
                    dto.getRecordsToSend()
            );

            return ResponseEntity.ok("Processing request on port " + dto.getSocketPort());
        } catch (Exception e) {
            log.error("Error during test execution!", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
