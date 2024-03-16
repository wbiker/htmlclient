package org.htmlclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class Html {
    String url = "http://0.0.0.0:8080/clicks"; // Replace with your endpoint URL
    String requestBody = """
                [{"timestamp": "2005-01-24", "action": "Open Calculator", "calculator": "AtBruttoNetto", "domain": "master.atikon.com", "name": "", "value": ""},
                {"timestamp": "2015-10-13", "action": "Select", "calculator": "AtBruttoNetto", "domain": "master.atikon.com", "name": "Auswahl Jahre", "value": 2023},
                {"timestamp": "2024-03-13", "action": "Select", "calculator": "AtBruttoNetto", "domain": "master.atikon.com", "name": "Auswahl Vertrag", "value": "Dienstnehmer"}]
                """;


    public void sendRequest() {
        try {
            // Create HttpClient
            HttpClient httpClient = HttpClient.newBuilder().build();

            // Create HttpRequest with POST method and request body
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .header("Content-Type", "application/json") // Adjust content type if necessary
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody, StandardCharsets.UTF_8))
                    .build();

            // Send the request and retrieve the response
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Print response status code and body
            System.out.println("Response Status Code: " + response.statusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}