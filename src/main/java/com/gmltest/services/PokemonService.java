package com.gmltest.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmltest.datamodel.Pokemon;
import com.gmltest.datamodel.PokemonResponse;
import java.io.IOException;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 * @author plinio
 */
public class PokemonService {
    private static final String BASE_URL = "https://pokeapi.co/api/v2/pokemon";
    private OkHttpClient httpClient;
    private ObjectMapper objectMapper;

    private static PokemonService instance;

    private PokemonService() {
        httpClient = new OkHttpClient();
        objectMapper = new ObjectMapper();
    }

    public static PokemonService getInstance() {
        if (instance == null) {
            instance = new PokemonService();
        }
        return instance;
    }

    public List<Pokemon> getPokemonList(int limit, int offset) throws IOException {
        String url = BASE_URL + "?limit=" + limit + "&offset=" + offset;
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = httpClient.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Error: " + response);
        }

        PokemonResponse pokemonResponse = objectMapper.readValue(response.body().string(), PokemonResponse.class);
        return pokemonResponse.getResults();
    }
}
