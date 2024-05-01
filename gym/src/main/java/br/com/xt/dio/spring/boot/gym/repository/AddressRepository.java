package br.com.xt.dio.spring.boot.gym.repository;

import br.com.xt.dio.spring.boot.gym.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
