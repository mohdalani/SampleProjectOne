package com.example.mohda.sampleprojectone;

import com.example.mohda.sampleprojectone.controller.BadTriangle;
import com.example.mohda.sampleprojectone.controller.Converter;

import junit.framework.Assert;

import org.junit.Test;

import java.util.List;
import java.util.Vector;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by mohda on 12/6/2017.
 */

public class ConverterUnitTest {
    @Test
    public void testConvertion1() {
        Converter controller = new Converter();
        double res = controller.fromGtoKG(1000);
        assertEquals("Conversion of 1000", 1.0d, res);
    }

    @Test
    public void testTriangle1() throws BadTriangle {
        Converter controler = new Converter();
        double res = controler.triangleArea(1, 1, Math.sqrt(2));
        assertEquals("Area of 1 1 1,42", .5d, res, 0.001);
        double diff = Math.abs(res - 0.5d);
        if (diff > 0.001) {
            assertTrue(false);
        }
    }
    @Test
    public void testTriangle2() throws BadTriangle {
        Converter controler = new Converter();
        double res = controler.triangleArea(1, 1, 2);
        assertEquals("Area of 1 1 2", .0d, res, 0.001);
    }
    @Test
    public void testTriangle3()  {
        Converter controler = new Converter();
        try {
            double res = controler.triangleArea(1, 1, 3);
            assertTrue(false);
        }
        catch (BadTriangle ex) {

        }
    }


    @Test
    public void testSort1() {
        Converter controller = new Converter();
        Vector<Integer> v = new Vector<Integer>();
        v.add(1);
        v.add(0);
        v.add(25);

        List<Integer> res = controller.sortList(v);
        assertNotNull(res);
        assertEquals("First Element", 0, res.get(0).intValue());
        assertEquals("Second Element", 1, res.get(1).intValue());
        assertEquals("Third Element", 25, res.get(2).intValue());
        assertEquals("List size", 3, res.size());
    }

    Converter createSetupOne() {
        Converter controller = new Converter();
        controller.speed = 1;
        controller.position = 25;
        return controller;
    }

    @Test
    public void testGame() {
        Converter controller = createSetupOne();
        controller.updatePosition(1, true);
        assertEquals(0.d, controller.speed);
        assertEquals(25.d, controller.position);
    }
    @Test
    public void testGame1() {
        Converter controller = createSetupOne();
        controller.updatePosition(1, false);
        assertEquals(10.81d, controller.speed, 0.0001);
        assertEquals(14.19d, controller.position, 0.00001);
    }
    @Test
    public void testGame2() {
        Converter controller = createSetupOne();
        controller.updatePosition(1, false);
        assertTrue(controller.position >= 0);
    }

    @Test
    public void testGame3() {
        Converter controller = new Converter();
        controller.speed = 23;
        controller.position = 12;
        controller.updatePosition(1, false);
        assertTrue(controller.position >= 0);
    }
}
