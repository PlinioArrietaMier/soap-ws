
package com.gmltest.soapws;

import com.gmltest.datamodel.Pokemon;
import com.gmltest.services.PokemonService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author plinio
 */
@WebService
public class PokemonSOAPService {
    @WebMethod
    public List<Pokemon> getPokemonList(int limit, int offset) throws IOException {
        PokemonService pokemonService = PokemonService.getInstance();
        return pokemonService.getPokemonList(limit, offset);
    }
}
