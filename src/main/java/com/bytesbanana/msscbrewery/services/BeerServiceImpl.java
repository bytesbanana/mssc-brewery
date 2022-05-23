package com.bytesbanana.msscbrewery.services;

import com.bytesbanana.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("LEO")
                .beerStyle("Lager")
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {

        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerStyle(beerDto.getBeerStyle())
                .beerName(beerDto.getBeerName())
                .build();
    }

    @Override
    public void updateBeer(BeerDto beerDto) {

        BeerDto.builder()
                .beerName(beerDto.getBeerName())
                .beerStyle(beerDto.getBeerStyle())
                .id(UUID.randomUUID())
                .build();

    }

    @Override
    public void deleteBeer(String beerId) {
        log.debug(beerId);
    }


}
