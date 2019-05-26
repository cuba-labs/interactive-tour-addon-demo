package com.company.demo.composite;

import com.haulmont.masquerade.Wire;
import com.haulmont.masquerade.base.Composite;
import com.haulmont.masquerade.components.Button;

public class ProductEdit extends Composite<ProductEdit> {

    @Wire
    public Button windowClose;
}
