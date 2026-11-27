// Wraps every API answer in the same shape: status, message, data
package com.example.bookstore;

public class ApiResponse<T> {

    private final boolean status;
    private final String message;
    private final T data;

    public ApiResponse(boolean status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public boolean isStatus() { return status; }
    public String getMessage() { return message; }
    public T getData() { return data; }
}