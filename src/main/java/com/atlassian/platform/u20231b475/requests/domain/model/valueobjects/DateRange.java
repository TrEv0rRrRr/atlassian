package com.atlassian.platform.u20231b475.requests.domain.model.valueobjects;

import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

/**
 * Date Range VO
 * 
 * @author Valentino Solis
 */
@Embeddable
public record DateRange(@NotNull LocalDateTime startDate,
    @NotNull LocalDateTime endDate) {

  public DateRange {
    if (startDate.isAfter(endDate))
      throw new IllegalArgumentException("startDate must be before endDate");
  }
}
