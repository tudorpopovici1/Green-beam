package client;

public class Message {
    private long id;
    private String content;

    public Message(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Message() {
    }


    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "The id is: " + id + " and the message is: " + content;
    }
}
