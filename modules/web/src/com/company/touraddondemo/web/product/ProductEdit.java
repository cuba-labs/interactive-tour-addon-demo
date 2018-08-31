package com.company.touraddondemo.web.product;

import com.haulmont.addon.tour.web.gui.components.Tour;
import com.haulmont.addon.tour.web.gui.components.TourStartAction;
import com.haulmont.addon.tour.web.gui.utils.TourParser;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Resources;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.touraddondemo.entity.Product;

import javax.inject.Inject;
import java.util.Objects;

public class ProductEdit extends AbstractEditor<Product> {

    @Inject
    protected Resources resources;

    protected Tour tour;

    @Override
    protected void postInit() {
        super.postInit();

        createTour();

        TourStartAction tourStartAction = TourStartAction.create(tour);
        tourStartAction.actionPerform(this);
    }

    protected void createTour() {
        String file = Objects.requireNonNull(resources
                .getResourceAsString("com/company/touraddondemo/web/product/productEditTour.json"));
        TourParser tourParser = AppBeans.get(TourParser.class);
        tour = tourParser.parseTour(file, getMessagesPack(), this);
    }
}