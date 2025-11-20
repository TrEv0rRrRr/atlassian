package com.atlassian.platform.u20231b475.requests.interfaces.rest.resources;

import java.time.LocalDateTime;

import com.atlassian.platform.u20231b475.requests.domain.model.valueobjects.AccessLevel;
import com.atlassian.platform.u20231b475.requests.domain.model.valueobjects.DateRange;
import com.atlassian.platform.u20231b475.requests.domain.model.valueobjects.EmployeeId;
import com.atlassian.platform.u20231b475.requests.domain.model.valueobjects.Justification;
import com.atlassian.platform.u20231b475.requests.domain.model.valueobjects.RequestStatus;
import com.atlassian.platform.u20231b475.requests.domain.model.valueobjects.SystemName;

/**
 * Resource for an access request.
 */
public record AccessRequestResource(Long id, EmployeeId employeeId, SystemName requestedSystem, AccessLevel accessLevel,
        Justification justification, DateRange accessPeriod, RequestStatus status, LocalDateTime requestedAt) {
}
