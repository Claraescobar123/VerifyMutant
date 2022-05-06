package com.mutant.demo.service;

import com.mutant.demo.entity.GeneticData;
import com.mutant.demo.repository.GeneticDataRepository;

import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class IsMutantService {

    @Autowired
    GeneticDataRepository geneticDataRepository;

    public static String dnaData;
    public static String message;

    private static final Logger logger = LoggerFactory.getLogger(IsMutantService.class);


    public String detectMutant(String[] dnaB){
        //Convierte a Array el adn que recibe por parametro
        String[][] convertToArray = Arrays.stream(dnaB).map(data -> data.split("")).toArray(String[][]::new);
        //Si cumple con las condiciones de que se repitan 4 letras diagonal, horizontal o vertical es mutante
        if(isRowMutant(convertToArray) || isColumnMutant(convertToArray) || isDiagonalMutant(convertToArray)){
            message = "It's a Mutant, Status: " + HttpStatus.SC_OK + " OK";
            //De lo contrario es humano
        }else{
            message = "Sorry, Status: " + HttpStatus.SC_FORBIDDEN + " Forbidden";
        }
        //Asi mismo el adn que recibe por parametro y el mensaje que arroja se lo manda a la función sendData
        dnaData = Arrays.toString(dnaB);
        sendData(dnaData, message);
        return message;

    }

    public void sendData(String dnaData, String verifyMutant ){
        //Guarda la información en la tabla
        GeneticData newData = new GeneticData(dnaData,verifyMutant);
        geneticDataRepository.save(newData);
    }

    public String statsService() throws JSONException {
        //estadisticas de la API
        List<GeneticData> allData = geneticDataRepository.getDnaMutant();
        double countTotal = allData.size();
        int countMutant = 0;
        int countHuman = 0;
        double avgDnaMutant = 0;
        double avgDnaHuman = 0;
        for (GeneticData dnaMutant : allData) {
            if (dnaMutant.getResponse().contains("Mutant")) {
                countMutant += 1;
                avgDnaMutant = countMutant / countTotal;
            } else if (dnaMutant.getResponse().contains("Sorry")) {
                countHuman += 1;
                avgDnaHuman = countHuman/countTotal;
            }
        }
            String totalStats = "{ count_mutant_dna: " + countMutant + ",count_human_dna: " + countHuman
                        + ",avg_dna_mutant: " + avgDnaMutant + ",avg_dna_human: " + avgDnaHuman +  ",total_dna_analyzed : "
                        + countTotal + "}";

            JSONObject json = new JSONObject(totalStats);

        return json.toString();
    }


    public static boolean isRowMutant(String[][] values){
    //recorrer filas
        boolean mutantRow = false;
        for ( int i= 0; i < values.length; i++) {
            for (int j = 0; j < values.length-3; j++) {
                if (values[i][j].equals(values[i][j+1])&&
                        values[i][j].equals(values[i][j+2])&&
                        values[i][j].equals(values[i][j+3])
                ) {
                        mutantRow = true;
                        break;
                    }
                }
        }
        return mutantRow;
    }

    public static boolean isColumnMutant(String[][] values){
        //recorrer columnas
        boolean mutantColumn = false;
        for ( int i= 0; i < values.length; i++) {
            for (int j = 0; j < values.length-3; j++) {
                 if (values[j][i].equals(values[j+1][i])&&
                         values[j][i].equals(values[j+2][i])&&
                         values[j][i].equals(values[j+3][i])
                ){
                    mutantColumn = true;
                    break;
                }
            }
        }
        return mutantColumn;
    }


    public static boolean isDiagonalMutant(String[][] values){
        //recorrer diagonales
        boolean mutantDiagonal = false;
        for ( int i= 0; i < values.length-3; i++) {
            for (int j = 0; j < values.length-3; j++) {

                    if(values[i][j].equals(values[i+1][j+1])&&
                            values[i][j].equals(values[i+2][j+2])&&
                            values[i][j].equals(values[i+3][j+3])){

                        mutantDiagonal = true;
                        break;

                    }else if(values[i][values.length-1-j].equals(values[i+1][values.length-2-j])&&
                            values[i][values.length-1-j].equals(values[i+2][values.length-3-j])&&
                            values[i][values.length-1-j].equals(values[i+3][values.length-4-j])){

                            mutantDiagonal = true;
                            break;
                    }


            }
        }
        return mutantDiagonal;
    }

}
