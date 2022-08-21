package com.example.detail_storage.common.exception;

import com.example.detail_storage.common.Message;

@SuppressWarnings("unused")
public class EntityExistsException extends BaseException {
    public EntityExistsException() {
        super();
    }

    public EntityExistsException(Throwable cause) {
        super(cause);
    }

    public EntityExistsException(String mes) {
        super(mes);
    }

    public EntityExistsException(String errorText, String message, Throwable cause) {
        super(errorText, message, cause);
    }

    public EntityExistsException(Message msg, Object... params) {
        super(msg, params);
    }
}
