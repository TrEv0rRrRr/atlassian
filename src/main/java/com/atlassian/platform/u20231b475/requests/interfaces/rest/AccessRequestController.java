package com.atlassian.platform.u20231b475.requests.interfaces.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atlassian.platform.u20231b475.requests.domain.services.AccessRequestCommandService;
import com.atlassian.platform.u20231b475.requests.interfaces.rest.resources.AccessRequestResource;
import com.atlassian.platform.u20231b475.requests.interfaces.rest.resources.CreateAccessRequestResource;
import com.atlassian.platform.u20231b475.requests.interfaces.rest.transform.AccessRequestResourceFromEntityAssembler;
import com.atlassian.platform.u20231b475.requests.interfaces.rest.transform.CreateAccessRequestCommandFromResourceAssembler;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * Access Request Controller
 */
@RestController
@RequestMapping(value = "/api/v1/employees", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Access Requests", description = "Available Access Requests Endpoints")
public class AccessRequestController {
  private final AccessRequestCommandService service;

  /**
   * Constructor
   * 
   * @param service The {@link AccessRequestCommandService} instance
   */
  public AccessRequestController(AccessRequestCommandService service) {
    this.service = service;
  }

  /**
   * Create a new Access Request
   * 
   * @param employeeId The employee Id
   * @param resource   The {@link CreateAccessRequestResource} instance
   * @return A {@link AccessRequestResource} resource for the created Access
   *         Request, or a bad request response if the access request could not be
   *         created.
   */
  @PostMapping("/{employeeId}/access-requests")
  @Operation(summary = "Creates a new Access Request")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Access Request Created"),
      @ApiResponse(responseCode = "400", description = "Bad Request")
  })
  public ResponseEntity<AccessRequestResource> createAccessRequest(@PathVariable Long employeeId,
      @Valid @RequestBody CreateAccessRequestResource resource) {
    var createAccessRequestCommand = CreateAccessRequestCommandFromResourceAssembler.toCommandFromResource(employeeId,
        resource);

    var accessRequest = service.handle(createAccessRequestCommand);

    if (accessRequest.isEmpty())
      return ResponseEntity.badRequest().build();

    var createdAccessRequest = accessRequest.get();

    var accessRequestResource = AccessRequestResourceFromEntityAssembler.toResourceFromEntity(createdAccessRequest);

    return new ResponseEntity<>(accessRequestResource, HttpStatus.CREATED);
  }
}
