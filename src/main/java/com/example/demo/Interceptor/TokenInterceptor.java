package com.example.demo.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.example.demo.jwt.JwtUtil;
import com.example.demo.util.R;
import com.google.gson.Gson;

public class TokenInterceptor extends HandlerInterceptorAdapter
{
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
			Object handler) throws Exception
	{
		final HttpServletRequest request = (HttpServletRequest) req;
		final HttpServletResponse response = (HttpServletResponse) res;
		// 等到请求头信息token信息
		final String authHeader = request.getHeader("token");

		// 跨域请求 options过滤
		if ("OPTIONS".equals(request.getMethod()))
		{
			response.setStatus(HttpServletResponse.SC_OK);
			return true;
		} else
		{
			// 判断token是否为空
			if (StringUtils.isEmpty(authHeader))
			{
				response.setHeader("Access-Control-Allow-Credentials", "true");
				response.setHeader("Access-Control-Allow-Origin",
						((HttpServletRequest) request).getHeader("Origin"));
				String json = new Gson().toJson(R.error(
						HttpStatus.UNAUTHORIZED.value(), "invalid token"));
				response.getWriter().print(json);
				return false;
			}
			// 校验token有效性
			R r = JwtUtil.validateJWT(authHeader);
			if (!r.get("code").equals(0))
			{
				response.setHeader("Access-Control-Allow-Credentials", "true");
				response.setHeader("Access-Control-Allow-Origin",
						((HttpServletRequest) request).getHeader("Origin"));
				String json = new Gson().toJson(r);
				response.getWriter().print(json);
				return false;
			}
			try
			{
			} catch (final Exception e)
			{
				response.setHeader("Access-Control-Allow-Credentials", "true");
				response.setHeader("Access-Control-Allow-Origin",
						((HttpServletRequest) request).getHeader("Origin"));
				String json = new Gson().toJson(R.error(
						HttpStatus.UNAUTHORIZED.value(), "invalid token"));
				response.getWriter().print(json);
				return false;
			}

			return true;
		}
	}
}
