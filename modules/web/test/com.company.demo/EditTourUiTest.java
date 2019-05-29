package com.company.demo;

import com.codeborne.selenide.SelenideElement;
import com.company.demo.composite.LoginWindow;
import com.company.demo.composite.ProductBrowse;
import com.company.demo.composite.ProductEdit;
import com.company.demo.jmx.UiTestSupport;
import com.company.demo.rule.DefaultCleanup;
import com.haulmont.masquerade.Connectors;
import com.haulmont.masquerade.components.AppMenu;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.haulmont.masquerade.Selectors.$c;

public class EditTourUiTest {

    @Rule
    public TestRule defaultCleanup = new DefaultCleanup();

    @Before
    public void clearUserSettings() {
        Connectors.jmx(UiTestSupport.class).clearUserSettings();
    }

    @Before
    public void login() {
        open("http://localhost:8080/app");
        $c(LoginWindow.class).localesSelect
                .openOptionsPopup()
                .select("English");

        $c(LoginWindow.class).loginButton.click();
        $c(AppMenu.class).openItem("application-demo", "demo_Product.browse");
    }

    @Test
    public void goThroughEditorTour() {
        $c(ProductBrowse.class).createBtn
                .click();

        SelenideElement stepContent = $(byAttribute("data-id", "editStepOne"))
                .lastChild()
                .should(exist);

        stepContent.find(withText("Next"))
                .click();

        stepContent = $(byAttribute("data-id", "editStepTwo"))
                .lastChild()
                .should(exist);

        stepContent.find(withText("Next"))
                .click();

        stepContent = $(byAttribute("data-id", "editStepThree"))
                .lastChild()
                .should(exist);

        stepContent.find(withText("Finish"))
                .click();

        $(byClassName(".shepherd-content"))
                .shouldNot(exist);

    }

    @Test
    public void goThroughEditorTourTwice() {
        $c(ProductBrowse.class).createBtn
                .click();

        $(byAttribute("data-id", "editStepOne"))
                .lastChild()
                .should(exist);

        $c(ProductEdit.class).windowClose.click();

        $c(ProductBrowse.class).createBtn
                .click();

        $(byClassName(".shepherd-content"))
                .shouldNot(exist);
    }

}
