package com.atlassian.platform.u20231b475.requests.domain.services;

import java.util.Optional;

import com.atlassian.platform.u20231b475.requests.domain.model.aggregates.AccessRequest;
import com.atlassian.platform.u20231b475.requests.domain.model.queries.GetAccessRequestByRequestedSystemAndStatusQuery;

/**
 * Access Request Query Service
 * 
 * @author Valentino Solis
 */
public interface AccessRequestQueryService {
  /**
   * Handle get Access Request by requested name and request status
   * 
   * @param query The {@link GetAccessRequestByRequestedSystemAndStatusQuery}
   *              query
   * @return A {@link AccessRequest} instance if the query is valid, otherwise
   *         empty
   */
  Optional<AccessRequest> handle(GetAccessRequestByRequestedSystemAndStatusQuery query);
}
