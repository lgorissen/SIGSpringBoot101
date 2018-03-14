package com.dronebuzzers.helloworld.service.api;

import com.dronebuzzers.helloworld.service.model.InventoryItem;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-03-11T08:33:19.057Z")

@Controller
public class InventoryApiController implements InventoryApi {

    private final InventoryApiDelegate delegate;

    @org.springframework.beans.factory.annotation.Autowired
    public InventoryApiController(InventoryApiDelegate delegate) {
        this.delegate = delegate;
    }
    public ResponseEntity<Void> addInventory(@ApiParam(value = "Inventory item to add"  )  @Valid @RequestBody InventoryItem inventoryItem) {
        return delegate.addInventory(inventoryItem);
    }

    public ResponseEntity<List<InventoryItem>> searchInventory(@ApiParam(value = "pass an optional search string for looking up inventory") @Valid @RequestParam(value = "searchString", required = false) String searchString,@Min(0)@ApiParam(value = "number of records to skip for pagination") @Valid @RequestParam(value = "skip", required = false) Integer skip,@Min(0) @Max(50) @ApiParam(value = "maximum number of records to return") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        return delegate.searchInventory(searchString, skip, limit);
    }

}
