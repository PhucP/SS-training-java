package phucnh.qlbh.service;

import java.util.List;
import java.util.Optional;

import phucnh.qlbh.model.dto.CreateContactDTO;
import phucnh.qlbh.model.dto.UpdateContactDTO;
import phucnh.qlbh.model.entity.Contact;

public interface ContactService {
    Contact create(CreateContactDTO dto);
    Contact update(Long id, UpdateContactDTO dto);
    void delete(Long id);
    Optional<Contact> findById(Long id);
    List<Contact> findAll();
}
