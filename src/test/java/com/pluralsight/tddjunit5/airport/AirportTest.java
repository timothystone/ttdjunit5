package com.pluralsight.tddjunit5.airport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AirportTest {

  private Flight economyFlight;
  private Flight businessFlight;
  private Passenger typical = new Passenger("Mike", false);
  private Passenger vip = new Passenger("John", true);

  @Nested
  class EconomyFlightTests {

    @BeforeEach
    void setUp() {
      economyFlight = new EconomyFlight("1");
    }

    @Test
    void testEconomyFlightWithTypicalPassenger() {

      assertEquals("1", economyFlight.getId());
      assertEquals(true, economyFlight.addPassenger(typical));
      assertEquals(1, economyFlight.getPassengersList().size());
      assertEquals("Mike", economyFlight.getPassengersList().get(0).getName());

      assertEquals(true, economyFlight.removePassenger(typical));
      assertEquals(0, economyFlight.getPassengersList().size());
    }

    @Test
    void testEconomyFlightWithVipPassenger() {

      assertEquals("1", economyFlight.getId());
      assertTrue(economyFlight.addPassenger(vip));
      assertEquals(1, economyFlight.getPassengersList().size());
      assertEquals("John", economyFlight.getPassengersList().get(0).getName());

      assertFalse(economyFlight.removePassenger(vip));
      assertEquals(1, economyFlight.getPassengersList().size());
    }
  }

  @Nested
  class BusinessFlightTests {

    @BeforeEach
    void setUp() {
      businessFlight = new BusinessFlight("2");
    }

    @Test
    void testBusinessFlightWithTypicalPassenger() {
      assertFalse(businessFlight.addPassenger(typical));
      assertEquals(0, businessFlight.getPassengersList().size());
      assertFalse(businessFlight.removePassenger(typical));
      assertEquals(0, businessFlight.getPassengersList().size());
    }

    @Test
    void testBusinessFlightWithVipPassenger() {
      assertTrue(businessFlight.addPassenger(vip));
      assertEquals(1, businessFlight.getPassengersList().size());
      assertFalse(businessFlight.removePassenger(vip));
      assertEquals(1, businessFlight.getPassengersList().size());
    }

  }
}