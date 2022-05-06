package com.mutant.demo.controller;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.mutant.demo.model.DnaBody;
import com.mutant.demo.repository.GeneticDataRepository;
import com.mutant.demo.service.IsMutantService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    private IsMutantService mutantService;

    @Autowired
    private GeneticDataRepository geneticDataRepository;

    //Hace el Post de los adn enviados por medio del body y verifica que sea humano o mutante,
    //asi mismo guarda ese response en la tabla geneticData que esta en DynamoDB
    @PostMapping("/mutant")
    public String obtenerMutante(@RequestBody DnaBody body){
        return mutantService.detectMutant(body.getDna());
    }

    //Obtiene las estadisticas del API
    @GetMapping("/stats")
    public String getData() throws JSONException {
       return mutantService.statsService();
    }

}
