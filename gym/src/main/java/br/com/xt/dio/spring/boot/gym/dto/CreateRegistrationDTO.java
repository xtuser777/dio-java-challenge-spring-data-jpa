package br.com.xt.dio.spring.boot.gym.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRegistrationDTO {

    @Positive(message = "O Id do aluno precisa ser positivo.")
    @Min(value = 1, message = "O Id do aluno de ser maior ou igual a 1")
    private Long studentId;

}
