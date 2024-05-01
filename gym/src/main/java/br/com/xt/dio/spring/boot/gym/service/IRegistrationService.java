package br.com.xt.dio.spring.boot.gym.service;

import br.com.xt.dio.spring.boot.gym.dto.CreateRegistrationDTO;
import br.com.xt.dio.spring.boot.gym.entity.Registration;

import java.util.List;

public interface IRegistrationService {

    Registration create(CreateRegistrationDTO dto);

    Registration getById(Long id);

    List<Registration> getAll(String neighborhood);

    void delete(Long id);

}
