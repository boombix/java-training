package com.company.Exceptions;

public class RepositoryException extends Exception{
    public RepositoryException(String errorMessage){
        super(errorMessage);
    }
}
