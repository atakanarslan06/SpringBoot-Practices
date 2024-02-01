package com.DataJPA.dto;

import com.DataJPA.entity.Adress;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String  name;
    private String  username;
    private List<String> adresses;
}
