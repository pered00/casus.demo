package casus.casus.demo.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="document_tbl")
public class Document {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    @NotNull
    private String licPlate;

    @Lob
    public byte[] content;

    @OneToOne(mappedBy = "document")
    Vehicle vehicle;
}
