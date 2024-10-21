package sparta.challenge;

public enum OperatorType {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String operator;

    OperatorType(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    /*
    문자열을 입력ㅎ받아 그에 해당하는 enum을 리턴.
    @param operator 연산자 기호
    @return 해당하는 enum
     */
    public static OperatorType fromValue(String operator){
        for(OperatorType type : OperatorType.values()){
            if(type.getOperator().equals(operator)){
                return type;
            }
        }
        throw new IllegalArgumentException("올바르지 않은 연산자 입니다.");
    }
}
