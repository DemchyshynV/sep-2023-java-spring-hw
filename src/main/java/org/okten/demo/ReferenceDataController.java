package org.okten.demo;

import lombok.RequiredArgsConstructor;
import org.okten.demo.properties.Fuel;
import org.okten.demo.properties.ReferenceDataProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ReferenceDataController {

    @Value("${reference-data.engineTypes}")
    private List<String> engines;


    private final ReferenceDataProperties referenceDataProperties;

    @GetMapping("/engine-types")
    public ResponseEntity<List<String>> getEngineTypes() {
        return ResponseEntity.ok(engines);
    }

    @GetMapping("/fuel-types")
    public ResponseEntity<List<Fuel>> getOffices() {
        return ResponseEntity.ok(referenceDataProperties.getFuels());
    }
//
    @GetMapping("/fuel-types/{name}")
    public ResponseEntity<Fuel> getOffice(@PathVariable String name) {
        Optional<Fuel> result = Optional
                .ofNullable(referenceDataProperties)
                .map(ReferenceDataProperties::getFuels)
                .stream()
                .flatMap(Collection::stream)
                .filter(fuel -> Objects.equals(fuel.getName(), name))
                .findFirst();

        return ResponseEntity.of(result);
    }
}
