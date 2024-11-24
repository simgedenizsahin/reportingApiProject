package com.denizsahin.demoApiProject.controller.impl;

import com.denizsahin.demoApiProject.controller.RestBaseController;
import com.denizsahin.demoApiProject.controller.RootEntity;
import com.denizsahin.demoApiProject.model.RequestList;
import com.denizsahin.demoApiProject.model.ResponseList;
import com.denizsahin.demoApiProject.service.IListService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/transaction")
public class ListController extends RestBaseController{

    @Autowired
    private IListService listService;

    @PostMapping("/list")
    public RootEntity<ResponseList> saveList(@Valid @RequestBody RequestList list) {
        return ok(listService.saveList(list));

    }
}
