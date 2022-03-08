
package com.janawat.ecommerce;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestConsumer {


    RestTemplate restTemplate;

    public RestConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <T, R extends JsonConvertible> ResponseEntity<T> postWithToken(String url, String token, R requestObject, Class<T> responseClass) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(HttpHeaders.AUTHORIZATION, token);
        HttpEntity<String> request = new HttpEntity<>(requestObject.toJsonString(), headers);

        return restTemplate.postForEntity(url, request, responseClass);
    }

    public <T, R extends JsonConvertible> ResponseEntity<T>
    getWithToken(String url, String token, Class<T> responseClass) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, token);
        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), responseClass);
    }

    public <T, R extends JsonConvertible> ResponseEntity<T> putWithToken(
            String url, String token, R requestObject, Class<T> responseClass) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(HttpHeaders.AUTHORIZATION, token);
        HttpEntity<String> request = new HttpEntity<>(requestObject.toJsonString(), headers);

        return  restTemplate.exchange(url, HttpMethod.PUT, request, responseClass);
    }


}
