package uz.pdp.exam7.repo;

import jakarta.persistence.EntityManager;
import uz.pdp.exam7.entity.Attachment;
import uz.pdp.exam7.entity.AttachmentContent;

import static uz.pdp.exam7.config.MyListener.EMF;

public class AttachmentRepo {

    public static Attachment saveFile(String submittedFileName, byte[] bytes) {
        try (
                EntityManager entityManager = EMF.createEntityManager();
        ) {
            Attachment attachment = new Attachment(
                    submittedFileName
            );

            AttachmentContent attachmentContent = new AttachmentContent(attachment, bytes);
            entityManager.getTransaction().begin();
            entityManager.persist(attachment);
            entityManager.persist(attachmentContent);
            entityManager.getTransaction().commit();
            return attachment;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
