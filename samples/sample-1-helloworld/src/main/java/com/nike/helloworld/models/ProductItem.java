package com.nike.helloworld.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductItem implements Serializable {

    @NotNull(message = "ERROR_PRODUCT_ID_REQUIRED")
    public final String productId;

    @NotNull(message = "ERROR_PRODUCT_NAME_REQUIRED")
    public final String productName;

    @NotNull(message = "ERROR_PRODUCT_CATEGORY_REQUIRED")
    public final String productCategory;

    public final String productDescription;

    protected ProductItem(){
        this(null, null, null, null);
    }

    public ProductItem(String productId, String productName, String productCategory, String productDescription) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productDescription = productDescription;
    }
}
