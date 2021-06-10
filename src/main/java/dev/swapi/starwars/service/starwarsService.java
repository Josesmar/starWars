package dev.swapi.starwars.service;
import com.google.gson.Gson;
import dev.swapi.starwars.entity.Starwars;
import dev.swapi.starwars.utils.Utils;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class StarwarsService {
    static String webService = " https://swapi.dev/api/";
    static int codigoSucesso = 200;

    public static Starwars pesquisa(int valor) throws Exception {
        String urlAPI = null;
        JSONObject responseJson = null;

        if (valor == 1)
            urlAPI = webService + "starships/10/?format=json";
        else if (valor == 2)
            urlAPI = webService + "starships/?format=json";

        try {
            URL url = new URL(urlAPI);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != codigoSucesso)
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            Gson gson = new Gson();
            String jsonEmString = Utils.converteJsonEmString(resposta);
            Starwars starwars = gson.fromJson(jsonEmString, Starwars.class);

            return starwars;

        } catch (Exception e) {
            throw new Exception("Erro: " + e);
        }
    }
}

