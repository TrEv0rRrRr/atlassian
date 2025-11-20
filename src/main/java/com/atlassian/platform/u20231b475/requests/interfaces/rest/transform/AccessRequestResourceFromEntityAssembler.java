package com.atlassian.platform.u20231b475.requests.interfaces.rest.transform;

import com.atlassian.platform.u20231b475.requests.domain.model.aggregates.AccessRequest;
import com.atlassian.platform.u20231b475.requests.interfaces.rest.resources.AccessRequestResource;

/**
 * Assembler to convert an Access Request entity to an AccessRequestResource.
 */
public class AccessRequestResourceFromEntityAssembler {
  /**
   * Converts an Access Request entity to tan AccessRequestResource
   * 
   * @param entity The {@link AccessRequest} entity to convert
   * @return The {@link AccessRequestResource} resource
   */
  public static AccessRequestResource toResourceFromEntity(AccessRequest entity) {
    return new AccessRequestResource(
        entity.getId(),
        entity.getEmployeeId(),
        entity.getRequestedSystem(),
        entity.getAccessLevel(),
        entity.getJustification(),
        entity.getAccessPeriod(),
        entity.getRequestStatus(),
        entity.getRequestedAt());
  }
}
