package com.amankachhal.tapnlearn.tapnlearnbe.service;

import com.amankachhal.tapnlearn.tapnlearnbe.model.ResourceDetails;
import com.amankachhal.tapnlearn.tapnlearnbe.model.ResourceDetailsList;
import com.amankachhal.tapnlearn.tapnlearnbe.model.Uri;
import com.amankachhal.tapnlearn.tapnlearnbe.model.entity.CategoryEntity;
import com.amankachhal.tapnlearn.tapnlearnbe.model.entity.ResourceEntity;
import com.amankachhal.tapnlearn.tapnlearnbe.model.entity.SubCategoryEntity;
import com.amankachhal.tapnlearn.tapnlearnbe.repository.CategoryRepository;
import com.amankachhal.tapnlearn.tapnlearnbe.repository.ResourceRepository;
import com.amankachhal.tapnlearn.tapnlearnbe.repository.SubCategoryRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GetResourceService {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    SubCategoryRepository subCategoryRepository;
    @Autowired
    ResourceRepository resourceRepository;

    public List<CategoryEntity> getAllCategories(){
        return categoryRepository.findAll();
    }
    public List<SubCategoryEntity> getSubCategoryByCategory(int categoryId){
        return subCategoryRepository.getSubCategoryEntityByCategoryId(categoryId);
    }
    public List<ResourceEntity> getResourceByCategory(int categoryId){
        return resourceRepository.getResourceEntityByCategoryIdAndIsDeletedFalse(categoryId);
    }

    public ResourceDetailsList getResourceList(int categoryId) {
        List<ResourceEntity> resourceEntityList = getResourceByCategory(categoryId);
        return mapResourceEntity2ResourceDetails(resourceEntityList);
    }
    private ResourceDetailsList mapResourceEntity2ResourceDetails(List<ResourceEntity> resourceEntityList){
        ResourceDetailsList response = new ResourceDetailsList();
        List<ResourceDetails> resourceDetailsList = new ArrayList<ResourceDetails>();
        for(ResourceEntity resourceEntity : resourceEntityList){
            ResourceDetails resourceDetails = new ResourceDetails();
            resourceDetails.setName(resourceEntity.getName());
            resourceDetails.setImagePath(new Uri(resourceEntity.getPictureEntityList().get(0).getPicturePath()));
            resourceDetailsList.add(resourceDetails);
        }
        response.setResourceDetailsList(resourceDetailsList);
        return response;
    }
}
