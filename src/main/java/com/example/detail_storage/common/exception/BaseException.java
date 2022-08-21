package com.example.detail_storage.common.exception;

import com.example.detail_storage.common.Message;
import lombok.Getter;

@Getter
public abstract class BaseException extends RuntimeException {
    private String errorText;
    private Message msg;
    private Object[] params;

    BaseException() {
        //вызывается конструктор а в нем метод fillInStackTrace() класса Throwable
        super();
    }

    BaseException(Throwable cause) {
        super(cause);
    }

    BaseException(String errorText) {
        super();
        if (errorText == null)
            errorText = "No custom error text";
        this.errorText = errorText;
    }

    BaseException(String errorText, String message, Throwable cause) {
        super(message, cause);
        if (errorText == null)
            errorText = "No custom error text";
        this.errorText = errorText;
    }

    BaseException(Message msg, Object ... params) {
        super();
        this.msg = msg;
        this.params = params;
    }
}

