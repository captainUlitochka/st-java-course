package ru.stqa.pft.soap;

import com.lavasoft.GeoIPService;
import com.lavasoft.GetIpLocation;
import com.lavasoft.GetLocation;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class GeoIpServiceTests {

  @Test
  public void testMyIp() {
    String geoIp = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("62.217.190.105");
    System.out.println(geoIp);}

}
