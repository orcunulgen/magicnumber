package com.bilyoner.magicnumber.repository.impl;

import com.bilyoner.magicnumber.dto.MagicNumber;
import com.bilyoner.magicnumber.repository.MagicNumberCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.LimitOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.stereotype.Component;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Component
public class MagicNumberCustomRepositoryImpl implements MagicNumberCustomRepository {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public MagicNumberCustomRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public MagicNumber findMagicNumber(boolean findMinimum) {
        SortOperation sortByNumber = sort(new Sort(findMinimum ? Sort.Direction.ASC : Sort.Direction.DESC, "number"));
        LimitOperation limitOperation = limit(1);
        Aggregation aggregation = newAggregation(sortByNumber, limitOperation);
        AggregationResults<MagicNumber> result = mongoTemplate.aggregate(
                aggregation, "number", MagicNumber.class);
        return result.getUniqueMappedResult();
    }
}
