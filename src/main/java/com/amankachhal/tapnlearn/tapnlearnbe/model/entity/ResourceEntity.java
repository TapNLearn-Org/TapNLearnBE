package com.amankachhal.tapnlearn.tapnlearnbe.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name = "resource", schema = "tapnlearn", catalog = "")
public class ResourceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "resource_id")
    private int resourceId;

    @Basic
    @Column(name = "category_id")
    private int categoryId;

    @Basic
    @Column(name = "sub_category_id")
    private Integer subCategoryId;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "is_deleted")
    private boolean isDeleted;

    @OneToMany(mappedBy = "resourceId")
    private List<ResourcePictureEntity> pictureEntityList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceEntity that = (ResourceEntity) o;
        return resourceId == that.resourceId && categoryId == that.categoryId && isDeleted == that.isDeleted && Objects.equals(subCategoryId, that.subCategoryId) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resourceId, categoryId, subCategoryId, name, isDeleted);
    }
}
