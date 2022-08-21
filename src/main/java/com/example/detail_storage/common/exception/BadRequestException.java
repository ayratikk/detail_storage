package com.example.detail_storage.common.exception;

import com.example.detail_storage.common.Message;

@SuppressWarnings("unused")
public class BadRequestException extends BaseException {

    public BadRequestException() {
        super();
    }

    public BadRequestException(Throwable cause) {
        super(cause);
    }

    public BadRequestException(String mes) {
        super(mes);
    }

    public BadRequestException(String errorText, String message, Throwable cause) {
        super(errorText, message, cause);
    }

    public BadRequestException(Message msg, Object... params) {
        super(msg, params);
    }

}
