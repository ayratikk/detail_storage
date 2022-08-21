package com.example.detail_storage.common.exception;

import com.example.detail_storage.common.Message;

@SuppressWarnings("unused")
public class AccessDeniedException extends BaseException {

    public AccessDeniedException() {
        super();
    }

    public AccessDeniedException(Throwable cause) {
        super(cause);
    }

    public AccessDeniedException(String mes) {
        super(mes);
    }

    public AccessDeniedException(String errorText, String message, Throwable cause) {
        super(errorText, message, cause);
    }

    public AccessDeniedException(Message msg, Object... params) {
        super(msg, params);
    }
}
