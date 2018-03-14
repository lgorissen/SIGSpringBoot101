package com.dronebuzzers.helloworld.service.api;

import com.dronebuzzers.helloworld.service.model.InventoryItem;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * A delegate to be called by the {@link InventoryApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-03-11T08:33:19.057Z")

public interface InventoryApiDelegate {

    /**
     * @see InventoryApi#addInventory
     */
    ResponseEntity<Void> addInventory(InventoryItem inventoryItem);

    /**
     * @see InventoryApi#searchInventory
     */
    ResponseEntity<List<InventoryItem>> searchInventory(String searchString,
        Integer skip,
        Integer limit);

}
