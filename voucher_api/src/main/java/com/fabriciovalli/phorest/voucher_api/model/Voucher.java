package com.fabriciovalli.phorest.voucher_api.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Voucher
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "voucherId", "serialNumber", "issueDate", "expiryDate", "clientId", "creatingBranchId",
    "originalBalance", "remainingBalance" })
public class Voucher {
  
  
  @JsonProperty("voucherId")
  private String voucherId;
  @JsonProperty("serialNumber")
  private String serialNumber;
  @JsonProperty("issueDate")
  private String issueDate;
  @JsonProperty("expiryDate")
  private String expiryDate;
  @JsonProperty("clientId")
  private String clientId;
  @JsonProperty("creatingBranchId")
  private String creatingBranchId;
  @JsonProperty("originalBalance")
  private Double originalBalance;
  @JsonProperty("remainingBalance")
  private Double remainingBalance;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("voucherId")
  public String getVoucherId() {
    return voucherId;
  }

  @JsonProperty("voucherId")
  public void setVoucherId(String voucherId) {
    this.voucherId = voucherId;
  }

  @JsonProperty("serialNumber")
  public String getSerialNumber() {
    return serialNumber;
  }

  @JsonProperty("serialNumber")
  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  @JsonProperty("issueDate")
  public String getIssueDate() {
    return issueDate;
  }

  @JsonProperty("issueDate")
  public void setIssueDate(String issueDate) {
    this.issueDate = issueDate;
  }

  @JsonProperty("expiryDate")
  public String getExpiryDate() {
    return expiryDate;
  }

  @JsonProperty("expiryDate")
  public void setExpiryDate(String expiryDate) {
    this.expiryDate = expiryDate;
  }

  @JsonProperty("clientId")
  public String getClientId() {
    return clientId;
  }

  @JsonProperty("clientId")
  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  @JsonProperty("creatingBranchId")
  public String getCreatingBranchId() {
    return creatingBranchId;
  }

  @JsonProperty("creatingBranchId")
  public void setCreatingBranchId(String creatingBranchId) {
    this.creatingBranchId = creatingBranchId;
  }

  @JsonProperty("originalBalance")
  public Double getOriginalBalance() {
    return originalBalance;
  }

  @JsonProperty("originalBalance")
  public void setOriginalBalance(Double originalBalance) {
    this.originalBalance = originalBalance;
  }

  @JsonProperty("remainingBalance")
  public Double getRemainingBalance() {
    return remainingBalance;
  }

  @JsonProperty("remainingBalance")
  public void setRemainingBalance(Double remainingBalance) {
    this.remainingBalance = remainingBalance;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append("voucherId", voucherId).append("serialNumber", serialNumber)
        .append("issueDate", issueDate).append("expiryDate", expiryDate).append("clientId", clientId)
        .append("creatingBranchId", creatingBranchId).append("originalBalance", originalBalance)
        .append("remainingBalance", remainingBalance).append("additionalProperties", additionalProperties).toString();
  }

}