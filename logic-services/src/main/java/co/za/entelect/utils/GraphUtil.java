package co.za.entelect.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;


@Service
public class GraphUtil {
    public HttpHeaders generateHeader(String accessToken){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setBearerAuth(accessToken);
        return httpHeaders;
    }

    public HttpEntity<String> generateEntity(String accessToken){
        HttpHeaders httpHeaders = generateHeader(accessToken);
        return new HttpEntity<>(httpHeaders);
    }

    public HttpEntity<String> generateEntity(String body, String accessToken){
        HttpHeaders httpHeaders = generateHeader(accessToken);
        return new HttpEntity<>(body, httpHeaders);
    }

}
