package com.mutant.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class DnaBody {
    public String[] dna;

    public DnaBody(){
    }

    public DnaBody(String[] dna){
        this.dna = dna;
    }

}
