package com.fabriciovalli.phorest.application.service;

import com.fabriciovalli.phorest.application.exception.BusinessException;
import com.fabriciovalli.phorest.application.model.Voucher;

/**
 * IVoucherService
 */
public interface IVoucherService {

  Voucher createVoucher(Voucher voucher) throws BusinessException;

}