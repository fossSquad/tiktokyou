package com.uber.h3core.exceptions;

public class H3Exception extends RuntimeException {
    public int code;

    public H3Exception(int i) {
        super(codeToMessage(i));
        this.code = i;
    }

    public static String codeToMessage(int i) {
        switch (i) {
            case 0:
                return "Success";
            case 1:
                return "The operation failed but a more specific error is not available";
            case 2:
                return "Argument was outside of acceptable range";
            case 3:
                return "Latitude or longitude arguments were outside of acceptable range";
            case 4:
                return "Resolution argument was outside of acceptable range";
            case 5:
                return "Cell argument was not valid";
            case 6:
                return "Directed edge argument was not valid";
            case 7:
                return "Undirected edge argument was not valid";
            case 8:
                return "Vertex argument was not valid";
            case 9:
                return "Pentagon distortion was encountered";
            case 10:
                return "Duplicate input";
            case 11:
                return "Cell arguments were not neighbors";
            case 12:
                return "Cell arguments had incompatible resolutions";
            case 13:
                return "Memory allocation failed";
            case 14:
                return "Bounds of provided memory were insufficient";
            case 15:
                return "Mode or flags argument was not valid";
            default:
                return "Unknown error";
        }
    }

    public int getCode() {
        return this.code;
    }
}
