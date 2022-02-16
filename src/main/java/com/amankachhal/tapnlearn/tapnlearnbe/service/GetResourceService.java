package com.amankachhal.tapnlearn.tapnlearnbe.service;

import com.amankachhal.tapnlearn.tapnlearnbe.model.Category;
import com.amankachhal.tapnlearn.tapnlearnbe.model.ResourceDetails;
import com.amankachhal.tapnlearn.tapnlearnbe.model.Uri;
import com.amankachhal.tapnlearn.tapnlearnbe.model.entity.CategoryEntity;
import com.amankachhal.tapnlearn.tapnlearnbe.model.entity.ResourceEntity;
import com.amankachhal.tapnlearn.tapnlearnbe.model.entity.SubCategoryEntity;
import com.amankachhal.tapnlearn.tapnlearnbe.repository.CategoryRepository;
import com.amankachhal.tapnlearn.tapnlearnbe.repository.ResourceRepository;
import com.amankachhal.tapnlearn.tapnlearnbe.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetResourceService {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    SubCategoryRepository subCategoryRepository;
    @Autowired
    ResourceRepository resourceRepository;
    @Value("${aws.storage.s3.picture.path}")
    String awsS3PicturePath;

    public List<Category> getAllCategories(){
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
        return mapCategoryEntity2Category(categoryEntityList);
    }
    public List<SubCategoryEntity> getSubCategoryByCategory(int categoryId){
        return subCategoryRepository.getSubCategoryEntityByCategoryId(categoryId);
    }
    public List<ResourceEntity> getResourceByCategory(int categoryId){
        return resourceRepository.getResourceEntityByCategoryIdAndIsDeletedFalse(categoryId);
    }

    public List<ResourceDetails> getResourceList(int categoryId) {
        List<ResourceEntity> resourceEntityList = getResourceByCategory(categoryId);
        return mapResourceEntity2ResourceDetails(resourceEntityList);
    }
    private List<ResourceDetails> mapResourceEntity2ResourceDetails(List<ResourceEntity> resourceEntityList){
        List<ResourceDetails> resourceDetailsList = new ArrayList<ResourceDetails>();
        for(ResourceEntity resourceEntity : resourceEntityList){
            ResourceDetails resourceDetails = new ResourceDetails();
            resourceDetails.setName(resourceEntity.getName());
            resourceDetails.setImagePath(new Uri(awsS3PicturePath+resourceEntity.getPictureEntityList().get(0).getPicturePath()));
            resourceDetailsList.add(resourceDetails);
        }
        return resourceDetailsList;
    }
    private List<Category> mapCategoryEntity2Category(List<CategoryEntity> categoryEntityList){
        List<Category> categoryList = new ArrayList<Category>();
        for(CategoryEntity categoryEntity : categoryEntityList){
            Category category = new Category();
            category.setId(categoryEntity.getCategoryId());
            category.setName(categoryEntity.getName());
            categoryList.add(category);
//            break;
        }
        return categoryList;
    }
}
