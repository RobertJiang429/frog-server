package com.frog.utils;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

/**
 * 
 * @author Robert.Jiang
 * @date 2019年5月21日 下午6:09:57
 */
@WebFilter(filterName = "pageFilter", urlPatterns = "/*")
public class PageFilter implements Filter {
	private final static Logger logger = LoggerFactory.getLogger(PageFilter.class);

	@Override
	public void init(FilterConfig filterConfig) {
//		logger.info("PageFilter initialized successfully");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;

		ServletRequest servletRequest = new BodyReaderHttpRequestServletWrapper(httpServletRequest);
		String bodyString = ((BodyReaderHttpRequestServletWrapper) servletRequest).getBodyString();
		if (!StringUtils.isEmpty(bodyString)) {
			@SuppressWarnings("unchecked")
			Map<String, Object> indexSize = new Gson().fromJson(bodyString, Map.class);
			Double pageIndex = (Double) indexSize.get("pageIndex");
			Double pageSize = (Double) indexSize.get("pageSize");
			if (pageIndex != null) {
				PageContext.setPageIndex(pageIndex.intValue());
			}
			if (pageSize != null) {
				PageContext.setPageSize(pageSize.intValue());
			}
		}

		chain.doFilter(servletRequest, response);
	}

	@Override
	public void destroy() {
//		logger.info("PageFilter destroyed successfully");
	}
}
