package br.com.xt.dio.spring.boot.gym.repository;

import br.com.xt.dio.spring.boot.gym.entity.Assessment;
import br.com.xt.dio.spring.boot.gym.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    @Query(
        value = "SELECT * FROM registrations m " +
                "INNER JOIN students s ON m.student_id = s.id " +
                "INNER JOIN addresses a ON s.address_id = a.id " +
                "WHERE a.neighborhood = :neighborhood",
        nativeQuery = true
    )
    //@Query("FROM Matricula m WHERE m.aluno.bairro = :bairro ")
    List<Assessment> findStudentsByNeighborhood(String neighborhood);

    //List<Matricula> findByAlunoBairro(String bairro);

}
