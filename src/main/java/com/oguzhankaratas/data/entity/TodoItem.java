package com.oguzhankaratas.data.entity;

import com.oguzhankaratas.assist.Status;
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
@Table(name = "todo_item")
public class TodoItem implements Serializable {

    public static final Long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, insertable = true, updatable = false)
    private Long id;

    @Column(name = "description")
    private String description;
    @Column(name = "header", length = 256, columnDefinition = "varchar(500) default 'java'")
    private String header;


    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemDate;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Status status=Status.IN_PROGRESS;

}
