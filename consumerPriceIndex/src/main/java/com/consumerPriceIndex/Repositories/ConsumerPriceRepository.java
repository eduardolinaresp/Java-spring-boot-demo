package com.consumerPriceIndex.Repositories;
import com.consumerPriceIndex.Models.StagingArea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumerPriceRepository extends JpaRepository<StagingArea, Long> {
}
