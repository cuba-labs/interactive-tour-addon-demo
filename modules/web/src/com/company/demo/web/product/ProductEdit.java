package com.company.demo.web.product;

import com.company.demo.entity.Product;
import com.haulmont.addon.tour.web.gui.components.*;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Form;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("demo_Product.edit")
@UiDescriptor("product-edit.xml")
@EditedEntityContainer("productDc")
@LoadDataBeforeShow
public class ProductEdit extends StandardEditor<Product> {

    @Inject
    private Form form;
    @Inject
    private Button windowClose;
    @Inject
    private MessageBundle messageBundle;

    protected Tour tour;
    protected TourStartAction tourStartAction;

    @Subscribe
    private void onInit(InitEvent event) {
        createTour();
        tourStartAction = TourStartAction.create(tour);
        tourStartAction.actionPerform(getWindow());
    }

    protected void createTour() {
        tour = new Tour(getWindow());
        tour.addStep(createStepOne());
        tour.addStep(createStepTwo());
        tour.addStep(createStepThree());
    }

    protected Step createStepOne() {
        Step step = new Step("editStepOne");

        step.setText(messageBundle.getMessage("tour.editStartedText"));
        step.setTitle(messageBundle.getMessage("tour.editStartedTitle"));
        step.setWidth("400");
        step.setTextContentMode(ContentMode.HTML);
        step.setTitleContentMode(ContentMode.HTML);
        step.setCancellable(true);

        StepButton stepButton = new StepButton(messageBundle.getMessage("tour.cancel"));
        stepButton.setStyleName("danger");
        stepButton.setEnabled(true);
        stepButton.addStepButtonClickListener(TourActionType.CANCEL::execute);

        step.addButton(stepButton);

        stepButton = new StepButton(messageBundle.getMessage("tour.next"));
        stepButton.setStyleName("friendly");
        stepButton.setEnabled(true);
        stepButton.addStepButtonClickListener(TourActionType.NEXT::execute);

        step.addButton(stepButton);

        return step;
    }

    protected Step createStepTwo() {
        Step step = new Step("editStepTwo");

        step.setText(messageBundle.getMessage("tour.formText"));
        step.setTitle(messageBundle.getMessage("tour.formTitle"));
        step.setWidth("400");
        step.setTextContentMode(ContentMode.HTML);
        step.setTitleContentMode(ContentMode.HTML);
        step.setAttachedTo(form);
        step.setAnchor(StepAnchor.RIGHT);

        StepButton stepButton = new StepButton(messageBundle.getMessage("tour.back"));
        stepButton.setStyleName("primary");
        stepButton.setEnabled(true);
        stepButton.addStepButtonClickListener(TourActionType.BACK::execute);

        step.addButton(stepButton);

        stepButton = new StepButton(messageBundle.getMessage("tour.next"));
        stepButton.setStyleName("friendly");
        stepButton.setEnabled(true);
        stepButton.addStepButtonClickListener(TourActionType.NEXT::execute);

        step.addButton(stepButton);

        return step;
    }

    protected Step createStepThree() {
        Step step = new Step("editStepThree");

        step.setText(messageBundle.getMessage("tour.windowActionsText"));
        step.setTitle(messageBundle.getMessage("tour.windowActionsTitle"));
        step.setWidth("400");
        step.setTextContentMode(ContentMode.HTML);
        step.setTitleContentMode(ContentMode.HTML);
        step.setAttachedTo(windowClose);
        step.setAnchor(StepAnchor.RIGHT);

        StepButton stepButton = new StepButton(messageBundle.getMessage("tour.back"));
        stepButton.setStyleName("primary");
        stepButton.setEnabled(true);
        stepButton.addStepButtonClickListener(TourActionType.BACK::execute);

        step.addButton(stepButton);

        stepButton = new StepButton(messageBundle.getMessage("tour.finish"));
        stepButton.setStyleName("friendly");
        stepButton.setEnabled(true);
        stepButton.addStepButtonClickListener(TourActionType.NEXT::execute);

        step.addButton(stepButton);

        return step;
    }
}