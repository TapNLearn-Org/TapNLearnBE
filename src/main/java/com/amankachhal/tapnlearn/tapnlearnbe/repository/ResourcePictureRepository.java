package com.amankachhal.tapnlearn.tapnlearnbe.repository;

import com.amankachhal.tapnlearn.tapnlearnbe.model.entity.ResourcePictureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourcePictureRepository extends JpaRepository<ResourcePictureEntity, Integer> {
    public List<ResourcePictureEntity> getResourcePictureEntitiesByResourceId(int resourceId);
}
