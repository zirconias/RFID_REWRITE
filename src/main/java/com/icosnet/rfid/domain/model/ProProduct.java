package com.icosnet.rfid.domain.model;

import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xirconias on 03/05/15.
 */
@Entity
@Table(name = "PROPRODUCT")
public class ProProduct extends AbstractEntity  {


    private String name;
    private String description;


    private BigDecimal price;


    private Map<String, String> attributes = new HashMap<String, String>();

    public ProProduct(String name, BigDecimal price) {
        this(name, price, null);
    }

    public ProProduct(String name, BigDecimal price, String description) {
        Assert.hasText(name, "Name must not be null or empty!");
        Assert.isTrue(BigDecimal.ZERO.compareTo(price) < 0, "Price must be greater than zero!");
        this.name = name;
        this.price = price;
        this.description = description;
    }
    protected ProProduct() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ElementCollection
    public Map<String, String> getAttributes() {
        return Collections.unmodifiableMap(attributes);
    }

    public void setAttribute(String name, String value) {
        Assert.hasText(name);
        if (value == null) {
            this.attributes.remove(value);
        } else {
            this.attributes.put(name, value);
        }
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }
}
