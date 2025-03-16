package bookmarker.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "bookmarks")
@AllArgsConstructor
@NoArgsConstructor
public class Bookmark {

    @Id
    @SequenceGenerator(name="bm_id_seq_gen", sequenceName="bm_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="bm_id_seq_gen")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String url;

    private Instant createdAt;
}
