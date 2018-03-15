package com.dronebuzzers.parts.service.model;

import java.util.Objects;
import com.dronebuzzers.parts.service.model.OrderSummaryLine;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * OrderSummary
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-03-14T21:15:28.475Z")

public class OrderSummary   {
  @JsonProperty("clientId")
  private String clientId = null;

  @JsonProperty("clientReference")
  private String clientReference = null;

  @JsonProperty("orderSummaryLines")
  @Valid
  private List<OrderSummaryLine> orderSummaryLines = new ArrayList<>();

  @JsonProperty("totalAmount")
  private Double totalAmount = null;

  public OrderSummary clientId(String clientId) {
    this.clientId = clientId;
    return this;
  }

   /**
   * Get clientId
   * @return clientId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public OrderSummary clientReference(String clientReference) {
    this.clientReference = clientReference;
    return this;
  }

   /**
   * Get clientReference
   * @return clientReference
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getClientReference() {
    return clientReference;
  }

  public void setClientReference(String clientReference) {
    this.clientReference = clientReference;
  }

  public OrderSummary orderSummaryLines(List<OrderSummaryLine> orderSummaryLines) {
    this.orderSummaryLines = orderSummaryLines;
    return this;
  }

  public OrderSummary addOrderSummaryLinesItem(OrderSummaryLine orderSummaryLinesItem) {
    this.orderSummaryLines.add(orderSummaryLinesItem);
    return this;
  }

   /**
   * Get orderSummaryLines
   * @return orderSummaryLines
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<OrderSummaryLine> getOrderSummaryLines() {
    return orderSummaryLines;
  }

  public void setOrderSummaryLines(List<OrderSummaryLine> orderSummaryLines) {
    this.orderSummaryLines = orderSummaryLines;
  }

  public OrderSummary totalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
    return this;
  }

   /**
   * Get totalAmount
   * @return totalAmount
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderSummary orderSummary = (OrderSummary) o;
    return Objects.equals(this.clientId, orderSummary.clientId) &&
        Objects.equals(this.clientReference, orderSummary.clientReference) &&
        Objects.equals(this.orderSummaryLines, orderSummary.orderSummaryLines) &&
        Objects.equals(this.totalAmount, orderSummary.totalAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, clientReference, orderSummaryLines, totalAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderSummary {\n");
    
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    clientReference: ").append(toIndentedString(clientReference)).append("\n");
    sb.append("    orderSummaryLines: ").append(toIndentedString(orderSummaryLines)).append("\n");
    sb.append("    totalAmount: ").append(toIndentedString(totalAmount)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

