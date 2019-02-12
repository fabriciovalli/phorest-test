package com.fabriciovalli.phorest.voucher_api.bo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import com.fabriciovalli.phorest.voucher_api.api.PhorestClient;
import com.fabriciovalli.phorest.voucher_api.exception.BusinessException;
import com.fabriciovalli.phorest.voucher_api.model.Voucher;
import com.fabriciovalli.phorest.voucher_api.service.IVoucherService;

@Component
public class VoucherBO implements IVoucherService {

	@Override
	public Voucher createVoucher(Voucher voucher) throws BusinessException {
		// TODO: this could go to a Repository Interface to better decouple
		// Moving it to a repository, would allow to easily change how to generate
		// vouchers
		PhorestClient phorestClient = new PhorestClient();

		if (voucher == null) {
			throw new BusinessException("Voucher information can not be null");
		}

		if (voucher.getClientId() == null) {
			throw new BusinessException("Client ID must be informed");
		}

		try {
			ResponseEntity<Voucher> response = phorestClient.createVoucher(voucher);
			return response.getBody();
		} catch (RestClientException rce) {
			throw rce;
		}
	}

}
