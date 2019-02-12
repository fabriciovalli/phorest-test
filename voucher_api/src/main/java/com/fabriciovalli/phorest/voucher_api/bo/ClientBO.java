package com.fabriciovalli.phorest.voucher_api.bo;

import com.fabriciovalli.phorest.voucher_api.api.PhorestClient;
import com.fabriciovalli.phorest.voucher_api.exception.BusinessException;
import com.fabriciovalli.phorest.voucher_api.model.SearchClientResponse;
import com.fabriciovalli.phorest.voucher_api.model.SearchResult;
import com.fabriciovalli.phorest.voucher_api.service.IClientService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * ClientBO
 */
@Component
public class ClientBO implements IClientService {

  @Override
  public SearchResult findClient(String email, String phone) throws BusinessException {
    // TODO: this could go to a Repository Interface to better decouple
    // Moving it to a repository, would allow to easily change how to search for
    // clients (API, database..)
    PhorestClient phorestClient = new PhorestClient();

    ResponseEntity<SearchClientResponse> response = phorestClient.searchClients(email, phone);
    if (response.getStatusCodeValue() != 200) {
      throw new BusinessException("Something went wrong");
    }
    SearchResult result = new SearchResult();
    result.setClients(response.getBody().getEmbedded().getClients());

    return result;
  }
}