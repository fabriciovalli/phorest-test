package com.fabriciovalli.phorest.application.bo;

import java.util.List;

import com.fabriciovalli.phorest.application.api.VoucherApi;
import com.fabriciovalli.phorest.application.exception.BusinessException;
import com.fabriciovalli.phorest.application.model.Client;
import com.fabriciovalli.phorest.application.model.ClientResponse;
import com.fabriciovalli.phorest.application.service.IClientService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * ClientBO
 */
@Component
public class ClientBO implements IClientService {

  @Override
  public List<Client> findClient(String email, String phone) throws BusinessException {
    // TODO: this could go to a Repository Interface to better decouple
    // Moving it to a repository, would allow to easily change how to search for
    // clients (API, database..)
    VoucherApi voucherApi = new VoucherApi();

    ResponseEntity<ClientResponse> response = voucherApi.searchClients(email, phone);
    if (response.getStatusCodeValue() != 200) {
      throw new BusinessException("Something went wrong");
    }
    List<Client> clients = response.getBody().getClients();

    return clients;
  }
}