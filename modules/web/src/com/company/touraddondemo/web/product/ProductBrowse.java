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

        createTour();

        startTour();
    }

    protected void createTour() {
        String sourceFolder = "com/company/touraddondemo/web/product/";
        String file = resources.getResourceAsString(sourceFolder + "productBrowseTour.json");
        tour = tourParser.parseTour(file, getMessagesPack(), this);
    }

    public void startTour() {
        TourStartAction tourStartAction = TourStartAction.create(tour);
        tourStartAction.setSettingsEnabled(false);
        tourStartAction.actionPerform(this);
    }
}