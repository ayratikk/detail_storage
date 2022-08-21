package com.example.detail_storage.common.exception;

import com.example.detail_storage.common.Message;

@SuppressWarnings("unused")
public class EntityNotFoundException extends BaseException {
    public EntityNotFoundException() {
        super();
    }

    public EntityNotFoundException(Throwable cause) {
        super(cause);
    }

    public EntityNotFoundException(String mes) {
        super(mes);
    }

    public EntityNotFoundException(String errorText, String message, Throwable cause) {
        super(errorText, message, cause);
    }

    public EntityNotFoundException(Message msg, Object... params) {
        super(msg, params);
    }
}
