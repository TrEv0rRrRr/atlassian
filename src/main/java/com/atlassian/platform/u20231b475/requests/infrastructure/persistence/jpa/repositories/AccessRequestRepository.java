package com.atlassian.platform.u20231b475.requests.infrastructure.persistence.jpa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atlassian.platform.u20231b475.requests.domain.model.aggregates.AccessRequest;
import com.atlassian.platform.u20231b475.requests.domain.model.valueobjects.RequestStatus;
import com.atlassian.platform.u20231b475.requests.domain.model.valueobjects.SystemName;

/**
 * Access Request repository
 * 
 * @author Valentino Solis
 */
@Repository
public interface AccessRequestRepository extends JpaRepository<AccessRequest, Long> {
  /**
   * Find an access request by requested system name and status
   * 
   * @param requestedSystem The requested system
   * @param status          The status of the access request
   * @return A {@link AccessRequest} instance if the provided properties are
   *         valid, otherwise empty.
   * 
   * @author Valentino Solis
   */
  Optional<AccessRequest> findByRequestedSystemAndStatus(SystemName requestedSystem, RequestStatus status);

  /**
   * Check if an access request exists by the given properties
   * 
   * @param requestedSystem The requested system
   * @param status          The status of the access request
   * @return True if the access request exists, otherwise false
   */
  boolean existsByRequestedSystemAndStatus(SystemName requestedSystem, RequestStatus status);
}
