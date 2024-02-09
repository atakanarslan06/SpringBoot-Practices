package com.springexamp.apidoc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Benim pet nesnem",description = "Kara Baş")
public class PetDto {
    @ApiModelProperty(value = "Pet nesnesinin tekil Id alani")
    private int id;
    @ApiModelProperty(value = "Pet nesnesinin adi alani")
    private String name;
    @ApiModelProperty(value = "Pet nesnesinin  tarih alani")
    private Date date;
}
