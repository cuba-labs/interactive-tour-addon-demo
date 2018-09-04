package com.company.touraddondemo.ui

import com.haulmont.masquerade.Wire
import com.haulmont.masquerade.base.Composite
import com.haulmont.masquerade.components.Button

class ProductBrowser extends Composite<ProductBrowser> {

    @Wire
    Button tourButton

    @Wire
    Button createBtn
}
