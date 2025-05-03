package uz.pdp.exam7.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import uz.pdp.exam7.abs.BaseEntity;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comments")
@ToString(exclude = {"post", "user"})
public class Comment extends BaseEntity {
    @ManyToOne
    private Post post;

    @ManyToOne
    private User user;

    private String content;
}

