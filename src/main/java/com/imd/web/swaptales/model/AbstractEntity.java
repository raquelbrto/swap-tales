package com.imd.web.swaptales.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
@Data
public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(
            nullable = true,
            updatable = false,
            name = "CREATION_DATE"
    )
    @CreatedDate
    @DateTimeFormat(
            pattern = "yyyy-MM-dd"
    )
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate = new Date();

    @LastModifiedDate
    @DateTimeFormat(
            pattern = "yyyy-MM-dd"
    )
    @Temporal(TemporalType.TIMESTAMP)
    @Column(
            name = "MODIFICATION_DATE"
    )
    private Date modificationDate;

    @Column
    private Boolean active = true;

    public AbstractEntity() {
    }
}