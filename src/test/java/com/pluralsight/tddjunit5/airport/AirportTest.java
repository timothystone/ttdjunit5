package com.pluralsight.tddjunit5.airport;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AirportTest {

  private Passenger typical = new Passenger("Mike", false);
  private Passenger vip = new Passenger("John", true);

  @DisplayName("Given there is an Economy Flight")
  @Nested
  class EconomyFlightTests {
    private Flight economyFlight;

    @BeforeEach
    void setUp() {
      economyFlight = new EconomyFlight("1");
    }

    @DisplayName("When we have a typical passenger")
    @Nested
    class TypicalPassenger {
      @DisplayName("Then you can add and remove the passenger from an Economy Flight")
      @Test
      void testEconomyFlightWithTypicalPassenger() {
        assertAll("Verify all conditions for a typical passenger and an economy flight",
            () -> assertEquals("1", economyFlight.getId()),
            () -> assertTrue(economyFlight.addPassenger(typical)),
            () -> assertEquals(1, economyFlight.getPassengersList().size()),
            () -> assertEquals("Mike", economyFlight.getPassengersList().get(0).getName()),
            () -> assertTrue(economyFlight.removePassenger(typical)),
            () -> assertEquals(0, economyFlight.getPassengersList().size())
        );
      }
    }

    @DisplayName("When we have a VIP Passenger")
    @Nested
    class VipPassenger {
      @DisplayName("Then you can add, but not remove, the passenger from an Economy Flight")
      @Test
      void testEconomyFlightWithVipPassenger() {
        assertAll("Verify all conditions for a VIP passenger and an economy flight",
            () -> assertEquals("1", economyFlight.getId()),
            () -> assertTrue(economyFlight.addPassenger(vip)),
            () -> assertEquals(1, economyFlight.getPassengersList().size()),
            () -> assertEquals("John", economyFlight.getPassengersList().get(0).getName()),
            () -> assertFalse(economyFlight.removePassenger(vip)),
            () -> assertEquals(1, economyFlight.getPassengersList().size())
        );
      }
    }
  }

  @DisplayName("Given there is an business flight")
  @Nested
  class BusinessFlightTests {
    private Flight businessFlight;

    @BeforeEach
    void setUp() {
      businessFlight = new BusinessFlight("2");
    }

    @DisplayName("When we have a typical passenger")
    @Nested
    class TypicalPassenger {
      @DisplayName("Then you cannot add or remove the passenger from a Business Flight")
      @Test
      void testBusinessFlightWithTypicalPassenger() {
        assertAll("Verify all conditions for a typical passenger and a business flight",
            () -> assertFalse(businessFlight.addPassenger(typical)),
            () -> assertEquals(0, businessFlight.getPassengersList().size()),
            () -> assertFalse(businessFlight.removePassenger(typical)),
            () -> assertEquals(0, businessFlight.getPassengersList().size())
        );
      }
    }

    @DisplayName("When we have a VIP passenger")
    @Nested
    class VipPassenger {
      @DisplayName("Then you can add, but not remove, the passenger from a Business Flight")
      @Test
      void testBusinessFlightWithVipPassenger() {
        assertAll("Verify all conditions for a VIP passenger and a business flight",
            () -> assertTrue(businessFlight.addPassenger(vip)),
            () -> assertEquals(1, businessFlight.getPassengersList().size()),
            () -> assertFalse(businessFlight.removePassenger(vip)),
            () -> assertEquals(1, businessFlight.getPassengersList().size())
        );
      }
    }
  }

  @DisplayName("Given there is a Premium Flight")
  @Nested
  class PremiumFlightTests {
    private Flight premiumFlight;

    @BeforeEach
    void setUp() {
      premiumFlight = new PremiumFlight("3");
    }

    @DisplayName("When we have a Typical Passenger")
    @Nested
    class TypicalPassenger {
      @DisplayName("Then we cannot add or remove the typical passenger from the flight")
      @Test
      void testPremiumFlightWithTypicalPassenger() {
        assertAll("Verify all conditions for a Typical Passenger and Premium Flight",
            () -> assertFalse(premiumFlight.addPassenger(typical)),
            () -> assertEquals(0, premiumFlight.getPassengersList().size()),
            () -> assertFalse(premiumFlight.removePassenger(typical)),
            () -> assertEquals(0, premiumFlight.getPassengersList().size())
        );
      }
    }

    @DisplayName("When we have a VIP Passenger")
    @Nested
    class VipPassenger {
      @DisplayName("Then we can add and remove the passenger from the flight")
      @Test
      void testPremiumFlightWithVipPassenger() {
        assertAll("Verify all conditions for a VIP Passenger and Premium Flight",
            () -> assertTrue(premiumFlight.addPassenger(vip)),
            () -> assertEquals(1, premiumFlight.getPassengersList().size()),
            () -> assertEquals("John", premiumFlight.getPassengersList().get(0).getName()),
            () -> assertTrue(premiumFlight.removePassenger(vip)),
            () -> assertEquals(0, premiumFlight.getPassengersList().size())
        );
      }
    }
  }
}