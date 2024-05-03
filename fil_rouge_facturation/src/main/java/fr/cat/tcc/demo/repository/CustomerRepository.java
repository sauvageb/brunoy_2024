package fr.cat.tcc.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import fr.cat.tcc.demo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
