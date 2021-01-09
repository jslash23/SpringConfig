package com.lesson4.ex1.models;


import javax.persistence.*;

@Entity
@Table(name = "FILEN")
public class File {
    private long id;
    private String name;
    private String format;
    private long size;
    private Storage storage;


    //Use allocation OneToMany with using generics
    //One storage for many files
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn (name = "STORAGE_FK") //we take fk from DB (columns)
    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    //Field id

    @Id
    @SequenceGenerator(name = "FILE_SEQ", sequenceName = "FILE_SEQ_DB", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FILE_SEQ")

    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "NAME_FILE")

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "FORMAT_FILE")

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Column(name = "SIZE_FILE")

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }



    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", format='" + format + '\'' +
                ", size=" + size +
                ", storage=" + storage +
                '}';
    }
}
