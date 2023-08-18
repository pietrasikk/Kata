package org.kata.searchfunctionality;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchFunctionalityTest {

    SearchFunctionality searchFunctionality = new SearchFunctionality();

    @Test
    void shouldReturn0Results_whenPassStringFewerThan2Characters() {
        String inputString = "a";
        List<String> cities = searchFunctionality.search(inputString);
        assertEquals(0, cities.size());
    }

    @Test
    void shouldReturnResults_whenPassStringAtLeast2Characters() {
        String inputString = "Va";
        List<String> cities = searchFunctionality.search(inputString);
        assertEquals(2, cities.size());
        assertEquals("Valencia", cities.get(0));
        assertEquals("Vancouver", cities.get(1));
    }

    @Test
    void shouldReturn0Results_whenPassStringAtLeast2CharactersWithoutCaseSensitive() {
        String inputString = "va";
        List<String> cities = searchFunctionality.search(inputString);
        assertEquals(0, cities.size());
    }

    @Test
    void shouldReturnResults_whenPassStringThatIsPartOfTheCity() {
        String inputString = "ape";
        List<String> cities = searchFunctionality.search(inputString);
        assertEquals(1, cities.size());
        assertEquals("Budapest", cities.get(0));
    }

    @Test
    void shouldReturnAllResults_whenPassAsterisk() {
        String inputString = "*";
        List<String> cities = searchFunctionality.search(inputString);
        assertEquals(16, cities.size());
    }
}
