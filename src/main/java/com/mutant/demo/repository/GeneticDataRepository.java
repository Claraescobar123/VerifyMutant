package com.mutant.demo.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.mutant.demo.entity.GeneticData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GeneticDataRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public static String dna;

    //Guarda en la tabla geneticData el response del post
    public GeneticData save(GeneticData DnaBody){
        dynamoDBMapper.save(DnaBody);
        return DnaBody;
    }

    //Trae toda la data de la tabla geneticData
    public List<GeneticData> getDnaMutant(){
        return dynamoDBMapper.scan(GeneticData.class, new DynamoDBScanExpression());
    }

}
