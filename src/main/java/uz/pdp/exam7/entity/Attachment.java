package uz.pdp.exam7.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.exam7.abs.BaseEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Attachment extends BaseEntity {
    private String name;
}
