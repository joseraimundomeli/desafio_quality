package com.digitalhouse.Quality.dtos;


import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PropertyDTO {
    @NotNull(message = "É necessário informar o nome da propriedade!")
    @Size(max = 30, message = "O comprimento do nome não pode exceder 30 caracteres.")
    @Pattern(regexp = "^([A-Z])(([A-Za-z1-9\\s])*)",message = "O nome da propriedade deve começar com uma letra maiúscula.")
    private String propName;
    @NotNull(message = "O bairro não pode estar vazio.")
    @Size(max = 45, message = "O comprimento do bairro não pode exceder 45 caracteres.")
    private String propDistrict;
    @Valid
    @NotNull(message = "O campo não pode estar vazio.")
    private List<RoomDTO> roons;
}
