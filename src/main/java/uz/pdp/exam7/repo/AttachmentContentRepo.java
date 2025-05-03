package uz.pdp.exam7.repo;

import jakarta.persistence.EntityManager;
import uz.pdp.exam7.entity.AttachmentContent;

import static uz.pdp.exam7.config.MyListener.EMF;

public class AttachmentContentRepo{

    public static AttachmentContent findByAttachmentId(Integer attachmentId) {
        try (
                EntityManager entityManager = EMF.createEntityManager();
        ) {
            return entityManager.createQuery("from AttachmentContent where attachment.id = :attachmentId", AttachmentContent.class)
                    .setParameter("attachmentId", attachmentId).
                    getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
