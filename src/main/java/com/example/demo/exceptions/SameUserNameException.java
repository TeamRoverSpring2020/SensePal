package com.example.demo.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class SameUserNameException extends Exception {
}

