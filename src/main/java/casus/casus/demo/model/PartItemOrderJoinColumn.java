package casus.casus.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PartItemOrderJoinColumn {
    //all attributes in PartItem ID are primary key
    @EmbeddedId
    private PartItemID id;
}
