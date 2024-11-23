package com.denizsahin.demoApiProject.service;

import com.denizsahin.demoApiProject.model.RequestList;
import com.denizsahin.demoApiProject.model.ResponseList;

public interface IListService {
    public ResponseList saveList(RequestList listRequest);
}
