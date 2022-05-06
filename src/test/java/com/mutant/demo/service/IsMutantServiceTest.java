package com.mutant.demo.service;

import com.mutant.demo.entity.GeneticData;
import com.mutant.demo.model.DnaBody;
import com.mutant.demo.repository.GeneticDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class IsMutantServiceTest {

    @Mock
    GeneticDataRepository geneticDataRepository;

    @Mock
    private static GeneticData data;

    @InjectMocks
    private IsMutantService isMutantService;

    @Mock
    private static DnaBody body;


    @BeforeEach
    void setUp() {
        data = new GeneticData();
        /*MockitoAnnotations.openMocks(this);

        body = new DnaBody();
        body.setDna(new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"});*/
    }

    @Test
    void isDiagonalMutant() {

        //String diagonalMutant = isMutantService.detectMutant(new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"});


        /*when(isMutantService.detectMutant(body.getDna())).thenReturn(body.toString());

        when(isMutantService.detectMutant(body.getDna())).thenReturn(Arrays.toString(new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"}))
                .thenReturn(Arrays.toString(new String[]{"PTGCPA", "CAGTGC", "TTATGT", "AGAAGG", "CCCPTA", "TCACTG"}));*/

    }
}