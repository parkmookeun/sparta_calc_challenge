package sparta.challenge;

public enum CommandType {
    YES("yes"),
    EXIT("exit"),
    REMOVE("remove"),
    SHOW("show"),
    ;

    private final String command;

    CommandType(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static CommandType fromValue(String command){
        for(CommandType commandType : CommandType.values()){
            if(commandType.command.equalsIgnoreCase(command)){
                return commandType;
            }
        }
        throw new IllegalArgumentException("올바르지 않는 연산자입니다.");
    }
}
