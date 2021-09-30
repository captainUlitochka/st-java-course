package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testDistance() {
    Point p1 = new Point(1,2);
    Point p2 = new Point(4,6);
    Assert.assertEquals(p1.findDistance(p2), 5.0);
  }

  @Test
  public void testDistanceWhenZeroY() {
    Point p1 = new Point(-5,0);
    Point p2 = new Point(3,0);
    Assert.assertEquals(p1.findDistance(p2), 8);
  }

  @Test
  public void testDistanceWhenAllZero() {
    Point p1 = new Point(0,0);
    Point p2 = new Point(0,0);
    Assert.assertEquals(p1.findDistance(p2), 0);
  }

  @Test
  public void testDistanceWhenMinus() {
    Point p1 = new Point(-1,-1);
    Point p2 = new Point(-1,-4);
    Assert.assertEquals(p1.findDistance(p2),3);
  }
}