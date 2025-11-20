package com.atlassian.platform.u20231b475.requests.interfaces.rest.resources;

import java.time.LocalDateTime;

import com.atlassian.platform.u20231b475.requests.domain.model.valueobjects.AccessLevel;
import com.atlassian.platform.u20231b475.requests.domain.model.valueobjects.SystemName;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Resource for creating an access request
 */
public record CreateAccessRequestResource(AccessLevel accessLevel,
    @NotNull(message = "The start date is required") LocalDateTime startDate,
    @NotNull(message = "The end date is required") LocalDateTime endDate,
    @NotBlank(message = "The justification is required.") @Size(min = 25, max = 500, message = "The justification must be between 25 and 500 characters.") String justification,
    SystemName requestName) {

  public CreateAccessRequestResource {
    if (startDate.isAfter(endDate))
      throw new IllegalArgumentException("startDate must be before endDate");
  }
}
