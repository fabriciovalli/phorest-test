
package com.fabriciovalli.phorest.voucher_api.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "clientId", "version", "firstName", "lastName", "mobile", "email", "address", "clientSince",
        "gender", "smsMarketingConsent", "emailMarketingConsent", "smsReminderConsent", "emailReminderConsent",
        "creditAccount", "creatingBranchId", "archived", "banned" })
public class Client {

    @JsonProperty("clientId")
    private String clientId;
    @JsonProperty("version")
    private Integer version;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("mobile")
    private String mobile;
    @JsonProperty("email")
    private String email;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("clientSince")
    private String clientSince;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("smsMarketingConsent")
    private Boolean smsMarketingConsent;
    @JsonProperty("emailMarketingConsent")
    private Boolean emailMarketingConsent;
    @JsonProperty("smsReminderConsent")
    private Boolean smsReminderConsent;
    @JsonProperty("emailReminderConsent")
    private Boolean emailReminderConsent;
    @JsonProperty("creditAccount")
    private CreditAccount creditAccount;
    @JsonProperty("creatingBranchId")
    private String creatingBranchId;
    @JsonProperty("archived")
    private Boolean archived;
    @JsonProperty("banned")
    private Boolean banned;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("clientId")
    public String getClientId() {
        return clientId;
    }

    @JsonProperty("clientId")
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @JsonProperty("version")
    public Integer getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(Integer version) {
        this.version = version;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("mobile")
    public String getMobile() {
        return mobile;
    }

    @JsonProperty("mobile")
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonProperty("clientSince")
    public String getClientSince() {
        return clientSince;
    }

    @JsonProperty("clientSince")
    public void setClientSince(String clientSince) {
        this.clientSince = clientSince;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("smsMarketingConsent")
    public Boolean getSmsMarketingConsent() {
        return smsMarketingConsent;
    }

    @JsonProperty("smsMarketingConsent")
    public void setSmsMarketingConsent(Boolean smsMarketingConsent) {
        this.smsMarketingConsent = smsMarketingConsent;
    }

    @JsonProperty("emailMarketingConsent")
    public Boolean getEmailMarketingConsent() {
        return emailMarketingConsent;
    }

    @JsonProperty("emailMarketingConsent")
    public void setEmailMarketingConsent(Boolean emailMarketingConsent) {
        this.emailMarketingConsent = emailMarketingConsent;
    }

    @JsonProperty("smsReminderConsent")
    public Boolean getSmsReminderConsent() {
        return smsReminderConsent;
    }

    @JsonProperty("smsReminderConsent")
    public void setSmsReminderConsent(Boolean smsReminderConsent) {
        this.smsReminderConsent = smsReminderConsent;
    }

    @JsonProperty("emailReminderConsent")
    public Boolean getEmailReminderConsent() {
        return emailReminderConsent;
    }

    @JsonProperty("emailReminderConsent")
    public void setEmailReminderConsent(Boolean emailReminderConsent) {
        this.emailReminderConsent = emailReminderConsent;
    }

    @JsonProperty("creditAccount")
    public CreditAccount getCreditAccount() {
        return creditAccount;
    }

    @JsonProperty("creditAccount")
    public void setCreditAccount(CreditAccount creditAccount) {
        this.creditAccount = creditAccount;
    }

    @JsonProperty("creatingBranchId")
    public String getCreatingBranchId() {
        return creatingBranchId;
    }

    @JsonProperty("creatingBranchId")
    public void setCreatingBranchId(String creatingBranchId) {
        this.creatingBranchId = creatingBranchId;
    }

    @JsonProperty("archived")
    public Boolean getArchived() {
        return archived;
    }

    @JsonProperty("archived")
    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    @JsonProperty("banned")
    public Boolean getBanned() {
        return banned;
    }

    @JsonProperty("banned")
    public void setBanned(Boolean banned) {
        this.banned = banned;
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
        return new ToStringBuilder(this).append("clientId", clientId).append("version", version)
                .append("firstName", firstName).append("lastName", lastName).append("mobile", mobile)
                .append("email", email).append("address", address).append("clientSince", clientSince)
                .append("gender", gender).append("smsMarketingConsent", smsMarketingConsent)
                .append("emailMarketingConsent", emailMarketingConsent).append("smsReminderConsent", smsReminderConsent)
                .append("emailReminderConsent", emailReminderConsent).append("creditAccount", creditAccount)
                .append("creatingBranchId", creatingBranchId).append("archived", archived).append("banned", banned)
                .append("additionalProperties", additionalProperties).toString();
    }

}
