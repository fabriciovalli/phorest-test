package com.fabriciovalli.phorest.application.service;

import java.util.List;

import com.fabriciovalli.phorest.application.exception.BusinessException;
import com.fabriciovalli.phorest.application.model.Client;

/**
 * IClientService
 */
public interface IClientService {

  List<Client> findClient(String email, String phone) throws BusinessException;

}