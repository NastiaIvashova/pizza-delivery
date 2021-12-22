package edu.kpi.iasa.mmsa.pizzadelivery.repository;

import edu.kpi.iasa.mmsa.pizzadelivery.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long>
{

}
