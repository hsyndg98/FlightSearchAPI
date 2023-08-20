package com.example.flightsearchapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Airport extends BaseEntity {

    private String city;

    @Override
    public String toString() {
        return "Airport{" +
                "id= '" + getId() + '\'' +
                "city='" + city + '\'' +
                '}';
    }
}
