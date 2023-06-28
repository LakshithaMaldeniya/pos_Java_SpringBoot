package com.devstack.pos.entity.process;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.sql.Blob;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class ResourseFiles {
    @Column(columnDefinition = "LONGBLOG")
    private Blob fileName;

    @Column(columnDefinition = "LONGBLOG")
    private Blob resourceUrl;

    @Column(columnDefinition = "LONGBLOG")
    private Blob directory;

    @Column(columnDefinition = "LONGBLOG")
    private Blob hash;
}
