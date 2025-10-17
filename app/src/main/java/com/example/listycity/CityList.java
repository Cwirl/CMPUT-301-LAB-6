package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class maintains a list of {@link City} objects and provides methods to
 * add, remove, check existence, and count cities.
 */
public class CityList {
    private final List<City> cities = new ArrayList<>();

    /**
     * Adds a city to the list if it does not already exist.
     *
     * @param city the {@link City} object to add
     * @throws IllegalArgumentException if the city already exists in the list
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException("City already exists in the list.");
        }
        cities.add(city);
    }

    /**
     * Returns a sorted list of cities in ascending order by city name.
     *
     * @return a sorted {@link List} of {@link City} objects
     */
    public List<City> getCities() {
        List<City> list = new ArrayList<>(cities);
        Collections.sort(list);
        return list;
    }

    /**
     * Checks whether a given city exists in the list.
     *
     * @param city the {@link City} object to check
     * @return {@code true} if the city exists in the list, otherwise {@code false}
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Removes a city from the list if it exists.
     *
     * @param city the {@link City} object to remove
     * @throws IllegalArgumentException if the city does not exist in the list
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("City not found in the list.");
        }
        cities.remove(city);
    }

    /**
     * Returns the number of cities in the list.
     *
     * @return the count of {@link City} objects in the list
     */
    public int countCities() {
        return cities.size();
    }
}
