package com.mutant.demo.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBDocument
@DynamoDBTable(tableName = "geneticData")
public class GeneticData {

    @DynamoDBHashKey(attributeName = "dna")
    public String dna;

    @DynamoDBAttribute(attributeName = "mutant")
    public String response;
}
