package com.amankachhal.tapnlearn.tapnlearnbe.repository;

import com.amankachhal.tapnlearn.tapnlearnbe.model.entity.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourceRepository extends JpaRepository<ResourceEntity, Integer> {
    public List<ResourceEntity> getResourceEntityByCategoryIdAndIsDeletedFalse(int categoryId);
}
