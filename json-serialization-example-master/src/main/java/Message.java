public class Message {

    private  long timestampMs;
    private  String sender;
    private  String content;

    /**
     * Default constructor is required by the Jackson library.
     */
    public Message() {}

    public Message(long timestampMs, String sender, String content) {
        this.timestampMs = timestampMs;
        this.sender = sender;
        this.content = content;
    }

    public long getTimestampMs() {
        return timestampMs;
    }

    public void setTimestampMs(long timestampMs) {
        this.timestampMs = timestampMs;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "timestampMs=" + timestampMs +
                ", sender='" + sender + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
