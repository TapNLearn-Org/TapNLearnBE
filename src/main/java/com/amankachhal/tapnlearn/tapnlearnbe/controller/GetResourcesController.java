package com.amankachhal.tapnlearn.tapnlearnbe.controller;

import com.amankachhal.tapnlearn.tapnlearnbe.model.Category;
import com.amankachhal.tapnlearn.tapnlearnbe.model.ResourceCategoryResponse;
import com.amankachhal.tapnlearn.tapnlearnbe.model.ResourceDetails;
import com.amankachhal.tapnlearn.tapnlearnbe.model.SubCategory;
import com.amankachhal.tapnlearn.tapnlearnbe.service.GetResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class GetResourcesController {

    @Autowired
    GetResourceService resourceService;

    @GetMapping(path="resources", produces = "application/json")
    public ResourceCategoryResponse getResources(@RequestParam("categoryId") Integer categoryId,
                                                 @RequestParam(value = "subCategoryId", required = false) Integer subCategoryId) {
        ResourceCategoryResponse resourceCategoryResponse = new ResourceCategoryResponse();
        if (subCategoryId == null || subCategoryId == 0){
            List<SubCategory> subCategoryList = resourceService.getSubCategoryByCategory(categoryId);
            if(subCategoryList.size() > 0){
                resourceCategoryResponse.setSubCategoryList(subCategoryList);
                return resourceCategoryResponse;
            }
        }
        List<ResourceDetails> resourceDetailsList = resourceService.getResourceList(categoryId, subCategoryId);
        resourceCategoryResponse.setResourceDetailsList(resourceDetailsList);
        return resourceCategoryResponse;
    }
    @GetMapping(path="category", produces = "application/json")
    public List<Category> getCategory() {
        List<Category> categoryList = resourceService.getAllCategories();
        return categoryList;
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