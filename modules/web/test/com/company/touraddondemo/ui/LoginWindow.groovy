package com.company.touraddondemo.ui

import com.haulmont.masquerade.Wire
import com.haulmont.masquerade.base.Composite
import com.haulmont.masquerade.components.*

/**
 *This class is the abstraction of the Login Window screen and defines all components to be displayed
 */
class LoginWindow extends Composite<LoginWindow> {

    @Wire
    Button loginButton

    @Wire
    LookupField localesSelect
}