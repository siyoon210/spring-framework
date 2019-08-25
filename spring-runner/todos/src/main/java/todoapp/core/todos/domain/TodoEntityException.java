package todoapp.core.todos.domain;

import org.springframework.context.MessageSourceResolvable;

/**
 * 할 일 엔티티에서 발생 가능한 최상위 예외 클래스
 *
 * @author springrunner.kr@gmail.com
 */
public class TodoEntityException 
extends RuntimeException implements MessageSourceResolvable {

    public TodoEntityException(String format, Object... args) {
        super(String.format(format, args));
    }

    @Override
    public String[] getCodes() {
        return new String[] { String.format("Exception.%s", getClass().getSimpleName()) };
    }

    @Override
    public Object[] getArguments() {
        return new Object[0];
    }

    @Override
    public String getDefaultMessage() {
        return getMessage();
    }

}