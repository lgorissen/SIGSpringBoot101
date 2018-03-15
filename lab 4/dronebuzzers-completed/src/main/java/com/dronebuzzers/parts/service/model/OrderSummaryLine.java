package com.dronebuzzers.parts.service.model;

import java.util.Objects;
import com.dronebuzzers.parts.service.model.Part;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * OrderSummaryLine
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-03-14T21:15:28.475Z")

public class OrderSummaryLine   {
  @JsonProperty("count")
  private Integer count = null;

  @JsonProperty("part")
  private Part part = null;

  public OrderSummaryLine count(Integer count) {
    this.count = count;
    return this;
  }

   /**
   * Get count
   * @return count
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public OrderSummaryLine part(Part part) {
    this.part = part;
    return this;
  }

   /**
   * Get part
   * @return part
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Part getPart() {
    return part;
  }

  public void setPart(Part part) {
    this.part = part;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderSummaryLine orderSummaryLine = (OrderSummaryLine) o;
    return Objects.equals(this.count, orderSummaryLine.count) &&
        Objects.equals(this.part, orderSummaryLine.part);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, part);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderSummaryLine {\n");
    
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    part: ").append(toIndentedString(part)).append("\n");
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

