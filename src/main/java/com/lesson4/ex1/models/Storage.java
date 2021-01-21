package com.lesson4.ex1.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "STORAGE")
public class Storage {

    private long id;
    private String formatSupported;
    private String storageCountry;
    private long storageSize;
    private List<File>  files = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
            targetEntity = File.class, mappedBy = "storage")//another table(STORAGE_PR) can acces

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files)
    {
        this.files = files;
    }


    @Id
    @SequenceGenerator(name = "STOR_SEQ", sequenceName = "STOR_SEQ_DB", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STOR_SEQ")

    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "FORMAT_SUPPORTED")

    public String getFormatSupported() {
        return formatSupported;
    }

    public void setFormatSupported(String formatSupported) {
        this.formatSupported = formatSupported;
    }

    @Column(name = "STORAGE_COUNTRY")

    public String getStorageCountry() {
        return storageCountry;
    }

    public void setStorageCountry(String storageCountry) {
        this.storageCountry = storageCountry;
    }

    @Column(name = "STORAGE_SIZE")

    public long getStorageSize() {
        return storageSize;
    }


    public void setStorageSize(long storageSize) {
        this.storageSize = storageSize;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "id=" + id +
                ", formatSupported='" + formatSupported + '\'' +
                ", storageCountry='" + storageCountry + '\'' +
                ", storageSize=" + storageSize +
                ", files=" + files +
                '}';
    }
}
