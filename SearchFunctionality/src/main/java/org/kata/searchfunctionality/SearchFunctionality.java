package org.kata.searchfunctionality;

import java.util.List;
import java.util.stream.Collectors;

public class SearchFunctionality {

    List<String> cities;

    public SearchFunctionality() {
        this.cities = List.of("Paris", "Budapest", "Skopje", "Rotterdam", "Valencia",
                "Vancouver", "Amsterdam", "Vienna", "Sydney", "New York City", "London", "Bangkok",
                "Hong Kong", "Dubai", "Rome", "Istanbul");
    }
    public List<String> search(String inputString) {
        if (inputString.equals("*")) return cities;
        if (inputString.length() < 2) return List.of();
        return cities.stream()
                .filter(city -> city.contains(inputString))
                .collect(Collectors.toList());
    }
}
