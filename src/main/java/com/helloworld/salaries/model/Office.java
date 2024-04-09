package com.helloworld.salaries.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class Office {
    @Schema(description = "Identificador de oficina")
    private Integer id;

    @Schema(description = "Nombre de la oficina")
    private String name;

    @Schema(description = "Ciudad de la oficina")
    private String city;

    @Schema(description = "Código postal de la oficina")
    private String postalCode;

    @Schema(
            description = "Código de País",
            allowableValues = {"ES", "MX"},
            example = "ES: España - MX: México"
    )
    private String country_code;

    @Schema(
            description = "Es sede principal",
            allowableValues = {"true", "false"},
            example = "Valor "
    )
    private Boolean headquarter;

    @Schema(description = "Continente de la oficina")

    private String continent;

    @Schema(description = "Oficina madre de la que depende esta oficina" )
    private Integer region_Office_Id;
}