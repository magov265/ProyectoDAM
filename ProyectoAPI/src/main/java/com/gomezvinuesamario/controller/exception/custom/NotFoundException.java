package com.gomezvinuesamario.controller.exception.custom;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NotFoundException(final String msg) {
        super(msg);
    }
}