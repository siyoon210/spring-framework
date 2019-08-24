package todoapp.commons;

import org.springframework.context.MessageSourceResolvable;
import org.springframework.util.ClassUtils;

/**
 * 시스템 운용 중 발생 가능한 최상위 예외 클래스
 *
 * @author springrunner.kr@gmail.com
 */
@SuppressWarnings("serial")
public class SystemException extends RuntimeException implements MessageSourceResolvable {

    public SystemException(String foramt, Object...args) {
        super(String.format(foramt, args));
    }

    public SystemException(Throwable cause) {
        super(cause);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String[] getCodes() {
        return new String[]{ "Exception." + ClassUtils.getShortName(getClass()) };
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
