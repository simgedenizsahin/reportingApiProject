package com.denizsahin.demoApiProject.controller.impl;

import com.denizsahin.demoApiProject.controller.ILoginController;
import com.denizsahin.demoApiProject.controller.RestBaseController;
import com.denizsahin.demoApiProject.controller.RootEntity;
import com.denizsahin.demoApiProject.model.RequestLogin;
import com.denizsahin.demoApiProject.model.ResponseLogin;
import com.denizsahin.demoApiProject.service.impl.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/merchant")
public class LoginController extends RestBaseController implements ILoginController {

    @Autowired
    private LoginService apiService;

    @PostMapping("/login")
    public RootEntity<ResponseLogin> saveToken(@Valid @RequestBody RequestLogin user) {
        return ok(apiService.saveToken(user));

    }
}
