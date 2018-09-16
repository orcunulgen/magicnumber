package com.bilyoner.magicnumber.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder(builderMethodName = "create")
@AllArgsConstructor
@Document(collection = "number")
public class MagicNumber {

    @Id
    private String id;
    @Indexed(unique = true)
    private Long number;
    private Date createDate;

    public MagicNumber() {
        super();
    }
}
