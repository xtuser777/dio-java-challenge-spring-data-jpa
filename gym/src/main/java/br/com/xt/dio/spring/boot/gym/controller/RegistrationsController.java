package br.com.xt.dio.spring.boot.gym.controller;

import br.com.xt.dio.spring.boot.gym.dto.CreateRegistrationDTO;
import br.com.xt.dio.spring.boot.gym.entity.Registration;
import br.com.xt.dio.spring.boot.gym.service.IRegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registrations")
public class RegistrationsController {

    @Autowired
    private IRegistrationService service;

    @GetMapping
    public List<Registration> index(
            @RequestParam(value = "neighborhood", required = false) String neighborhood
    ) {
        return service.getAll(neighborhood);
    }

    @GetMapping("/{id}")
    public Registration show(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Registration create(@Valid @RequestBody CreateRegistrationDTO form) {
        return service.create(form);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
