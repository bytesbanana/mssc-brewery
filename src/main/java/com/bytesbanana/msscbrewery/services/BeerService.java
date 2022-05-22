package com.bytesbanana.msscbrewery.services;

import com.bytesbanana.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);
}
