package com.dronebuzzers.parts.service.api;

import org.springframework.stereotype.Controller;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-03-14T21:15:28.475Z")

@Controller
public class PartApiController implements PartApi {

    private final PartApiDelegate delegate;

    @org.springframework.beans.factory.annotation.Autowired
    public PartApiController(PartApiDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public PartApiDelegate getDelegate() {
        return delegate;
    }
}
