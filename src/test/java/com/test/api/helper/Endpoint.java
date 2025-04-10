package com.test.api.helper;

public class Endpoint {
    //Base URL for API
    public static final String baseURL = "https://swapi.dev/";

    // Endpoints
    public static final String star_wars_get_people = baseURL + "/api/people";
    public static final String star_wars_get_person = baseURL + "/api/people/1/";
    public static final String invalid_person = baseURL + "/api/people/invalid";

}
