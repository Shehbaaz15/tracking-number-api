package com.tracking.tracking_number_api.service;


import com.tracking.tracking_number_api.model.TrackingRecord;
import com.tracking.tracking_number_api.repository.TrackingRepository;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.OffsetDateTime;

@Service
public class TrackingService {

    private final TrackingRepository repository;
    private final SecureRandom random = new SecureRandom();
    private static final String CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public TrackingService(TrackingRepository repository) {
        this.repository = repository;
    }

    public TrackingRecord generateTrackingNumber() {
        String trackingNumber;

        // Retry until unique
        do {
            trackingNumber = generateRandomCode(12 + random.nextInt(5)); // Length between 12-16
        } while (repository.findByTrackingNumber(trackingNumber).isPresent());

        TrackingRecord record = TrackingRecord.build(trackingNumber, OffsetDateTime.now());

        return repository.save(record);
    }

    private String generateRandomCode(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(CHARSET.charAt(random.nextInt(CHARSET.length())));
        }
        return sb.toString();
    }
}
