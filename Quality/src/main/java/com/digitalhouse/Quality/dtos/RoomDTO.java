package com.digitalhouse.Quality.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor

public class RoomDTO {
    @NotNull(message = "É necessário informar o nome do quarto!")
    @Pattern(regexp = "^([A-Z])(([A-Za-z1-9\\s])*)",message = "O nome do cômodo deve começar com uma letra maiúscula.")
    @Size(max = 30, message = "O comprimento do cômodo não pode exceder 30 caracteres.")
    private String roomName;
    @NotNull(message = "A largura do cômodo não pode estar vazia.")
    @Max(value = 25, message = "A largura máxima permitida por cômodo é de 25 metros")
    @Min(value = 1, message = "Informe uma medida válida!")
    private Double roomWidth;
    @NotNull(message = "O comprimento do cômodo não pode estar vazio.")
    @Max(value = 33, message = "O comprimento máximo permitido por cômodo é de 33 metros.")
    @Min(value = 1, message = "Informe uma medida válida!")
    private Double roomLength;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomDTO roomDTO = (RoomDTO) o;
        return Objects.equals(roomName, roomDTO.roomName) && Objects.equals(roomWidth, roomDTO.roomWidth) && Objects.equals(roomLength, roomDTO.roomLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomName, roomWidth, roomLength);
    }
}
