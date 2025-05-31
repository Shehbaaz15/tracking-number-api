package com.tracking.tracking_number_api.model;


import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
public class TrackingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, length = 16)
    private String trackingNumber;

    private OffsetDateTime createdAt;

    public TrackingRecord() {}

    public TrackingRecord(UUID id, String trackingNumber, OffsetDateTime createdAt) {
        this.id = id;
        this.trackingNumber = trackingNumber;
        this.createdAt = createdAt;
    }

    public static TrackingRecord build(String trackingNumber, OffsetDateTime createdAt) {
        return new TrackingRecord(null, trackingNumber, createdAt);
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }
}
