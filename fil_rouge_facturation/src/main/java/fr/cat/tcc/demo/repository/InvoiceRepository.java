package fr.cat.tcc.demo.repository;

import org.springframework.data.repository.CrudRepository;

import fr.cat.tcc.demo.entity.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

}
