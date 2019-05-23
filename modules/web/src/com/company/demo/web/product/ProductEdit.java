package com.company.demo.web.product;

import com.haulmont.cuba.gui.screen.*;
import com.company.demo.entity.Product;

@UiController("demo_Product.edit")
@UiDescriptor("product-edit.xml")
@EditedEntityContainer("productDc")
@LoadDataBeforeShow
public class ProductEdit extends StandardEditor<Product> {
}