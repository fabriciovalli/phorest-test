package com.fabriciovalli.phorest.application.bo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.fabriciovalli.phorest.application.api.VoucherApi;
import com.fabriciovalli.phorest.application.exception.BusinessException;
import com.fabriciovalli.phorest.application.model.Voucher;
import com.fabriciovalli.phorest.application.service.IVoucherService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

@Component
public class VoucherBO implements IVoucherService {

	private static final String BRANCH_ID = "SE-J0emUgQnya14mOGdQSw";

	@Override
	public Voucher createVoucher(Voucher voucher) throws BusinessException {
		// TODO: this could go to a Repository Interface to better decouple
		// Moving it to a repository, would allow to easily change how to generate
		// vouchers
		VoucherApi voucherApi = new VoucherApi();

		if (voucher == null) {
			throw new BusinessException("Voucher information can not be null");
		}

		if (voucher.getClientId() == null) {
			throw new BusinessException("Client ID must be informed");
		}

		voucher.setIssueDate(LocalDateTime.now().toString());
		voucher.setExpiryDate(LocalDateTime.now().plus(1, ChronoUnit.DAYS).toString());
		voucher.setOriginalBalance(50.0);
		voucher.setCreatingBranchId(BRANCH_ID);

		try {
			ResponseEntity<Voucher> response = voucherApi.createVoucher(voucher);
			return response.getBody();
		} catch (RestClientException rce) {
			throw rce;
		}
	}

}
