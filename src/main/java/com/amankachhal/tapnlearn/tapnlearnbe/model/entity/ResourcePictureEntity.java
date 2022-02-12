package com.amankachhal.tapnlearn.tapnlearnbe.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "resource_picture", schema = "tapnlearn", catalog = "")
public class ResourcePictureEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "resource_picture_id")
    private int resourcePictureId;
    @Basic
    @Column(name = "resource_id")
    private int resourceId;
    @Basic
    @Column(name = "picture_path")
    private String picturePath;
    @Basic
    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourcePictureEntity that = (ResourcePictureEntity) o;
        return resourcePictureId == that.resourcePictureId && resourceId == that.resourceId && isDeleted == that.isDeleted && Objects.equals(picturePath, that.picturePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resourcePictureId, resourceId, picturePath, isDeleted);
    }
}
