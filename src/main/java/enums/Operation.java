package enums;

public enum Operation {
    COMMENT("c"), INFO("p"), EDGE("e");

    private String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return this.operation;
    }

    public static Operation fromString(String operation) {
        switch (operation) {
            case "c":
                return COMMENT;
            case "p":
                return INFO;
            case "e":
                return EDGE;
            default:
                return null;
        }
    }

}
