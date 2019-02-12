package com.fabriciovalli.phorest.voucher_api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ClientResponse
 */
public class SearchResult {

  @JsonProperty("clients")
  private List<Client> clients;

  @JsonProperty("clients")
  public List<Client> getClients() {
    return clients;
  }

  @JsonProperty("clients")
  public void setClients(List<Client> clients) {
    this.clients = clients;
  }

}