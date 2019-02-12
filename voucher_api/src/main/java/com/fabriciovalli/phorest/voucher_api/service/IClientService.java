package com.fabriciovalli.phorest.voucher_api.service;

import com.fabriciovalli.phorest.voucher_api.exception.BusinessException;
import com.fabriciovalli.phorest.voucher_api.model.SearchResult;

/**
 * IClientService
 */
public interface IClientService {

  SearchResult findClient(String email, String phone) throws BusinessException;

}