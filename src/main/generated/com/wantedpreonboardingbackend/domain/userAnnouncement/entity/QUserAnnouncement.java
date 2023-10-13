package com.wantedpreonboardingbackend.domain.userAnnouncement.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserAnnouncement is a Querydsl query type for UserAnnouncement
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserAnnouncement extends EntityPathBase<UserAnnouncement> {

    private static final long serialVersionUID = 904649679L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserAnnouncement userAnnouncement = new QUserAnnouncement("userAnnouncement");

    public final com.wantedpreonboardingbackend.domain.announcement.entity.QAnnouncement announcement;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.wantedpreonboardingbackend.domain.user.entity.QUser user;

    public QUserAnnouncement(String variable) {
        this(UserAnnouncement.class, forVariable(variable), INITS);
    }

    public QUserAnnouncement(Path<? extends UserAnnouncement> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserAnnouncement(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserAnnouncement(PathMetadata metadata, PathInits inits) {
        this(UserAnnouncement.class, metadata, inits);
    }

    public QUserAnnouncement(Class<? extends UserAnnouncement> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.announcement = inits.isInitialized("announcement") ? new com.wantedpreonboardingbackend.domain.announcement.entity.QAnnouncement(forProperty("announcement"), inits.get("announcement")) : null;
        this.user = inits.isInitialized("user") ? new com.wantedpreonboardingbackend.domain.user.entity.QUser(forProperty("user")) : null;
    }

}

