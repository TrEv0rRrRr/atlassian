package com.atlassian.platform.u20231b475.requests.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * Employee Id VO
 * 
 * @author Valentino Solis
 */
@Embeddable
public record EmployeeId(@NotNull(message = "Employee Id is required.") @Min(1) Long employeeId) {

  public EmployeeId {
    if (employeeId <= 0) {
      throw new IllegalArgumentException("Employee Id must be greater than 0.");
    }
  }
}
