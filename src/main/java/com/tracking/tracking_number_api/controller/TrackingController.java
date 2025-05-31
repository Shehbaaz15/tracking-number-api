package com.tracking.tracking_number_api.controller;


import com.tracking.tracking_number_api.model.TrackingRecord;
import com.tracking.tracking_number_api.service.TrackingService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/next-tracking-number")
public class TrackingController {

    private final TrackingService service;

    public TrackingController(TrackingService service) {
        this.service = service;
    }

    @GetMapping
    public Map<String, Object> getTrackingNumber(
            @RequestParam String origin_country_id,
            @RequestParam String destination_country_id,
            @RequestParam double weight,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime created_at,
            @RequestParam UUID customer_id,
            @RequestParam String customer_name,
            @RequestParam String customer_slug
    ) {
        TrackingRecord record = service.generateTrackingNumber();

        return Map.of(
                "tracking_number", record.getTrackingNumber(),
                "created_at", record.getCreatedAt().toString(),
                "origin_country_id", origin_country_id,
                "destination_country_id", destination_country_id,
                "customer", Map.of("id", customer_id, "name", customer_name, "slug", customer_slug),
                "weight", weight
        );
    }
}


