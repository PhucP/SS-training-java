package phucnh.qlbh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import phucnh.qlbh.model.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
