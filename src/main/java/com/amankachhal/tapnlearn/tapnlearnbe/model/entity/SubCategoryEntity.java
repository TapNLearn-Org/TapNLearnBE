package com.amankachhal.tapnlearn.tapnlearnbe.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "sub_category", schema = "tapnlearn")
public class SubCategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "sub_category_id")
    private int subCategoryId;
    @Basic
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
        SubCategoryEntity that = (SubCategoryEntity) o;
        return subCategoryId == that.subCategoryId && categoryId == that.categoryId && isDeleted == that.isDeleted && Objects.equals(name, that.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(subCategoryId, categoryId, name, isDeleted);
    }
}
