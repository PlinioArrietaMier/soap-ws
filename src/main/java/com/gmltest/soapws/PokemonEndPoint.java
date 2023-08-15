
package com.gmltest.soapws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.gmltest.generated.GetPokemonRequest;
import com.gmltest.generated.GetPokemonResponse;
import com.gmltest.services.Repositorio;

/**
 *
 * @author plinio
 */

@Endpoint
public class PokemonEndPoint {
    private static final String NAMESPACE_URI = "http://localhost:9090/pokemon";
    
    private Repositorio repositorio;
    
    @Autowired
    public PokemonEndPoint( Repositorio repositorio ) {
        this.repositorio = repositorio;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetPokemonRequest")
    @ResponsePayload
    public GetPokemonResponse getPokemon(@RequestPayload GetPokemonRequest request) {
        GetPokemonResponse response = new GetPokemonResponse();
        response.setCountry(repositorio.findCountry(request.getName()));

        return response;
    }    
}
