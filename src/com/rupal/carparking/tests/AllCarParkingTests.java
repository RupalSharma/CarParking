package com.rupal.carparking.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    TestCar.class,
    TestCarSlot.class,TestCarInventory.class,TestColorInventory.class,TestCarInventory.class, TestCarParkingManager.class })
public class AllCarParkingTests {

}
