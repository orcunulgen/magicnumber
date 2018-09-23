package com.bilyoner.magicnumber.service;

import com.bilyoner.magicnumber.dto.MagicNumber;
import com.bilyoner.magicnumber.repository.MagicNumberRepository;
import com.bilyoner.magicnumber.repository.impl.MagicNumberCustomRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MagicNumberService {

    @Autowired
    MagicNumberRepository magicNumberRepository;

    @Autowired
    MagicNumberCustomRepositoryImpl magicNumberCustomRepositoryImpl;

    public void save(MagicNumber magicNumber) {
        magicNumber.setCreateDate(new Date());
        magicNumberRepository.save(magicNumber);
    }

    public MagicNumber findByNumber(Long number) {
        return magicNumberRepository.findByNumber(number);
    }

    public MagicNumber findMinOrMaxNumber(boolean findMinimum) {
        return magicNumberCustomRepositoryImpl.findMagicNumber(findMinimum);
    }

    public boolean deleteNumber(Long number) {
        return magicNumberRepository.deleteByNumber(number) == 1L ? true : false;
    }

    public List<MagicNumber> getAllNumbers(String field, String direction) {
        Optional<Sort.Direction> orderOpt = Sort.Direction.fromOptionalString(direction);

        if (orderOpt.isPresent())
            return magicNumberRepository.findAll(Sort.by(orderOpt.get(), field));
        else
            return new ArrayList<>();

    }
}