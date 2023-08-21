package Modelos;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class ApiWolframAlpha {

	public String obtenerInformacion(String query) {
        String apiKey = "77GU7W-U3K597X4T3";  
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://api.wolframalpha.com/v1/query?&appid="+apiKey+"&input="+query+"&format=image,plaintext&output=JSON&lang=es"))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            int moneda = responseBody.indexOf("\"title\":\"Result\"");
            int posInicialMoneda = responseBody.indexOf("plaintext", moneda);
            int posFinalMoneda = responseBody.indexOf(")", posInicialMoneda);
            String valorMoneda = responseBody.substring(posInicialMoneda+12, posFinalMoneda+1);
            System.out.println(valorMoneda);
            return valorMoneda;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
