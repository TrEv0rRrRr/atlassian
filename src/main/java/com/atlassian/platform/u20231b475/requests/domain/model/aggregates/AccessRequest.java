package com.atlassian.platform.u20231b475.requests.domain.model.aggregates;

import java.time.LocalDateTime;

import com.atlassian.platform.u20231b475.requests.domain.model.commands.CreateAccessRequestCommand;
import com.atlassian.platform.u20231b475.requests.domain.model.valueobjects.AccessLevel;
import com.atlassian.platform.u20231b475.requests.domain.model.valueobjects.DateRange;
import com.atlassian.platform.u20231b475.requests.domain.model.valueobjects.EmployeeId;
import com.atlassian.platform.u20231b475.requests.domain.model.valueobjects.Justification;
import com.atlassian.platform.u20231b475.requests.domain.model.valueobjects.RequestStatus;
import com.atlassian.platform.u20231b475.requests.domain.model.valueobjects.SystemName;

import jakarta.persistence.*;
import lombok.Getter;

/**
 * Access Request Aggregate root
 * 
 * @author Valentino Solis
 */
@Entity
@Getter
public class AccessRequest {
  private LocalDateTime requestedAt;

  @Embedded
  private EmployeeId employeeId;

  @Embedded
  private Justification justification;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "startDate", column = @Column(name = "start_date")),
      @AttributeOverride(name = "endDate", column = @Column(name = "end_date"))
  })
  private DateRange accessPeriod;

  @Enumerated(EnumType.STRING)
  private SystemName requestedSystem;

  @Enumerated(EnumType.STRING)
  private AccessLevel accessLevel;

  @Enumerated(EnumType.STRING)
  private RequestStatus requestStatus;

  public AccessRequest() {
  }

  public AccessRequest(CreateAccessRequestCommand command) {
    this.requestedAt = LocalDateTime.now();
    this.employeeId = new EmployeeId(command.employeeId());
    this.justification = new Justification(command.justification());
    this.accessPeriod = new DateRange(command.startDate(), command.endDate());
    this.requestedSystem = command.requestedSystem();
    this.accessLevel = command.accessLevel();
    this.requestStatus = RequestStatus.PENDING;

    validate();
  }

  private void validate() {
    if (this.requestedSystem == SystemName.BITBUCKET && accessLevel == AccessLevel.ADMIN)
      throw new IllegalArgumentException(
          "Access level 'ADMIN' is not allowed when the requested system is 'BITBUCKET'.");
  }
}
