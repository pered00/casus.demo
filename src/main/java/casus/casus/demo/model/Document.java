package casus.casus.demo.model;

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
    private Long Id;

    @Lob
    public byte[] content;
}
