package com.example.detail_storage.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Message {
    SUCCESS(0,"message.success"),
    INTERNAL_SERVER_ERROR(-1,"error.internalServerError"),
    BAD_REQUEST(-2,"error.badRequest"),
    UNAUTHORIZED(-3, "error.unauthorized"),
    INVALID_CREDENTIALS(-4, "error.invalidCredentials"),
    ACCESS_DENIED(-5, "error.accessDenied"),
    ENTITY_NOT_FOUND(-6, "error.entityNotFound"),
    ENTITY_EXISTS(-7, "error.entityExists"),
    ;

    private final int code;
    private final String text;

}
