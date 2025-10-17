package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    // --- Existing tests ---

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> cityList.add(city));
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    // --- New tests for your exercise ---

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City city = mockCity();
        assertTrue(cityList.hasCity(city));

        City nonExistent = new City("Toronto", "Ontario");
        assertFalse(cityList.hasCity(nonExistent));
    }

    @Test
    void testDeleteCity() {
        CityList cityList = mockCityList();
        City city = mockCity();
        cityList.delete(city);
        assertFalse(cityList.hasCity(city));
        assertEquals(0, cityList.countCities());
    }

    @Test
    void testDeleteCityException() {
        CityList cityList = new CityList();
        City city = new City("Calgary", "Alberta");
        assertThrows(IllegalArgumentException.class, () -> cityList.delete(city));
    }

    @Test
    void testCountCities() {
        CityList cityList = new CityList();
        assertEquals(0, cityList.countCities());
        cityList.add(mockCity());
        assertEquals(1, cityList.countCities());
    }
}
