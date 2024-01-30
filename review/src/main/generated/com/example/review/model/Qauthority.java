package com.example.review.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * Qauthority is a Querydsl query type for authority
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class Qauthority extends EntityPathBase<authority> {

    private static final long serialVersionUID = -1760467143L;

    public static final Qauthority authority = new Qauthority("authority");

    public final StringPath authorityName = createString("authorityName");

    public Qauthority(String variable) {
        super(authority.class, forVariable(variable));
    }

    public Qauthority(Path<? extends authority> path) {
        super(path.getType(), path.getMetadata());
    }

    public Qauthority(PathMetadata metadata) {
        super(authority.class, metadata);
    }

}

