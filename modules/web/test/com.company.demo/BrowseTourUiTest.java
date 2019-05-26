package com.company.demo;

import com.codeborne.selenide.SelenideElement;
import com.company.demo.composite.LoginWindow;
import com.company.demo.composite.ProductBrowse;
import com.company.demo.rule.DefaultCleanup;
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

public class BrowseTourUiTest {

    @Rule
    public TestRule defaultCleanup = new DefaultCleanup();

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
    public void checkCancelButton() {
        SelenideElement stepContent = $(byAttribute("data-id", "browseStepOne"))
                .lastChild()
                .should(exist);

        stepContent.find(withText("Cancel"))
                .click();

        stepContent.shouldNot(exist);
    }

    @Test
    public void checkCloseIcon() {
        SelenideElement stepContent = $(byAttribute("data-id", "browseStepOne"))
                .lastChild()
                .should(exist);

        stepContent.find(byClassName("shepherd-cancel-link"))
                .click();

        stepContent.shouldNot(exist);
    }

    @Test
    public void checkTutorialButton() {
        SelenideElement stepContent = $(byAttribute("data-id", "browseStepOne"))
                .lastChild()
                .should(exist);

        stepContent.find(withText("Next"))
                .click();

        stepContent = $(byAttribute("data-id", "browseStepTwo"))
                .lastChild()
                .should(exist);

        stepContent.find(withText("Next"))
                .click();

        stepContent = $(byAttribute("data-id", "browseStepThree"))
                .lastChild()
                .should(exist);

        stepContent.find(withText("Next"))
                .click();

        $c(ProductBrowse.class).startTourBtn
                .click();

        $(byAttribute("data-id", "browseStepOne"))
                .lastChild()
                .should(exist);
    }

    @Test
    public void goThroughBrowserTour() {
        SelenideElement stepContent = $(byAttribute("data-id", "browseStepOne"))
                .lastChild()
                .should(exist);

        stepContent.find(withText("Next"))
                .click();

        stepContent = $(byAttribute("data-id", "browseStepTwo"))
                .lastChild()
                .should(exist);

        stepContent.find(withText("Next"))
                .click();

        stepContent = $(byAttribute("data-id", "browseStepThree"))
                .lastChild()
                .should(exist);

        stepContent.find(withText("Next"))
                .click();

        stepContent = $(byAttribute("data-id", "browseStepFour"))
                .lastChild()
                .should(exist);

        stepContent.find(withText("Next"))
                .click();

        stepContent = $(byAttribute("data-id", "browseStepFive"))
                .lastChild()
                .should(exist);

        stepContent.find(withText("Finish"))
                .click();

        $(byClassName(".shepherd-content"))
                .shouldNot(exist);
    }
}
