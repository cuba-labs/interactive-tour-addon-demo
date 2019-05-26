package com.company.demo.web.product;

import com.haulmont.addon.tour.web.gui.components.*;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.ComponentsHelper;
import com.haulmont.cuba.gui.screen.*;
import com.company.demo.entity.Product;

import javax.inject.Inject;
import java.util.Objects;

@UiController("demo_Product.edit")
@UiDescriptor("product-edit.xml")
@EditedEntityContainer("productDc")
@LoadDataBeforeShow
public class ProductEdit extends StandardEditor<Product> {

    @Inject
    private Messages messages;

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

        step.setText(messages.getMessage(getClass(),"tour.editStartedText"));
        step.setTitle(messages.getMessage(getClass(), "tour.editStartedTitle"));
        step.setWidth("400");
        step.setTextContentMode(ContentMode.HTML);
        step.setTitleContentMode(ContentMode.HTML);
        step.setCancellable(true);

        StepButton stepButton = new StepButton(messages.getMessage(getClass(), "tour.cancel"));
        stepButton.setStyleName("danger");
        stepButton.setEnabled(true);
        stepButton.addStepButtonClickListener(TourActionType.CANCEL::execute);

        step.addButton(stepButton);

        stepButton = new StepButton(messages.getMessage(getClass(), "tour.next"));
        stepButton.setStyleName("friendly");
        stepButton.setEnabled(true);
        stepButton.addStepButtonClickListener(TourActionType.NEXT::execute);

        step.addButton(stepButton);

        return step;
    }

    protected Step createStepTwo() {
        Step step = new Step("editStepTwo");

        step.setText(messages.getMessage(getClass(),"tour.formText"));
        step.setTitle(messages.getMessage(getClass(),"tour.formTitle"));
        step.setWidth("400");
        step.setTextContentMode(ContentMode.HTML);
        step.setTitleContentMode(ContentMode.HTML);
        step.setAttachedTo(Objects.requireNonNull(ComponentsHelper.findComponent(getWindow().getFrame(), "form")));
        step.setAnchor(StepAnchor.RIGHT);

        StepButton stepButton = new StepButton(messages.getMessage(getClass(),"tour.back"));
        stepButton.setStyleName("primary");
        stepButton.setEnabled(true);
        stepButton.addStepButtonClickListener(TourActionType.BACK::execute);

        step.addButton(stepButton);

        stepButton = new StepButton(messages.getMessage(getClass(),"tour.next"));
        stepButton.setStyleName("friendly");
        stepButton.setEnabled(true);
        stepButton.addStepButtonClickListener(TourActionType.NEXT::execute);

        step.addButton(stepButton);

        return step;
    }

    protected Step createStepThree() {
        Step step = new Step("editStepThree");

        step.setText(messages.getMessage(getClass(),"tour.windowActionsText"));
        step.setTitle(messages.getMessage(getClass(),"tour.windowActionsTitle"));
        step.setWidth("400");
        step.setTextContentMode(ContentMode.HTML);
        step.setTitleContentMode(ContentMode.HTML);
        step.setAttachedTo(Objects.requireNonNull(ComponentsHelper.findComponent(getWindow().getFrame(), "windowClose")));
        step.setAnchor(StepAnchor.RIGHT);

        StepButton stepButton = new StepButton(messages.getMessage(getClass(),"tour.back"));
        stepButton.setStyleName("primary");
        stepButton.setEnabled(true);
        stepButton.addStepButtonClickListener(TourActionType.BACK::execute);

        step.addButton(stepButton);

        stepButton = new StepButton(messages.getMessage(getClass(),"tour.finish"));
        stepButton.setStyleName("friendly");
        stepButton.setEnabled(true);
        stepButton.addStepButtonClickListener(TourActionType.NEXT::execute);

        step.addButton(stepButton);

        return step;
    }
}