package com.oguzhankaratas.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2


@Entity
@Table(name= "categories")
// Categories(1) - Blog(N)
public class CategoryEntity implements Serializable {

    public static final Long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", unique = true, nullable = false,insertable = true, updatable = false)
    private Long categoryId;

    @Column(name = "category_name", length = 500, columnDefinition = "varchar(500) default 'java'")
    private String categoryName;


    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemDate;

}
