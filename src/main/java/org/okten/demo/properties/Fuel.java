package org.okten.demo.properties;

import lombok.Data;

import java.util.List;

@Data
public class Fuel {
    private String name;
    private List<String> types;
}