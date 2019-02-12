package com.fabriciovalli.phorest.application.api;

import com.fabriciovalli.phorest.application.exception.BusinessException;
import com.fabriciovalli.phorest.application.model.ClientResponse;
import com.fabriciovalli.phorest.application.model.Voucher;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * VoucherApi
 */
public class VoucherApi {

  private static final String URL = "http://localhost:8080/";

  public ResponseEntity<ClientResponse> searchClients(String email, String phone) {
    RestTemplate restTemplate = new RestTemplate();
    String uri = getURL() + "/client";
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri);
    if (email != null) {
      builder.queryParam("email", email);
    }
    if (phone != null) {
      builder.queryParam("phone", phone);
    }

    return restTemplate.getForEntity(builder.toUriString(), ClientResponse.class);
  }

  public ResponseEntity<Voucher> createVoucher(Voucher voucher) throws BusinessException {
    RestTemplate restTemplate = new RestTemplate();
    String uri = getURL() + "/voucher";
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri);
    if (voucher == null) {
      throw new BusinessException("Voucher information can not be null");
    }
    HttpEntity<?> entity = new HttpEntity<>(voucher);
    return restTemplate.postForEntity(builder.toUriString(), entity, Voucher.class);
  }

  /**
   * Returns the target URL
   *
   * @return target URL
   */
  public String getURL() {
    return URL;
  }

}