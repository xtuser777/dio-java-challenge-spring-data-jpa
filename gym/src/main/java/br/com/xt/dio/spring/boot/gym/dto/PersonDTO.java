package br.com.xt.dio.spring.boot.gym.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    @NotEmpty(message = "Preencha o campo corretamente.")
    @Size(min = 3, max = 100, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String name;

    @NotNull(message = "Prencha o campo corretamente.")
    @Past(message = "Data '${validatedValue}' é inválida.")
    private LocalDate birthDate;

    @NotEmpty(message = "Preencha o campo corretamente.")
    @Size(min = 10, max = 14, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String phone;

    @NotEmpty(message = "Preencha o campo corretamente.")
    @Size(min = 11, max = 15, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String cellphone;

    @NotEmpty(message = "Preencha o campo corretamente.")
    @Size(min = 5, max = 100, message = "E-mail pode conter no máximo 100 caracteres.")
    @Email(message = "E-mail inválido.")
    private String email;

    @NotEmpty(message = "Preencha o campo corretamente.")
    @Size(min = 3, max = 100, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String addressStreet;

    @NotEmpty(message = "Preencha o campo corretamente.")
    @Size(min = 1, max = 5, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String addressNumber;

    @NotEmpty(message = "Preencha o campo corretamente.")
    @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String addressNeighborhood;

    @NotEmpty(message = "Preencha o campo corretamente.")
    @Size(min = 3, max = 100, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String addressCity;

    @NotEmpty(message = "Preencha o campo corretamente.")
    @Size(min = 2, max = 2, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String addressState;

}
