package life.main;

public enum Status {
    NONE, // step 1
    BORN, // step 2
    LIVE, // step 1
    DIED; // step 2

    public Status step1 (int around) {
        switch (this) {
            case NONE: return (around == 3) ? BORN : NONE;
            case LIVE: return (around <= 1 || around >= 4) ? DIED : LIVE;
            default: return this;
        }
    }
    public Status step2 () {
        switch (this) {
            case BORN: return LIVE;
            case DIED: return NONE;
            default: return this;
        }
    }

    public boolean isCell () {
        return this == LIVE || this == DIED;
    }

}
