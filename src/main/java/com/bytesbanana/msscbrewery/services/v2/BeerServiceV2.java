package com.bytesbanana.msscbrewery.services.v2;

import com.bytesbanana.msscbrewery.web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {

    BeerDtoV2 getBeerById(UUID beerId);

    BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto);

    void updateBeer(BeerDtoV2 beerDto);

    void deleteBeer(String beerId);
}
