package com.sim.webflux.common.exception;

public class BusinessException extends RuntimeException{
    public BusinessException(String userAlreadyExist) {
        super(userAlreadyExist);
    }
}
