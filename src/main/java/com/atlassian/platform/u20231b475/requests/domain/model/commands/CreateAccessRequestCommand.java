package com.atlassian.platform.u20231b475.requests.domain.model.commands;

import java.time.LocalDateTime;

import com.atlassian.platform.u20231b475.requests.domain.model.valueobjects.AccessLevel;
import com.atlassian.platform.u20231b475.requests.domain.model.valueobjects.SystemName;

/**
 * Command for Access Request creation
 *
 * @author Valentino Solis
 */
public record CreateAccessRequestCommand(Long employeeId, SystemName requestedSystem, AccessLevel accessLevel,
    String justification, LocalDateTime startDate,
    LocalDateTime endDate) {
}
