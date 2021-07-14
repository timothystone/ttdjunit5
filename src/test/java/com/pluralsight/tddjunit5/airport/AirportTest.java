package com.pluralsight.tddjunit5.airport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AirportTest {

  @Test
  void testAirport() {
    Flight coach = new Flight("1", "Economy");
    Flight business = new Flight("2", "Business");

    Passenger john = new Passenger("John", true);
    Passenger mike = new Passenger("Mike", false);

    assertEquals(true, coach.addPassenger(john));
    assertEquals(false, coach.removePassenger(john));
    assertEquals(true, business.addPassenger(john));
    assertEquals(false, business.removePassenger(john));

    // Simply the assertion using JUnit5 API utilities
    assertTrue(coach.addPassenger(mike));
    assertTrue(coach.removePassenger(mike));
    assertFalse(business.addPassenger(mike));
    assertFalse(business.removePassenger(mike));

  }
}