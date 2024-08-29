import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.security.spec.ECFieldF2m;

import javax.management.RuntimeErrorException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Consulta {
    

    public Endereco BuscarEndereço(String cep){
        URI endereco = URI.create( "https://viacep.com.br/ws/"  + cep + "/json");


        HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
            .uri(endereco)
            .build();
            
            try {
                HttpResponse<String> response = HttpClient
                .newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
                return new Gson().fromJson(response.body(), Endereco.class);
            } catch (Exception e) {
                throw new RuntimeException("nao foi possivel encontrar o endereço.");
            }
    
            
    }

   
    
}
