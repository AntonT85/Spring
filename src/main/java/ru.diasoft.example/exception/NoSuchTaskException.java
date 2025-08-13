package ru.diasoft.example.exception;

public class NoSuchTaskException extends RuntimeException {

    public NoSuchTaskException(String msg) {
        super(msg);
    }

}
