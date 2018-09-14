package com.company.touraddondemo.web.product;

import com.haulmont.addon.tour.web.gui.components.Tour;
import com.haulmont.addon.tour.web.gui.components.TourStartAction;
import com.haulmont.addon.tour.web.gui.utils.TourParser;
import com.haulmont.cuba.core.global.Resources;
import com.haulmont.cuba.gui.components.AbstractLookup;

import javax.inject.Inject;
import java.util.Map;

public class ProductBrowse extends AbstractLookup {

    @Inject
    protected Resources resources;

    @Inject
    protected TourParser tourParser;

    protected Tour tour;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        createTour(); // Create a tour

        startTour(); // Start the tour
    }

    protected void createTour() {
        // The path to your source folder
        String sourceFolder = "com/company/touraddondemo/web/product/";
        // Your JSON file
        String file = resources.getResourceAsString(sourceFolder + "productBrowseTour.json");
        // Parse your tour from your JSON using given messages pack and extending this window
        tour = tourParser.parseTour(file, getMessagesPack(), this);
    }

    public void startTour() {
        // Create an action to start the tour
        TourStartAction tourStartAction = TourStartAction.create(tour);
        // Set that tour will start every time
        tourStartAction.setSettingsEnabled(false);
        // Perform the start action by this window
        tourStartAction.actionPerform(this);
    }
}