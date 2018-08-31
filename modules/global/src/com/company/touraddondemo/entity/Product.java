package com.company.touraddondemo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|name")
@Table(name = "TOURADDONDEMO_PRODUCT")
@Entity(name = "touraddondemo$Product")
public class Product extends StandardEntity {
    private static final long serialVersionUID = 5743477494096522148L;

    @Column(name = "NAME")
    protected String name;

    @Column(name = "PRICE")
    protected BigDecimal price;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }


}