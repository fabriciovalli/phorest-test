package com.fabriciovalli.phorest.voucher_api.api;

import java.nio.charset.Charset;

import com.fabriciovalli.phorest.voucher_api.exception.BusinessException;
import com.fabriciovalli.phorest.voucher_api.model.SearchClientResponse;
import com.fabriciovalli.phorest.voucher_api.model.Voucher;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * PhorestApi
 */
public class PhorestClient {
	private static final String USER = "global/cloud@apiexamples.com";
	private static final String PSWD = "VMlRo/eh+Xd8M~l";
	private static final String URL = "http://api-gateway-dev.phorest.com/third-party-api-server/api/business/";
	private static final String BUSINES_ID = "eTC3QY5W3p_HmGHezKfxJw";

	public ResponseEntity<SearchClientResponse> searchClients(String email, String phone) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = getURL() + BUSINES_ID + "/client";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri);
		if (email != null) {
			builder.queryParam("email", email);
		}
		if (phone != null) {
			builder.queryParam("phone", phone);
		}
		HttpEntity<?> entity = new HttpEntity<>(createHeaders(USER, PSWD));
		return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, SearchClientResponse.class);
	}

	public ResponseEntity<Voucher> createVoucher(Voucher voucher) throws BusinessException {
		RestTemplate restTemplate = new RestTemplate();
		String uri = getURL() + BUSINES_ID + "/voucher";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri);
		if (voucher == null) {
			throw new BusinessException("Voucher information can not be null");
		}

		HttpEntity<?> entity = new HttpEntity<>(voucher, createHeaders(USER, PSWD));
		return restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, Voucher.class);
	}

	HttpHeaders createHeaders(String username, String password) {
		return new HttpHeaders() {
			private static final long serialVersionUID = 1L;

			{
				String auth = username + ":" + password;
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("UTF-8")));
				String authHeader = "Basic " + new String(encodedAuth);
				set("Authorization", authHeader);
			}
		};
	}

	/**
	 * Returns the target URL
	 *
	 * @return target URL
	 */
	public String getURL() {
		return URL;
	}

	// public static void main(String[] args) {
	// PhorestClient pc = new PhorestClient();
	// ResponseEntity<String> s = pc.searchClients(null, "11085034143845",
	// String.class);
	// ResponseEntity<ClientRespose> s =
	// pc.searchClients("0.111085034143845@example.com", null);
	// SE-J0emUgQnya14mOGdQSw

	// System.out.println(s.getBody());
	// }

}