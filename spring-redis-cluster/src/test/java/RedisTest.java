import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.api.SortOrder;
import org.redisson.client.codec.IntegerCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Aubergine
 * zhaoshuangquan@allinmd.cn
 * 2019-01-02 13:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

	@Autowired
	RedissonClient redissonClient;

	@Test
	public void redisTest(){
		RScoredSortedSet<Integer> set = redissonClient.getScoredSortedSet("list", IntegerCodec.INSTANCE);
		set.add(10, 1);
		set.add(9, 2);
		set.add(8, 3);

		redissonClient.getBucket("test1", IntegerCodec.INSTANCE).set(3);
		redissonClient.getBucket("test2", IntegerCodec.INSTANCE).set(2);
		redissonClient.getBucket("test3", IntegerCodec.INSTANCE).set(1);

		Set<Integer> descSort = set.readSort("test*", SortOrder.DESC, 1, 2);
		assertThat(descSort).containsExactly(2, 3);

		Set<Integer> ascSort = set.readSort("test*", SortOrder.ASC, 1, 2);
		assertThat(ascSort).containsExactly(2, 1);
	}

}
