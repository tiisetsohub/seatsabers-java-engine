package co.za.entelect.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import static co.za.entelect.constants.WhatsappConstants.ACCESS_TOKEN;

@Service
public class UtilService {

    public HttpHeaders generateHeader(String token) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setBearerAuth(token);
        return httpHeaders;
    }

    public HttpHeaders generateWhatsappHeader() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setBearerAuth(ACCESS_TOKEN);
        return httpHeaders;
    }

    public HttpEntity<String> generateEntity(String body, String token) {
        HttpHeaders httpHeaders = generateHeader(token);
        HttpEntity<String> entity = new HttpEntity<>(body, httpHeaders);
        return entity;
    }

    public HttpEntity<String> generateEntity(String token) {
        HttpHeaders httpHeaders = generateHeader(token);
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return entity;
    }

    public HttpEntity<String> generateWhatsappEntity(String body) {
        HttpHeaders httpHeaders = generateWhatsappHeader();
        HttpEntity<String> entity = new HttpEntity<>(body, httpHeaders);
        return entity;
    }

}
