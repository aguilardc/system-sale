package com.systemsale.systemsale.repository.jpa.custom;

import java.io.Serial;

public class RepositoryException extends Exception {
    @Serial
    private static final long serialVersionUID = -3657909467252600157L;

    public RepositoryException() {
    }

    public RepositoryException(String message) {
        super(message);
    }

    public RepositoryException(Throwable cause) {
        super(cause);
    }

    public RepositoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepositoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
