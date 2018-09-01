package com.protean.legislativetracker.legislativetrackerserverservicerest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "type")
public class Type {
    @Id
    @Column(name = "bill_type_id", nullable = false)
    private Integer id;
    @Column(name = "bill_type_name", nullable = false)
    private String billTypeName;
    @Column(name = "bill_type_abbr", nullable = false)
    private String billTypeAbbreviation;

    public Type() {
    }

    public Type(Integer id, String billTypeName, String billTypeAbbreviation) {
        this.id = id;
        this.billTypeName = billTypeName;
        this.billTypeAbbreviation = billTypeAbbreviation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillTypeName() {
        return billTypeName;
    }

    public void setBillTypeName(String billTypeName) {
        this.billTypeName = billTypeName;
    }

    public String getBillTypeAbbreviation() {
        return billTypeAbbreviation;
    }

    public void setBillTypeAbbreviation(String billTypeAbbreviation) {
        this.billTypeAbbreviation = billTypeAbbreviation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return Objects.equals(id, type.id) &&
                Objects.equals(billTypeName, type.billTypeName) &&
                Objects.equals(billTypeAbbreviation, type.billTypeAbbreviation);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, billTypeName, billTypeAbbreviation);
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", billTypeName='" + billTypeName + '\'' +
                ", billTypeAbbreviation='" + billTypeAbbreviation + '\'' +
                '}';
    }
}
