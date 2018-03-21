package com.dronebuzzers.parts.service.model;

import java.util.Objects;
import com.dronebuzzers.parts.service.model.OrderLine;
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
 * Order
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-03-19T20:22:45.205Z")

public class Order   {
  @JsonProperty("clientId")
  private String clientId = null;

  @JsonProperty("clientReference")
  private String clientReference = null;

  @JsonProperty("dbOrderNumber")
  private String dbOrderNumber = null;

  @JsonProperty("orderLines")
  @Valid
  private List<OrderLine> orderLines = new ArrayList<>();

  public Order clientId(String clientId) {
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

  public Order clientReference(String clientReference) {
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

  public Order dbOrderNumber(String dbOrderNumber) {
    this.dbOrderNumber = dbOrderNumber;
    return this;
  }

   /**
   * Get dbOrderNumber
   * @return dbOrderNumber
  **/
  @ApiModelProperty(value = "")


  public String getDbOrderNumber() {
    return dbOrderNumber;
  }

  public void setDbOrderNumber(String dbOrderNumber) {
    this.dbOrderNumber = dbOrderNumber;
  }

  public Order orderLines(List<OrderLine> orderLines) {
    this.orderLines = orderLines;
    return this;
  }

  public Order addOrderLinesItem(OrderLine orderLinesItem) {
    this.orderLines.add(orderLinesItem);
    return this;
  }

   /**
   * Get orderLines
   * @return orderLines
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<OrderLine> getOrderLines() {
    return orderLines;
  }

  public void setOrderLines(List<OrderLine> orderLines) {
    this.orderLines = orderLines;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Order order = (Order) o;
    return Objects.equals(this.clientId, order.clientId) &&
        Objects.equals(this.clientReference, order.clientReference) &&
        Objects.equals(this.dbOrderNumber, order.dbOrderNumber) &&
        Objects.equals(this.orderLines, order.orderLines);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, clientReference, dbOrderNumber, orderLines);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");
    
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    clientReference: ").append(toIndentedString(clientReference)).append("\n");
    sb.append("    dbOrderNumber: ").append(toIndentedString(dbOrderNumber)).append("\n");
    sb.append("    orderLines: ").append(toIndentedString(orderLines)).append("\n");
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

