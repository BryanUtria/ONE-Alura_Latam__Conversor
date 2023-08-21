package Modelos;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class ApiConversionMoneda {

	public String obtenerTasaDeCambioMoneda() {
        String apiKey = "cur_live_FLCz7BYoHo75Rbe2QSTQjeFHFYsAqY2MDm6jasF2";  
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.currencyapi.com/v3/latest?base=USD&apikey=" + apiKey))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            System.out.println(responseBody);
            return responseBody;
            //int moneda = responseBody.indexOf("\"COP\":");
            //int posInicialMoneda = responseBody.indexOf("value", moneda);
            //int posFinalMoneda = responseBody.indexOf("}", posInicialMoneda);
            //String valorMoneda = responseBody.substring(posInicialMoneda+7, posFinalMoneda);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
