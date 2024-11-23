package com.denizsahin.demoApiProject.model;

import lombok.Data;

import java.util.List;

@Data
public class ResponseList {
    private Integer per_page;
    private Integer current_page;
    private String next_page_url;
    private String first_page_url;
    private String path;
    private String prev_page_url;
    private Integer from;
    private Integer to;
    private List<DtoData> data;
}
