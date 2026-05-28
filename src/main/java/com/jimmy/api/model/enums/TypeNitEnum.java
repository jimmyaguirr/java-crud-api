package com.jimmy.api.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeNitEnum  {
    CC("Cedula de ciudadania",1),
    TI("Tarje de identidad",2),
    CE("Cedula de extranjeria",3),
    PAS("pasaporte",4);

    private final String label;
    private  final Integer value;
}
