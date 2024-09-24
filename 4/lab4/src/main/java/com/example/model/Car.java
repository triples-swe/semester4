package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Car {
    @JsonProperty("brand")
    private String brand;

    @JsonProperty("model")
    private String model;

    @JsonProperty("year")
    private int year;

    @JsonProperty("color")
    private String color;

    @JsonProperty("bodyType")
    private String bodyType;

    @JsonProperty("mileage")
    private int mileage;

    @JsonProperty("engineType")
    private String engineType;
}