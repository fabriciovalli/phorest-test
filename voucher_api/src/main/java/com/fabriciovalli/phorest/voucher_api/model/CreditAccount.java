
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
@JsonPropertyOrder({ "creditDays", "creditLimit" })
public class CreditAccount {

    @JsonProperty("creditDays")
    private Integer creditDays;
    @JsonProperty("creditLimit")
    private Integer creditLimit;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("creditDays")
    public Integer getCreditDays() {
        return creditDays;
    }

    @JsonProperty("creditDays")
    public void setCreditDays(Integer creditDays) {
        this.creditDays = creditDays;
    }

    @JsonProperty("creditLimit")
    public Integer getCreditLimit() {
        return creditLimit;
    }

    @JsonProperty("creditLimit")
    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
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
        return new ToStringBuilder(this).append("creditDays", creditDays).append("creditLimit", creditLimit)
                .append("additionalProperties", additionalProperties).toString();
    }

}
