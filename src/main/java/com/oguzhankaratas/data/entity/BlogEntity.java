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

// entityler tablo olduğu için burada table ile isimlendirdik.
@Entity
@Table(name= "blogs")
//Blog(N) - Categories(1)
public class BlogEntity implements Serializable {

    public static final Long SerialVersionUID = 1L;

    @Id  //burada sınıftaki id yi belirtmek zorundayız
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Her id nin otomatik olarak artmasını sağlar.
    @Column(name = "blog_id", unique = true, nullable = false,insertable = true, updatable = false)
    private Long blogId;

    @Column(name = "header", length = 500, columnDefinition = "varchar(500) default 'başlık yazılmadı...'")
    private String header;

    @Lob // Büyük veriler için kullanılır.
    private String content;

    @CreationTimestamp // kendisi otomatik ekler.
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemDate;

    /* Database olmasın sadece javada olsun
    @Transient
    private String justJava;

     */
}
