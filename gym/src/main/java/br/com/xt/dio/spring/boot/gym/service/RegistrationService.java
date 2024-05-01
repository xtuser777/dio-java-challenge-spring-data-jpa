package br.com.xt.dio.spring.boot.gym.service;

import br.com.xt.dio.spring.boot.gym.dto.CreateRegistrationDTO;
import br.com.xt.dio.spring.boot.gym.entity.Registration;
import br.com.xt.dio.spring.boot.gym.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService implements IRegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private IStudentService studentService;

    @Override
    public Registration create(CreateRegistrationDTO dto) {
        var registration = convert(dto);

        return registrationRepository.save(registration);
    }

    @Override
    public Registration getById(Long id) {
        var registration = registrationRepository.findById(id).orElse(null);
        if (registration == null) {
            throw new RuntimeException("Registration not found");
        } else return registration;
    }

    @Override
    public List<Registration> getAll(String neighborhood) {
        return registrationRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        var registration = getById(id);
        registrationRepository.delete(registration);
    }

    private Registration convert(CreateRegistrationDTO dto) {
        var registration = new Registration();
        var student = studentService.getById(dto.getStudentId());
        registration.setStudent(student);

        return registration;
    }
}
