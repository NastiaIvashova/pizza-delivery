package edu.kpi.iasa.mmsa.pizzadelivery.service;

import edu.kpi.iasa.mmsa.pizzadelivery.exception.StatusNotFoundException;
import edu.kpi.iasa.mmsa.pizzadelivery.exception.UserRoleNotFoundException;
import edu.kpi.iasa.mmsa.pizzadelivery.model.Status;
import edu.kpi.iasa.mmsa.pizzadelivery.model.UserRole;
import edu.kpi.iasa.mmsa.pizzadelivery.repository.UserRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserRoleService
{
    private final UserRoleRepository userRoleRepository;

    public UserRoleService(UserRoleRepository userRoleRepository)
    {
        this.userRoleRepository = userRoleRepository;
    }

    public List<UserRole> getUserRoles()
    {
        return userRoleRepository.findAll();
    }

    public UserRole saveUserRole(UserRole newUserRole)
    {
        return userRoleRepository.save(newUserRole);
    }

    public UserRole getUserRoleById(Long iduser_role)
    {
        Optional<UserRole> userRole = userRoleRepository.findById(iduser_role);
        if (userRole.isPresent())
        {
            log.info("user-role: {}", userRole.get());
            return userRole.get();
        }
        throw new UserRoleNotFoundException();
    }

    public UserRole updateUserRoleById(Long iduser_role, UserRole updatedUserRole)
    {
        Optional<UserRole> userRole = userRoleRepository.findById(iduser_role);
        if (userRole.isPresent()) {
            UserRole oldUserRole = userRole.get();
            log.info("user-role: {}", oldUserRole);
            updateUserRole(oldUserRole, updatedUserRole);
            return userRoleRepository.save(oldUserRole);
        }
        throw new UserRoleNotFoundException();
    }

    private void updateUserRole(UserRole oldUserRole, UserRole updatedUserRole)
    {
        oldUserRole.setFuserId(updatedUserRole.getFuserId());
        oldUserRole.setFroleId(updatedUserRole.getFroleId());
    }

    public String deleteUserRoleById(Long iduser_role)
    {
        userRoleRepository.deleteById(iduser_role);
        return "User was deleted, so role was deleted for her(him)!";
    }
}
