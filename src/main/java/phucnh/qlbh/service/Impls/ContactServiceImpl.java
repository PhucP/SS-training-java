package phucnh.qlbh.service.Impls;

import java.util.List;
import java.util.Optional;

import phucnh.qlbh.exception.exceptions.NotFoundException;
import phucnh.qlbh.model.dto.CreateContactDTO;
import phucnh.qlbh.model.dto.UpdateContactDTO;
import phucnh.qlbh.model.entity.Contact;
import phucnh.qlbh.model.entity.Customer;
import phucnh.qlbh.repository.ContactRepository;
import phucnh.qlbh.service.ContactService;
import phucnh.qlbh.service.CustomerService;

public class ContactServiceImpl implements ContactService{
    private ContactRepository contactRepository;
    private CustomerService customerService;

    public ContactServiceImpl(ContactRepository contactRepository, CustomerService customerService) {
        this.contactRepository = contactRepository;
        this.customerService = customerService;
    }

    @Override
    public Contact create(CreateContactDTO dto) {
        Customer customer = customerService.findById(dto.getCustomerId()).orElse(null);
        if(customer == null) {
            throw new NotFoundException("can't create contact because of not found customer");
        }

        Contact contact = Contact.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .customer(customer)
                .build();


        return contactRepository.save(contact);
    }

    @Override
    public Contact update(Long id, UpdateContactDTO dto) {
        Customer customer = customerService.findById(dto.getCustomerId()).orElse(null);
        if(customer == null) {
            throw new NotFoundException("can't update contact because of not found customer");
        }
        Contact contact = findById(id).orElse(null);
        contact.setFirstName(dto.getFirstName());
        contact.setLastName(dto.getLastName());
        contact.setEmail(dto.getEmail());
        contact.setPhone(dto.getPhone());
        contact.setCustomer(customer);
        return contactRepository.save(contact);
    }

    @Override
    public void delete(Long id) {
        Contact contact = findById(id).orElse(null);
        contactRepository.delete(contact);
    }

    @Override
    public Optional<Contact> findById(Long id) {
        Optional<Contact> Contact = contactRepository.findById(id);
        if(Contact.orElse(null) == null) {
            throw new NotFoundException(Contact.class.getName() + " is not found with this id");
        }

        return Contact;
    }

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

}
