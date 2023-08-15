package com.gmltest.services;

import com.gmltest.datamodel.Pokemon;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author plinio
 */
@Component
public class Repositorio {

    public Pokemon getTestRepositorio() throws IOException {
        Pokemon pokemonTest = new Pokemon();
        pokemonTest.setName("pokemonTestName");
        pokemonTest.setUrl("http://url-de-prueba");
        return pokemonTest;
    }

    public List<Pokemon> getPokemonList(int limit, int offset) throws IOException {
            PokemonService pokemonService = PokemonService.getInstance();
            return pokemonService.getPokemonList(limit, offset);
        } 
    
        
}
