package com.bytesbanana.msscbrewery.services.v2;

import com.bytesbanana.msscbrewery.web.model.BeerDto;
import com.bytesbanana.msscbrewery.web.model.v2.BeerDtoV2;
import com.bytesbanana.msscbrewery.web.model.v2.BeerStylesEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .beerName("LEO")
                .beerStyle(BeerStylesEnum.PALE_EL)
                .build();
    }

    @Override
    public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {

        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .beerStyle(beerDto.getBeerStyle())
                .beerName(beerDto.getBeerName())
                .build();
    }

    @Override
    public void updateBeer(BeerDtoV2 beerDto) {

        BeerDtoV2.builder()
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
