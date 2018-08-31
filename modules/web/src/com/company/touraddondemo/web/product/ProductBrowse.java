package com.company.touraddondemo.web.product;

import com.haulmont.addon.tour.web.gui.components.Tour;
import com.haulmont.addon.tour.web.gui.components.TourStartAction;
import com.haulmont.addon.tour.web.gui.utils.TourParser;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Resources;
import com.haulmont.cuba.gui.components.AbstractLookup;

import javax.inject.Inject;
import java.util.Map;
import java.util.Objects;

public class ProductBrowse extends AbstractLookup {

    @Inject
    protected Resources resources;

    protected Tour tour;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        createTour();

        TourStartAction tourStartAction = TourStartAction.create(tour);
        tourStartAction.setSettingsEnabled(false);
        tourStartAction.actionPerform(this);
    }

    protected void createTour() {
        String file = Objects.requireNonNull(resources
                .getResourceAsString("com/company/touraddondemo/web/product/productBrowseTour.json"));
        TourParser tourParser = AppBeans.get(TourParser.class);
        tour = tourParser.parseTour(file, getMessagesPack(), this);
    }
}