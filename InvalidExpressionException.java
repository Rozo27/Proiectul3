public class InvalidExpressionException extends RuntimeException {
    public InvalidExpressionException(){
        super();
    }
    public InvalidExpressionException(String err){
        super(err);
    }
}
