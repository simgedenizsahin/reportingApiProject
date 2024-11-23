package com.denizsahin.demoApiProject.controller;

import com.denizsahin.demoApiProject.model.RequestList;
import com.denizsahin.demoApiProject.model.ResponseList;
import org.springframework.http.ResponseEntity;

public interface IListController {
    public RootEntity<ResponseList> saveList(RequestList list);
}
