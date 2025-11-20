package com.atlassian.platform.u20231b475.requests.domain.model.valueobjects;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Justification VO
 * 
 * @author Valentino Solis
 */
public record Justification(
    @NotBlank(message = "The justification is required.") @Size(min = 25, max = 500, message = "The justification must be between 25 and 500 characters.") String justification) {
}
