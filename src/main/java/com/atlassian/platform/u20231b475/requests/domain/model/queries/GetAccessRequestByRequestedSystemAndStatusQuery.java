package com.atlassian.platform.u20231b475.requests.domain.model.queries;

import com.atlassian.platform.u20231b475.requests.domain.model.valueobjects.RequestStatus;
import com.atlassian.platform.u20231b475.requests.domain.model.valueobjects.SystemName;

/**
 * Get an access request by request system and status
 * 
 * @author Valentino Solis
 */
public record GetAccessRequestByRequestedSystemAndStatusQuery(SystemName requestedSystem, RequestStatus status) {
}
