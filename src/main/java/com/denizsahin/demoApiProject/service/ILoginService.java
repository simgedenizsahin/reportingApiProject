package com.denizsahin.demoApiProject.service;

import com.denizsahin.demoApiProject.model.RequestLogin;
import com.denizsahin.demoApiProject.model.ResponseLogin;

public interface ILoginService {
    public ResponseLogin saveToken(RequestLogin user);
}
