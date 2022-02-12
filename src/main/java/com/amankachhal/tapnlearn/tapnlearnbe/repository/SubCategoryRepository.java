package com.amankachhal.tapnlearn.tapnlearnbe.repository;

import com.amankachhal.tapnlearn.tapnlearnbe.model.entity.SubCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategoryEntity, Integer>{
    public List<SubCategoryEntity> getSubCategoryEntityByCategoryId(int categoryId);
}
