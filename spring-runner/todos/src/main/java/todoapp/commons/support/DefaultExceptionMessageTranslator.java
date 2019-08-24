package todoapp.commons.support;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.util.ClassUtils;
import todoapp.commons.context.ExceptionMessageTranslator;
import todoapp.commons.util.ThrowableUtils;

import java.util.Locale;
import java.util.Objects;

/**
 * 예외를 {@link MessageSource}를 통해 적절한 메시지로 번역하는 컴포넌트
 *
 * @author springrunner.kr@gmail.com
 */
public class DefaultExceptionMessageTranslator implements ExceptionMessageTranslator {

    private MessageSource messageSource;

    public DefaultExceptionMessageTranslator(MessageSource messageSource) {
        this.messageSource = Objects.requireNonNull(messageSource);
    }

    @Override
    public String getMessage(Throwable throwable, Locale locale) {
        return getMessage(throwable, throwable.getMessage(), locale);
    }

    @Override
    public String getMessage(Throwable throwable, String defaultMessage, Locale locale) {
        if (ClassUtils.isAssignableValue(MessageSourceResolvable.class, throwable.getClass())) {
            return messageSource.getMessage((MessageSourceResolvable) throwable, locale);
        }

        Throwable rootCause = ThrowableUtils.getRootCause(throwable);
        if (ClassUtils.isAssignableValue(MessageSourceResolvable.class, rootCause.getClass())) {
            return messageSource.getMessage((MessageSourceResolvable) rootCause, locale);
        }

        String code = String.format("Exception.%s", ClassUtils.getShortName(rootCause.getClass()));
        return messageSource.getMessage(code, new Object[0], defaultMessage, locale);
    }

}
