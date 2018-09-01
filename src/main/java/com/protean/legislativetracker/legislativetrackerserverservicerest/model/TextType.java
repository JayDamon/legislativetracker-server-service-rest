package com.protean.legislativetracker.legislativetrackerserverservicerest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "text_type")
public class TextType {
    @Id
    @Column(name = "text_type_id")
    private Integer id;
    @Column(name = "bill_text_name")
    private String name;
    @Column(name = "bill_text_sort")
    private Integer textSort;
    @Column(name = "bill_text_supplement")
    private Integer supplement;

    public TextType() {
    }

    public TextType(Integer id, String name, Integer textSort, Integer supplement) {
        this.id = id;
        this.name = name;
        this.textSort = textSort;
        this.supplement = supplement;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTextSort() {
        return textSort;
    }

    public void setTextSort(Integer textSort) {
        this.textSort = textSort;
    }

    public Integer getSupplement() {
        return supplement;
    }

    public void setSupplement(Integer supplement) {
        this.supplement = supplement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextType textType = (TextType) o;
        return Objects.equals(id, textType.id) &&
                Objects.equals(name, textType.name) &&
                Objects.equals(textSort, textType.textSort) &&
                Objects.equals(supplement, textType.supplement);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, textSort, supplement);
    }

    @Override
    public String toString() {
        return "TextType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", textSort=" + textSort +
                ", supplement=" + supplement +
                '}';
    }
}
