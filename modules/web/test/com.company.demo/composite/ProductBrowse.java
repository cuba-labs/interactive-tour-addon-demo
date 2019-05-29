package com.company.demo.composite;

import com.haulmont.masquerade.Wire;
import com.haulmont.masquerade.base.Composite;
import com.haulmont.masquerade.components.Button;

public class ProductBrowse extends Composite<ProductBrowse> {

    @Wire
    public Button startTourBtn;

    @Wire
    public Button createBtn;
}
