package net.javaguide.springboot.repository;

import net.javaguide.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository --< JpaEntityType, primaryKeyDataType>
// When EmployeeRepository extends JpaRepository , employeeRopo gets all the CRUD methods to interact with the database

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
