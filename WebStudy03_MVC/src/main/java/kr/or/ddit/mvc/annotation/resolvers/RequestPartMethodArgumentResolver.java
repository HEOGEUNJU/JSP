package kr.or.ddit.mvc.annotation.resolvers;

import java.io.IOException;
import java.lang.reflect.Parameter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.mvc.multipart.MultipartFile;
import kr.or.ddit.mvc.multipart.MultipartHttpServletRequest;

public class RequestPartMethodArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(Parameter parameter) {
		Class<?> parameterType = parameter.getType();
		RequestPart requestPart =parameter.getAnnotation(RequestPart.class);
		boolean support = requestPart!=null
							&&
							MultipartFile.class.equals(parameterType);
		return support;
	}

	@Override
	public Object resolveArgument(Parameter parameter, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Class<?> parameterType = parameter.getType();
		RequestPart requestPart =parameter.getAnnotation(RequestPart.class);
		
		if(req instanceof MultipartHttpServletRequest) {
			MultipartFile file = ((MultipartHttpServletRequest) req).getFile(requestPart.value());
			if(requestPart.required() && (file==null || file.isEmpty())) {
				throw new RequestParamMethodArgumentResolver.BadRequestException("필수 파트 누락");
			}
			return file;
		}else {
			throw new RequestParamMethodArgumentResolver.BadRequestException("Multipart 요청이 아님");
		}
	}

}
