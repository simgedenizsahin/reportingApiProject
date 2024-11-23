package com.denizsahin.demoApiProject.controller.impl;

import com.denizsahin.demoApiProject.controller.IClientController;
import com.denizsahin.demoApiProject.controller.RestBaseController;
import com.denizsahin.demoApiProject.controller.RootEntity;
import com.denizsahin.demoApiProject.model.RequestClient;
import com.denizsahin.demoApiProject.model.ResponseClient;
import com.denizsahin.demoApiProject.service.IClientService;
import com.denizsahin.demoApiProject.service.impl.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/client")
public class ClientController extends RestBaseController implements IClientController {

    @Autowired
    private IClientService clientService;

    @PostMapping("/save")
    public RootEntity<ResponseClient> saveClient(@Valid @RequestBody RequestClient list) {
        return ok(clientService.saveClient(list));

    }
}
