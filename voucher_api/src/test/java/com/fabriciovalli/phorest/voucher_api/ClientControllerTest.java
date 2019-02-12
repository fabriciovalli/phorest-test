package com.fabriciovalli.phorest.voucher_api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.fabriciovalli.phorest.voucher_api.controller.ClientController;
import com.fabriciovalli.phorest.voucher_api.model.Client;
import com.fabriciovalli.phorest.voucher_api.model.SearchResult;
import com.fabriciovalli.phorest.voucher_api.service.IClientService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

/**
 * ClientControllerTest
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ClientController.class)
public class ClientControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private IClientService service;

  @Test
  public void testGetClient_withEmail() throws Exception {
    ObjectMapper mapper = new ObjectMapper();

    Client client = new Client();
    client.setClientId("12345");
    client.setFirstName("Fabricio");
    client.setLastName("Valli");
    client.setEmail("fabriciovalli@gmail.com");
    client.setMobile("0834567644");
    List<Client> clients = new ArrayList<>();
    clients.add(client);
    SearchResult result = new SearchResult();
    result.setClients(clients);
    when(service.findClient(client.getEmail(), null)).thenReturn(result);

    ResultActions resultActions = mockMvc.perform(get("/client?email=" + client.getEmail())).andExpect(status().isOk());

    SearchResult searchResult = mapper.readValue(resultActions.andReturn().getResponse().getContentAsString(),
        SearchResult.class);

    assertEquals(searchResult.getClients().size(), 1);
    assertEquals(client.getClientId(), searchResult.getClients().get(0).getClientId());
    assertEquals(client.getEmail(), searchResult.getClients().get(0).getEmail());

    verify(service, times(1)).findClient(client.getEmail(), null);

  }

  @Test
  public void testGetClient_withPhone() throws Exception {
    ObjectMapper mapper = new ObjectMapper();

    Client client = new Client();
    client.setClientId("12345");
    client.setFirstName("Fabricio");
    client.setLastName("Valli");
    client.setEmail("fabriciovalli@gmail.com");
    client.setMobile("0834567644");
    List<Client> clients = new ArrayList<>();
    clients.add(client);
    SearchResult result = new SearchResult();
    result.setClients(clients);
    when(service.findClient(null, client.getMobile())).thenReturn(result);

    ResultActions resultActions = mockMvc.perform(get("/client?phone=" + client.getMobile()))
        .andExpect(status().isOk());

    SearchResult searchResult = mapper.readValue(resultActions.andReturn().getResponse().getContentAsString(),
        SearchResult.class);

    assertEquals(searchResult.getClients().size(), 1);
    assertEquals(client.getClientId(), searchResult.getClients().get(0).getClientId());
    assertEquals(client.getMobile(), searchResult.getClients().get(0).getMobile());

    verify(service, times(1)).findClient(null, client.getMobile());

  }
}