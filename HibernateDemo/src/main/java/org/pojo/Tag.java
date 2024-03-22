package org.pojo;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Tag {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Basic
    @Column(name = "tagcol", nullable = true, length = 45)
    private String tagcol;
    @OneToMany(mappedBy = "tagByTagId")
    private Collection<ProdTag> prodTagsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagcol() {
        return tagcol;
    }

    public void setTagcol(String tagcol) {
        this.tagcol = tagcol;
    }

    public Collection<ProdTag> getProdTagsById() {
        return prodTagsById;
    }

    public void setProdTagsById(Collection<ProdTag> prodTagsById) {
        this.prodTagsById = prodTagsById;
    }
}
