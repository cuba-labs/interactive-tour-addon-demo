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

        createTour();

        TourStartAction tourStartAction = TourStartAction.create(tour);
        tourStartAction.actionPerform(this);
    }

    protected void createTour() {
        tour = new Tour(this);

        Step step = new Step("step1");
        step.setText(getMessage("tour.editStartedText"));
        step.setTitle(getMessage("tour.editStartedTitle"));
        step.setWidth("400");
        step.setTextContentMode(ContentMode.HTML);
        step.setTitleContentMode(ContentMode.HTML);
        step.setCancellable(true);

        StepButton stepButton = new StepButton(getMessage("tour.cancel"));
        stepButton.setStyleName("danger");
        stepButton.setEnabled(true);
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