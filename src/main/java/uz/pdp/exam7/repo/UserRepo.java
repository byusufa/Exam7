package uz.pdp.exam7.repo;

import jakarta.persistence.EntityManager;
import uz.pdp.exam7.entity.User;

import static uz.pdp.exam7.config.MyListener.EMF;

public class UserRepo extends BaseRepo<User> {

        public boolean existsByEmail(String email) {
            try (EntityManager entityManager = EMF.createEntityManager()) {
                Long count = entityManager.createQuery(
                                "SELECT COUNT(u) FROM User u WHERE u.email = :email", Long.class)
                        .setParameter("email", email)
                        .getSingleResult();
                return count > 0;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

}
