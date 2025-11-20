package com.atlassian.platform.u20231b475.requests.domain.services;

import java.util.Optional;

import com.atlassian.platform.u20231b475.requests.domain.model.aggregates.AccessRequest;
import com.atlassian.platform.u20231b475.requests.domain.model.commands.CreateAccessRequestCommand;

/**
 * Access Request Command Service
 * 
 * @author Valentino Solis
 */
public interface AccessRequestCommandService {
  /**
   * Handle create an Access Request
   * 
   * @param command The {@link CreateAccessRequestCommand} command
   * @return A {@link AccessRequest} instance if the command is valid, otherwise
   *         false
   * @throws IllegalArgumentException if the access request already exists
   */
  Optional<AccessRequest> handle(CreateAccessRequestCommand command);
}
