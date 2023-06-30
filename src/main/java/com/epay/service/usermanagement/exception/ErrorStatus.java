/**
 * © 2014 Peace Soft Solution
 */
package com.epay.service.usermanagement.exception;

/**
 *
 * @author Admin
 */
public enum ErrorStatus {


    UNHANDLED_ERROR(10001, "Service is currently unavailable. Please try again later", "error.unhandled-error"),
    IMPORT_XLS_FILE_FAILED(34004, "process xls file failed", ""),
    FILE_UPLOAD_CORRUPTED(30000, "Cannot upload file to server", ""),
    INVALID_REQUEST(17001, "Invalid request", "error.invalid-request"),
    ;
    private final String u;
    public final String key;
    private final Object[] v;
    private int code;

    private ErrorStatus(final int code, final String u, final String key) {
        this.u = u;
        this.code = code;
        this.key = key;
        this.v = null;
    }

    private ErrorStatus(final int code, final String u, final String key, final Object[] v) {
        this.u = u;
        this.key = key;
        this.v = v;
        this.code = code;
    }

    public final String getDefaultMessage() {
        return this.u;
    }

    public final String getKey() {
        return this.key;
    }

    public final Object[] getParam() {
        return this.v;
    }

    public final int getCode() {
        return this.code;
    }

    public static ErrorStatus getByCode(int code) {
        for (ErrorStatus errors : ErrorStatus.values()) {
            if (errors.code == code) {
                return errors;
            }
        }
        return null;
    }

    public String getU() {
        return u;
    }

    public Object[] getV() {
        return v;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
