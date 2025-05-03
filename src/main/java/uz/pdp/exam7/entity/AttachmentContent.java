package uz.pdp.exam7.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.exam7.abs.BaseEntity;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AttachmentContent extends BaseEntity {
    @ManyToOne
    private Attachment attachment;
    private byte[] content;
}
