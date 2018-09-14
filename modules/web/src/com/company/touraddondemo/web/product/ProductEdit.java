package com.company.touraddondemo.web.product;

import com.company.touraddondemo.entity.Product;
import com.haulmont.addon.tour.web.gui.components.*;
import com.haulmont.cuba.gui.ComponentsHelper;
import com.haulmont.cuba.gui.components.AbstractEditor;

import java.util.Objects;

public class ProductEdit extends AbstractEditor<Product> {

    protected Tour tour;

    @Override
    protected void postInit() {
        super.postInit();

        createTour(); // Create a tour

        // Create an action to start the tour
        TourStartAction tourStartAction = TourStartAction.create(tour);
        // Perform the start action by this window
        tourStartAction.actionPerform(this);
    }

    // Creates the tour by JAVA classes
    protected void createTour() {
        // Create a tour extending this window
        tour = new Tour(this);

        // Create a step with your own id, might be null
        Step step = new Step("step1");
        step.setText(getMessage("tour.editStartedText"));
        step.setTitle(getMessage("tour.editStartedTitle"));
        step.setWidth("400");
        step.setTextContentMode(ContentMode.HTML);
        step.setTitleContentMode(ContentMode.HTML);
        step.setCancellable(true);

        // Create a step button with your own caption
        StepButton stepButton = new StepButton(getMessage("tour.cancel"));
        // You could set your own style to the step button
        stepButton.setStyleName("danger");
        stepButton.setEnabled(true);
        // You could use predefined actions from TourActionType and StepActionType or create
        // your own StepButtonClickListener
        stepButton.addStepButtonClickListener(TourActionType.CANCEL::execute);
        step.addButton(stepButton);

        stepButton = new StepButton(getMessage("tour.next"));
        stepButton.setStyleName("friendly");
        stepButton.setEnabled(true);
        stepButton.addStepButtonClickListener(TourActionType.NEXT::execute);
        step.addButton(stepButton);

        tour.addStep(step);

        step = new Step("step2");
        step.setText(getMessage("tour.fieldGroupText"));
        step.setTitle(getMessage("tour.fieldGroupTitle"));
        step.setWidth("400");
        step.setTextContentMode(ContentMode.HTML);
        step.setTitleContentMode(ContentMode.HTML);
        step.setAttachedTo(Objects.requireNonNull(ComponentsHelper.findComponent(getFrame(), "fieldGroup")));
        step.setAnchor(StepAnchor.RIGHT);

        stepButton = new StepButton(getMessage("tour.back"));
        stepButton.setStyleName("primary");
        stepButton.setEnabled(true);
        stepButton.addStepButtonClickListener(TourActionType.BACK::execute);
        step.addButton(stepButton);

        stepButton = new StepButton(getMessage("tour.next"));
        stepButton.setStyleName("friendly");
        stepButton.setEnabled(true);
        stepButton.addStepButtonClickListener(TourActionType.NEXT::execute);
        step.addButton(stepButton);

        tour.addStep(step);

        step = new Step("step3");
        step.setText(getMessage("tour.windowActionsText"));
        step.setTitle(getMessage("tour.windowActionsTitle"));
        step.setWidth("400");
        step.setTextContentMode(ContentMode.HTML);
        step.setTitleContentMode(ContentMode.HTML);
        step.setAttachedTo(Objects.requireNonNull(ComponentsHelper.findComponent(getFrame(), "windowClose")));
        step.setAnchor(StepAnchor.RIGHT);

        stepButton = new StepButton(getMessage("tour.back"));
        stepButton.setStyleName("primary");
        stepButton.setEnabled(true);
        stepButton.addStepButtonClickListener(TourActionType.BACK::execute);
        step.addButton(stepButton);

        stepButton = new StepButton(getMessage("tour.finish"));
        stepButton.setStyleName("friendly");
        stepButton.setEnabled(true);
        stepButton.addStepButtonClickListener(TourActionType.NEXT::execute);
        step.addButton(stepButton);

        tour.addStep(step);
    }
}