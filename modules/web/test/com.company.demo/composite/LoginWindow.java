package com.company.demo.composite;

import com.haulmont.masquerade.Wire;
import com.haulmont.masquerade.base.Composite;
import com.haulmont.masquerade.components.Button;
import com.haulmont.masquerade.components.LookupField;


public class LoginWindow extends Composite<LoginWindow> {

    @Wire
    public Button loginButton;

    @Wire
    public LookupField localesSelect;
}
