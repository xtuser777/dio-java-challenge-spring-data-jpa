package br.com.xt.dio.spring.boot.gym.service;

import br.com.xt.dio.spring.boot.gym.dto.CreateStudentDTO;
import br.com.xt.dio.spring.boot.gym.dto.UpdateStudentDTO;
import br.com.xt.dio.spring.boot.gym.entity.Address;
import br.com.xt.dio.spring.boot.gym.entity.Assessment;
import br.com.xt.dio.spring.boot.gym.entity.Contact;
import br.com.xt.dio.spring.boot.gym.entity.Student;
import br.com.xt.dio.spring.boot.gym.repository.AddressRepository;
import br.com.xt.dio.spring.boot.gym.repository.ContactRepository;
import br.com.xt.dio.spring.boot.gym.repository.StudentRepository;
import br.com.xt.dio.spring.boot.gym.util.JavaTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Student create(CreateStudentDTO dto) {
        var student = this.convert(dto);

        return this.studentRepository.save(student);
    }

    @Override
    public Student getById(Long id) {
        var student = this.studentRepository.findById(id);
        if (student == null) {
            throw new RuntimeException("Student not found");
        } else return student;
    }

    @Override
    public List<Student> getAll(String dataDeNascimento) {
        if (dataDeNascimento == null) {
            return this.studentRepository.findAll();
        } else {
            LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
            return this.studentRepository.findByBirthDate(localDate);
        }
    }

    @Override
    public Student update(Long id, UpdateStudentDTO dto) {
        var student = this.getById(id);
        student = this.convert(dto, student);

        return this.studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        var student = this.getById(id);
        this.studentRepository.delete(student);
    }

    @Override
    public List<Assessment> getAllAssessmentsByStudentId(Long id) {
        var student = this.getById(id);
        return student.getAssessments();
    }

    private Student convert(CreateStudentDTO dto) {
        Address address = new Address(
            0L,
            dto.getAddressStreet(),
            dto.getAddressNumber(),
            dto.getAddressNeighborhood(),
            dto.getAddressCity(),
            dto.getAddressState()
        );
        address = addressRepository.save(address);
        Contact contact = new Contact(
                0L,
                dto.getPhone(),
                dto.getCellphone(),
                dto.getEmail()
        );
        contact = contactRepository.save(contact);
        Student student = new Student();
        student.setId(0L);
        student.setName(dto.getName());
        student.setDocument(dto.getDocument());
        student.setBirthDate(dto.getBirthDate());
        student.setAddress(address);
        student.setContact(contact);

        return student;
    }

    private Student convert(UpdateStudentDTO dto, Student student) {
        student.setName(dto.getName());
        student.setBirthDate(dto.getBirthDate());
        student.getContact().setPhone(dto.getPhone());
        student.getContact().setCellphone(dto.getCellphone());
        student.getContact().setEmail(dto.getEmail());
        student.getAddress().setStreet(dto.getAddressStreet());
        student.getAddress().setNumber(dto.getAddressNumber());
        student.getAddress().setNeighborhood(dto.getAddressNeighborhood());
        student.getAddress().setCity(dto.getAddressCity());
        student.getAddress().setState(dto.getAddressState());

        return student;
    }
}
