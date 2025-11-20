package com.atlassian.platform.u20231b475.requests.interfaces.rest.transform;

import com.atlassian.platform.u20231b475.requests.domain.model.commands.CreateAccessRequestCommand;
import com.atlassian.platform.u20231b475.requests.interfaces.rest.resources.CreateAccessRequestResource;

/**
 * Assembler to convert a CreateAccessRequestResource to a
 * CreateAccessRequestCommand.
 */
public class CreateAccessRequestCommandFromResourceAssembler {
  /**
   * Converts a CreateAccessRequestResource to a CreateAccessRequestCommand
   * 
   * @param employeeId The employee Id
   * @param resource   The {@link CreateAccessRequestResource} resource to convert
   * @return The {@link CreateAccessRequestCommand} command
   */
  public static CreateAccessRequestCommand toCommandFromResource(Long employeeId,
      CreateAccessRequestResource resource) {
    return new CreateAccessRequestCommand(
        employeeId,
        resource.requestName(),
        resource.accessLevel(),
        resource.justification(),
        resource.startDate(),
        resource.endDate());
  }
}
