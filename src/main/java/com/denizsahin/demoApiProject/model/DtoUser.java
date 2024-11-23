package com.denizsahin.demoApiProject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DtoUser {

    private String nameSurname;
    private String username;
    private String password;
}
