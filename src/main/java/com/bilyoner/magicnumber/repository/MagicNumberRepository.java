package com.bilyoner.magicnumber.repository;

import com.bilyoner.magicnumber.dto.MagicNumber;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MagicNumberRepository extends MongoRepository<MagicNumber, String> {

    MagicNumber findByNumber(Long number);

    Long deleteByNumber(Long number);
}
