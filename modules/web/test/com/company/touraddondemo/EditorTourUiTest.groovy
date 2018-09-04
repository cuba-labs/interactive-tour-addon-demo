package com.company.touraddondemo

import com.company.touraddondemo.rules.DefaultCleanup
import com.company.touraddondemo.ui.LoginWindow
import com.company.touraddondemo.ui.ProductBrowser
import com.company.touraddondemo.ui.ProductEdit
import com.haulmont.masquerade.components.AppMenu
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

import static com.codeborne.selenide.Condition.exist
import static com.codeborne.selenide.Selectors.*
import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.open
import static com.company.touraddondemo.util.UiTestManager.executeSql
import static com.haulmont.masquerade.Components._$

class EditorTourUiTest{

    @Rule
    public TestRule defaultCleanup = new DefaultCleanup()

    @Before
    void login() {
        // open URL of an application
        open("http://localhost:8080/app")

        _$(LoginWindow.class).localesSelect
                .openOptionsPopup()
                .select('English')

        // login to the application
        _$(LoginWindow.class).loginButton.click()

        // open application menu item
        _$(AppMenu).openItem('application-touraddondemo', 'touraddondemo$Product.browse')
    }

    @Before
    void clearDb() {
        executeSql("delete from SEC_USER_SETTING")
    }

    @Test
    void goThroughEditorTour() {
        $(withText("started"))
                .closest(".shepherd-content")
                .should(exist)

        _$(ProductBrowser).createBtn.click()

        def stepContent = $(withText("Editor"))
                .closest(".shepherd-content")
                .should(exist)

        stepContent.find(withText("Next"))
                .click()

        stepContent = $(byText("Field group"))
                .closest(".shepherd-content")
                .should(exist)

        stepContent.find(withText("Next"))
                .click()

        stepContent = $(withText("Window"))
                .closest(".shepherd-content")
                .should(exist)

        stepContent.find(withText("Finish"))
                .click()

        $(byClassName(".shepherd-content")).shouldNot(exist)
    }

    @Test
    void goThroughEditorTourTwice() {
        $(withText("started"))
                .closest(".shepherd-content")
                .should(exist)

        _$(ProductBrowser).createBtn.click()

        $(withText("Editor"))
                .closest(".shepherd-content")
                .should(exist)

        _$(ProductEdit).windowClose.click()

        _$(ProductBrowser).createBtn.click()

        $(byClassName(".shepherd-content")).shouldNot(exist)
    }
}
