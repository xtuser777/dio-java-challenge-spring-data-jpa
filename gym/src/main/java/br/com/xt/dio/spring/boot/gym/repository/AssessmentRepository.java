package br.com.xt.dio.spring.boot.gym.repository;

import br.com.xt.dio.spring.boot.gym.entity.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
}
