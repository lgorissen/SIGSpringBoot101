package com.dronebuzzers.parts.service.api;

import org.springframework.stereotype.Controller;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-03-19T20:22:45.205Z")

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
