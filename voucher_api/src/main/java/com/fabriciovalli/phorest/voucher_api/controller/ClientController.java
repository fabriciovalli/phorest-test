package com.fabriciovalli.phorest.voucher_api.controller;

import com.fabriciovalli.phorest.voucher_api.exception.BusinessException;
import com.fabriciovalli.phorest.voucher_api.model.SearchResult;
import com.fabriciovalli.phorest.voucher_api.service.IClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * ClientController
 */
@RestController
public class ClientController {

  @Autowired
  private IClientService service;

  @GetMapping(name = "/client")
  public ResponseEntity<SearchResult> getClient(@RequestParam(value = "email", required = false) String email,
      @RequestParam(value = "phone", required = false) String phone,
      @RequestParam(value = "firstName", required = false) String firstName,
      @RequestParam(value = "lastName", required = false) String lastName,
      @RequestParam(value = "size", required = false) String size,
      @RequestParam(value = "page", required = false) String page) {
    try {
      return ResponseEntity.ok().body(service.findClient(email, phone));
    } catch (BusinessException be) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, be.getMessage());
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }

}