package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.jwt.JwtUtil;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.R;

@RestController
@RequestMapping("sys")
public class LoginController
{
	@Autowired
	UserRepository userRepository;

	@PostMapping("/login")
	public R login(@RequestParam String username, @RequestParam String password)
	{
		if (StringUtils.isEmpty(username))
		{
			return R.error("用户名不能为空");
		}
		if (StringUtils.isEmpty(password))
		{
			return R.error("密码不能为空");
		}
		User user = userRepository.findByUsername(username);
		if (user == null || !user.getPassword().equals(password))
		{
			return R.error("用户名密码错误");
		}
		String token = JwtUtil.createJWT(user.getUsername(),
				String.valueOf(user.getId()), 3600);
		return R.ok().put("token", token);
	}

	@PostMapping("/reg")
	public R reg(String username, String password)
	{
		if (StringUtils.isEmpty(username))
		{
			return R.error("用户名不能为空");
		}
		if (StringUtils.isEmpty(password))
		{
			return R.error("密码不能为空");
		}
		User user = userRepository.findByUsername(username);
		if (user != null)
		{
			return R.error("用户已存在");
		}
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		userRepository.save(u);
		return R.ok();
	}
}
