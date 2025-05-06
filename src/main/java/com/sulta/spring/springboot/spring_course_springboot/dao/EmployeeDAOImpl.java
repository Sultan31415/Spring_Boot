package com.sulta.spring.springboot.spring_course_springboot.dao;

import com.sulta.spring.springboot.spring_course_springboot.entity.Employee;
import jakarta.persistence.EntityManager;
//import org.hibernate.Session;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {


    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {

       // Session session = entityManager.unwrap(Session.class);

      //  List<Employee>  allEmployees = session.createQuery("from Employee", Employee.class).getResultList();

        Query query = entityManager.createQuery("from Employee");
        List<Employee>  allEmployees  = query.getResultList();

        return allEmployees;

    }

    @Override
    public Employee getEmployeeById(int id) {
       // Session session = entityManager.unwrap(Session.class);

        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee);

       Employee employee1 =  entityManager.merge(employee);
       employee.setId(employee1.getId());

    }



    @Override
    public void deleteEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Employee employee = session.get(Employee.class, id);
//        session.delete(employee);
        Query query = entityManager.createQuery("delete from Employee where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();

    }
}
