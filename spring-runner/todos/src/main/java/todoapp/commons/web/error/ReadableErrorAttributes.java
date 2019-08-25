package todoapp.commons.web.error;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 스프링부트에 기본 구현체인 {@link DefaultErrorAttributes}에 message 속성을 덮어쓰기 할 목적으로 작성한 컴포넌트이다.
 *
 * DefaultErrorAttributes는 message 속성을 예외 객체의 값을 사용하기 때문에 사용자가 읽기에 좋은 문구가 아니다.
 * 해당 메시지를 보다 읽기 좋은 문구로 가공해서 제공한다.
 *
 * @author springrunner.kr@gmail.com
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ReadableErrorAttributes implements ErrorAttributes, HandlerExceptionResolver, Ordered {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final DefaultErrorAttributes delegate = new DefaultErrorAttributes();
    private final MessageSource messageSource;

    public ReadableErrorAttributes(MessageSource messageSource) {
//    	this(false);
    	this.messageSource = messageSource;
    }

//    public ReadableErrorAttributes(boolean includeException) {
//        this.delegate = new DefaultErrorAttributes(includeException);
//    }

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> attributes = delegate.getErrorAttributes(webRequest, includeStackTrace);
        String defaultMessage = (String) attributes.get("message");

        // TODO attributes, error 을 사용해서 message 속성을 읽기 좋은 문구로 가공한다.
        // TODO ex) attributes.put("message", "문구");
       
       Throwable error = getError(webRequest);
       if (MessageSourceResolvable.class.isAssignableFrom(error.getClass())) {
           String errorMessage = messageSource.getMessage(
                   (MessageSourceResolvable) error, webRequest.getLocale());
          attributes.put("message", errorMessage);
       } else {
           // errorCode = Exception.MethodArgumentNotValidException        
           String errorCode = String.format("Exception.%s", error.getClass().getSimpleName());
           String errorMessage = messageSource.getMessage(
                   errorCode, new Object[0], defaultMessage, webRequest.getLocale());
           attributes.put("message", errorMessage);
       }
       
       if (error instanceof MethodArgumentNotValidException) {
    	   List<String> errors = 
    			   ((MethodArgumentNotValidException)error)
    			   .getBindingResult()
    			   .getAllErrors()
    			   .stream()
    			   .map(ob -> messageSource.getMessage(ob, webRequest.getLocale()))
    			   .collect(Collectors.toList());
    	   attributes.put("errors", errors);
       }
       
       return attributes;
    }

    @Override
    public Throwable getError(WebRequest webRequest) {
        return delegate.getError(webRequest);
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception error) {
        return delegate.resolveException(request, response, handler, error);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

}
