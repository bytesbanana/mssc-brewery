package com.bytesbanana.msscbrewery.web.controller.v2;

import com.bytesbanana.msscbrewery.services.BeerService;
import com.bytesbanana.msscbrewery.services.v2.BeerServiceV2;
import com.bytesbanana.msscbrewery.web.model.BeerDto;
import com.bytesbanana.msscbrewery.web.model.v2.BeerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class BeerControllerV2 {
    private final BeerServiceV2 beerService;

    public BeerControllerV2(BeerServiceV2 beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable UUID beerId) {

        return ResponseEntity.ok(beerService.getBeerById(beerId));
    }

    @PostMapping
    public ResponseEntity<Object> post(@RequestBody BeerDtoV2 beerDto) {
        BeerDtoV2 saveDto = beerService.saveNewBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();
        String location = String.format("/api/v1/beer/%s", saveDto.getId().toString());
        headers.add("Location", location);

        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(headers)
                .build();
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> handleUpdate(@PathVariable UUID beerId, @RequestBody BeerDtoV2 beerDto) {
        beerService.updateBeer(beerDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable String beerId) {
        beerService.deleteBeer(beerId);
    }


}
