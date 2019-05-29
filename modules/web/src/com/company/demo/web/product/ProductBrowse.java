package com.company.demo.web.product;

import com.haulmont.cuba.gui.screen.*;
import com.company.demo.entity.Product;
import com.haulmont.addon.tour.web.gui.components.Tour;
import com.haulmont.addon.tour.web.gui.components.TourStartAction;
import com.haulmont.addon.tour.web.gui.utils.TourParser;
import com.haulmont.cuba.core.global.Resources;

import javax.inject.Inject;

@UiController("demo_Product.browse")
@UiDescriptor("product-browse.xml")
@LookupComponent("productsTable")
@LoadDataBeforeShow
public class ProductBrowse extends StandardLookup<Product> {

    @Inject
    protected Resources resources;
    @Inject
    protected TourParser tourParser;
    @Inject
    private MessageBundle messageBundle;

    protected Tour tour;
    protected TourStartAction tourStartAction;

    @Subscribe
    private void onInit(InitEvent event) {
        createTour();
        createTourStartAction();
        startTour();
    }

    protected void createTour() {
        String jsonTourDescriptionLocation = "com/company/demo/web/product/productBrowseTour.json";
        String jsonTourDescription = resources.getResourceAsString(jsonTourDescriptionLocation);
        tour = tourParser.parseTour(jsonTourDescription, messageBundle.getMessagesPack(), getWindow());
    }

    protected void createTourStartAction() {
        tourStartAction = TourStartAction.create(tour);
        // The Tour will start each time if the settings disabled
        tourStartAction.setSettingsEnabled(false);
    }

    public void startTour() {
        tourStartAction.actionPerform(getWindow());
    }
}