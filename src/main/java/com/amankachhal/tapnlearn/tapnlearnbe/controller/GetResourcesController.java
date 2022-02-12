package com.amankachhal.tapnlearn.tapnlearnbe.controller;

import com.amankachhal.tapnlearn.tapnlearnbe.model.ResourceDetails;
import com.amankachhal.tapnlearn.tapnlearnbe.model.ResourceDetailsList;
import com.amankachhal.tapnlearn.tapnlearnbe.model.Uri;
import com.amankachhal.tapnlearn.tapnlearnbe.service.GetResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/resources")
public class GetResourcesController {

    @Autowired
    GetResourceService resourceService;

    @GetMapping(path="", produces = "application/json")
    public ResourceDetailsList getResources(@RequestParam("resourceFor") Integer resourceFor) throws IOException {
        ResourceDetailsList resourceDetailsList = resourceService.getResourceList(resourceFor);
        return resourceDetailsList;
    }

    private ResourceDetailsList populate(){
        ResourceDetailsList resource = new ResourceDetailsList();

        List<ResourceDetails> resourceDetailsList = new ArrayList<ResourceDetails>();
        ResourceDetails resourceDetails = new ResourceDetails();
        resourceDetails.setName("Boy");
        resourceDetails.setImagePath(new Uri("https://tapnlearnresources.s3.ap-southeast-1.amazonaws.com/pictures/people/Boy.jpg"));
        resourceDetailsList.add(resourceDetails);
        resource.setResourceDetailsList(resourceDetailsList);
        return resource;
    }

/*
    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee)
    {
        Integer id = employeeDao.getAllEmployees().getEmployeeList().size() + 1;
        employee.setId(id);

        employeeDao.addEmployee(employee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
*/

}