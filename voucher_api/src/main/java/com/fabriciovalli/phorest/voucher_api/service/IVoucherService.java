package com.fabriciovalli.phorest.voucher_api.service;

import com.fabriciovalli.phorest.voucher_api.exception.BusinessException;
import com.fabriciovalli.phorest.voucher_api.model.Voucher;

/**
 * IVoucherService
 */
public interface IVoucherService {

  Voucher createVoucher(Voucher voucher) throws BusinessException;

}