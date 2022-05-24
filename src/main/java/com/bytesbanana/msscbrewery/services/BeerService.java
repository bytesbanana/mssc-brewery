package com.bytesbanana.msscbrewery.services;

import com.bytesbanana.msscbrewery.web.model.BeerDto;

import java.util.UUID;


@Deprecated
public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    void updateBeer(BeerDto beerDto);

    void deleteBeer(String beerId);
}
