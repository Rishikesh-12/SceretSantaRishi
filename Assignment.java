public class Assignment {
    private User giver;
    private User receiver;

    public Assignment(User giver, User receiver) {
        this.giver = giver;
        this.receiver = receiver;
    }

    public User getGiver() {
        return giver;
    }

    public User getReceiver() {
        return receiver;
    }
}
