package br.com.xt.dio.spring.boot.gym.repository;

import br.com.xt.dio.spring.boot.gym.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
