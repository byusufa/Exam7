package uz.pdp.exam7.repo;

import jakarta.persistence.EntityManager;
import uz.pdp.exam7.entity.Post;

import java.util.List;

import static uz.pdp.exam7.config.MyListener.EMF;

public class PostRepo extends BaseRepo<Post> {

    public List<Post> findAllByLatest() {

        try (
                EntityManager entityManager = EMF.createEntityManager();

        ) {
            return entityManager.createQuery("SELECT p FROM Post p ORDER BY p.createdAt DESC", Post.class)
                    .getResultList(); 
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Post findById(Integer id) {
        try (
                EntityManager entityManager = EMF.createEntityManager();
        ) {
            return entityManager.createQuery("SELECT p FROM Post p WHERE p.id =: id", Post.class)
                    .setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
