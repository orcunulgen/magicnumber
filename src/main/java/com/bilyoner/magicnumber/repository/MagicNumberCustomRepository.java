package com.bilyoner.magicnumber.repository;

import com.bilyoner.magicnumber.dto.MagicNumber;

public interface MagicNumberCustomRepository {

    MagicNumber findMagicNumber(boolean findMinimum);
}
