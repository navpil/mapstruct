package org.mapstruct.ap.internal.model.source;

import org.junit.Assert;
import org.junit.Test;

public class ForgedMethodHistoryTest {
    @Test
    public void getCombinedSourceElement() throws Exception {
        ForgedMethodHistory car = new ForgedMethodHistory(null, "Car car", "car", null, null, false);
        ForgedMethodHistory wheel = new ForgedMethodHistory(car, "Wheel wheel", "wheel", null, null, false);

        Assert.assertEquals("Wheel car.wheel", wheel.getDottedSourceElement());
    }

    @Test
    public void getCombinedTargetPropertyName() throws Exception {
        ForgedMethodHistory car = new ForgedMethodHistory(null, "Car car", "car", null, null, false);
        ForgedMethodHistory wheel = new ForgedMethodHistory(car, "Wheel wheel", "wheel", null, null, false);

        Assert.assertEquals("car.wheel", wheel.getDottedTargetPropertyName());
    }

}