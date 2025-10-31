package com.esp.area.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AreaDtoCrear(
        @NotNull
        @Size(min = 1, max = 150)
        String nombreArea){

}