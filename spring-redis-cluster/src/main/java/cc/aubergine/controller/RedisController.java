package cc.aubergine.controller;

import org.redisson.api.RedissonClient;
import org.redisson.spring.data.connection.RedissonConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aubergine
 * zhaoshuangquan@allinmd.cn
 * 2019-01-02 13:07
 */
@RestController
@RequestMapping("/test/")
public class RedisController {

	@Autowired
	RedissonClient redissonClient;

	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	public void getList(@RequestParam("queryJson") String queryJson) {
		RedissonConnection connection = new RedissonConnection(redissonClient);
		connection.zAdd("abc".getBytes(),123,"1".getBytes());
		connection.zAdd("abc".getBytes(),124,"2".getBytes());
		connection.zAdd("abc".getBytes(),125,"3".getBytes());
		connection.zAdd("abc".getBytes(),126,"4".getBytes());
		connection.zAdd("abc".getBytes(),127,"5".getBytes());
		System.out.println(connection.zCard("abc".getBytes()));
	}





}
