package server.model;

import java.util.Objects;

public class ErrorDetails {

    private String timestamp;
    private int status;
    private String error;
    private String message;
    private String path;


    /**
     * Gets status.
     *
     * @return Value of status.
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets new message.
     *
     * @param message New value of message.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets message.
     *
     * @return Value of message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets new status.
     *
     * @param status New value of status.
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Sets new path.
     *
     * @param path New value of path.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Gets timestamp.
     *
     * @return Value of timestamp.
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Sets new error.
     *
     * @param error New value of error.
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * Sets new timestamp.
     *
     * @param timestamp New value of timestamp.
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Gets error.
     *
     * @return Value of error.
     */
    public String getError() {
        return error;
    }

    /**
     * Gets path.
     *
     * @return Value of path.
     */
    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "ErrorDetails{"
                + "timestamp='" + timestamp + '\''
                + ", status=" + status
                + ", error='" + error + '\''
                + ", message='" + message + '\''
                + ", path='" + path + '\''
                + '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ErrorDetails)) {
            return false;
        }
        ErrorDetails that = (ErrorDetails) object;
        return getStatus() == that.getStatus()
                && Objects.equals(getTimestamp(), that.getTimestamp())
                && Objects.equals(getError(), that.getError())
                && Objects.equals(getMessage(), that.getMessage())
                && Objects.equals(getPath(), that.getPath());
    }
}
