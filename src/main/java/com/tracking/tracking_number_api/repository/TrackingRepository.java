package com.tracking.tracking_number_api.repository;

import com.tracking.tracking_number_api.model.TrackingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrackingRepository extends JpaRepository<TrackingRecord, String> {
    Optional<TrackingRecord> findByTrackingNumber(String trackingNumber);
}
