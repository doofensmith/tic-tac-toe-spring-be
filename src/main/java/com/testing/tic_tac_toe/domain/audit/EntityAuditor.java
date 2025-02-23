package com.testing.tic_tac_toe.domain.audit;

import com.testing.tic_tac_toe.domain.common.BaseEntity;
import org.reactivestreams.Publisher;
import org.springframework.data.r2dbc.mapping.OutboundRow;
import org.springframework.data.r2dbc.mapping.event.BeforeConvertCallback;
import org.springframework.data.r2dbc.mapping.event.BeforeSaveCallback;
import org.springframework.data.relational.core.sql.SqlIdentifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
public class EntityAuditor implements BeforeConvertCallback<BaseEntity>, BeforeSaveCallback<BaseEntity> {
    @Override
    public Publisher<BaseEntity> onBeforeConvert(BaseEntity entity, SqlIdentifier table) {
        if (entity.getVersion() == null) {
            entity.setCreatedBy("SYSTEM");
            entity.setCreatedAt(LocalDateTime.now());
            entity.setVersion(1);
        }

        return Mono.just(entity);
    }

    @Override
    public Publisher<BaseEntity> onBeforeSave(BaseEntity entity, OutboundRow row, SqlIdentifier table) {
        entity.setUpdatedBy("SYSTEM");
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setVersion(entity.getVersion() + 1);

        return Mono.just(entity);
    }
}
