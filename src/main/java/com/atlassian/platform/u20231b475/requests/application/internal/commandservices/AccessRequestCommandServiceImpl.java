package com.atlassian.platform.u20231b475.requests.application.internal.commandservices;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.atlassian.platform.u20231b475.requests.domain.model.aggregates.AccessRequest;
import com.atlassian.platform.u20231b475.requests.domain.model.commands.CreateAccessRequestCommand;
import com.atlassian.platform.u20231b475.requests.domain.model.valueobjects.RequestStatus;
import com.atlassian.platform.u20231b475.requests.domain.services.AccessRequestCommandService;
import com.atlassian.platform.u20231b475.requests.infrastructure.persistence.jpa.repositories.AccessRequestRepository;

/**
 * Access Request command service implementation
 * 
 * @author Valentino Solis
 */
@Service
public class AccessRequestCommandServiceImpl implements AccessRequestCommandService {
  private final AccessRequestRepository repo;

  public AccessRequestCommandServiceImpl(AccessRequestRepository repo) {
    this.repo = repo;
  }

  // inherited javadoc
  @Override
  public Optional<AccessRequest> handle(CreateAccessRequestCommand command) {
    if (repo.existsByRequestedSystemAndStatus(command.requestedSystem(), RequestStatus.PENDING))
      throw new IllegalArgumentException(
          "An access request for this system is already pending.");

    var accessRequest = new AccessRequest(command);
    repo.save(accessRequest);
    return Optional.of(accessRequest);
  }
}
