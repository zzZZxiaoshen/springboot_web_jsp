package cn.pinghu.springboot_web_jsp;

import cn.pinghu.springboot_web_jsp.entity.Employee;
import cn.pinghu.springboot_web_jsp.service.EmployeeService;
import org.apache.http.HttpRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootWebJspApplicationTests {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private RedisTemplate<Object, Object>  redisTemplate;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private RedisTemplate<Object, Employee> empRedisTemplate;
	@Autowired
	private HttpRequest request;

	@Test
	public void testRedisTemplate() {
		stringRedisTemplate.opsForValue().append("msg", "hello");
		String msg = stringRedisTemplate.opsForValue().get("msg");
		System.out.println("msg = " + msg);
	}

	@Test
	public void testRedisTemplatelist() {
		stringRedisTemplate.opsForList().leftPush("mylsit", "1");
		stringRedisTemplate.opsForList().leftPush("mylsit", "2");
	}

	@Test
	public void testRedisTemplateObject() {
		Employee employee = employeeService.findEmployee(1);
		empRedisTemplate.opsForValue().set("emp-01", employee);
	}



	@Test
	public void contextLoads() throws SQLException {
		System.out.println(dataSource.getClass());
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
	}
	@Test
	public void rootPathTest() throws SQLException {
	}



}

