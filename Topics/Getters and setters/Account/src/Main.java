class Account {

    private long balance;
    private String ownerName;
    private boolean locked;

    public void setBalance(long newBalance) {
        this.balance = newBalance;
    }

    public void setOwnerName(String newOwnerName) {
        this.ownerName = newOwnerName;
    }

    public void setLocked(boolean newLocked) {
        if (newLocked) this.locked = true;
        else this.locked = false;
    }

    public long getBalance() {
        return this.balance;
    }
    public String getOwnerName() {
        return this.ownerName;
    }
    public boolean isLocked() {
        if (this.locked) return true;
        else return false;
    }
}