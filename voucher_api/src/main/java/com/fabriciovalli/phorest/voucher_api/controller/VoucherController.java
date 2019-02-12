package com.fabriciovalli.phorest.voucher_api.controller;

import com.fabriciovalli.phorest.voucher_api.exception.BusinessException;
import com.fabriciovalli.phorest.voucher_api.model.Voucher;
import com.fabriciovalli.phorest.voucher_api.service.IVoucherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * VoucherController
 */
@RestController
public class VoucherController {

  // {
  // "voucherId": "6ggKPPfpCXfopji1RqpAjQ",
  // "serialNumber": "11220",
  // "issueDate": "2019-02-10T21:30:50.000Z",
  // "expiryDate": "2019-02-10T21:30:50.000Z",
  // "clientId": "G7cwfHokOtDorjqFMuI3tA",
  // "creatingBranchId": "SE-J0emUgQnya14mOGdQSw",
  // "originalBalance": 123.12,
  // "remainingBalance": 123.12
  // }

  @Autowired
  private IVoucherService service;

  @PostMapping(name = "/voucher")
  public ResponseEntity<Voucher> createVoucherForClient(@RequestBody Voucher voucher) {
    try {

      Voucher createdVoucher = service.createVoucher(voucher);

      return new ResponseEntity<Voucher>(createdVoucher, HttpStatus.CREATED);
    } catch (BusinessException be) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, be.getMessage());
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

  }
}