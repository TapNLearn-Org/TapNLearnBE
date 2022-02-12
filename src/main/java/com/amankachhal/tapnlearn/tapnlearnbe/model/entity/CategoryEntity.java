package com.amankachhal.tapnlearn.tapnlearnbe.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "category", schema = "tapnlearn", catalog = "")
public class CategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "category_id")
    private int categoryId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return categoryId == that.categoryId && isDeleted == that.isDeleted && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, name, isDeleted);
    }
}
