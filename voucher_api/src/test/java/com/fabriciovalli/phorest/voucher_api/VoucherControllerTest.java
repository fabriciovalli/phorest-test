package com.fabriciovalli.phorest.voucher_api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.fabriciovalli.phorest.voucher_api.controller.VoucherController;
import com.fabriciovalli.phorest.voucher_api.model.Voucher;
import com.fabriciovalli.phorest.voucher_api.service.IVoucherService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * VoucherControllerTest
 */
@RunWith(SpringRunner.class)
@WebMvcTest(VoucherController.class)
public class VoucherControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private IVoucherService service;

  @Test
  public void testPostVoucher_withSuccess() throws Exception {

    Voucher voucher = new Voucher();

    voucher.setIssueDate(LocalDateTime.now().toString());
    voucher.setExpiryDate(LocalDateTime.now().plus(1, ChronoUnit.DAYS).toString());
    voucher.setOriginalBalance(50.0);
    voucher.setCreatingBranchId("1234");
    voucher.setClientId("5678");
    voucher.setSerialNumber("12345");

    when(service.createVoucher(voucher)).thenReturn(voucher);

    mockMvc.perform(post("/voucher").contentType(TestUtil.APPLICATION_JSON_UTF8)
        .content(TestUtil.convertObjectToJsonBytes(voucher)));
    // .andExpect(status().isCreated()).andExpect(jsonPath("$..clientId",
    // is(voucher.getClientId())))
    // .andExpect(jsonPath("$..originalBalance", is(voucher.getOriginalBalance())))
    // .andExpect(jsonPath("$..serialNumber", is(voucher.getSerialNumber())));

    verify(service, times(1)).createVoucher(refEq(voucher));

  }

  @Test
  public void testPostVoucher_withMissingData() throws Exception {
    Voucher voucher = new Voucher();

    voucher.setIssueDate(LocalDateTime.now().toString());
    voucher.setExpiryDate(LocalDateTime.now().plus(1, ChronoUnit.DAYS).toString());
    voucher.setOriginalBalance(50.0);
    voucher.setCreatingBranchId("1234");
    voucher.setClientId("5678");

    when(service.createVoucher(voucher)).thenReturn(voucher);

    mockMvc.perform(post("/voucher")).andExpect(status().isBadRequest());

  }

}