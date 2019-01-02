import org.redisson.api.RedissonClient;

/**
 * @author Aubergine
 * zhaoshuangquan@allinmd.cn
 * 2019-01-02 13:36
 */
public class BaseTest {
	protected RedissonClient redisson;
	protected static RedissonClient defaultRedisson;

//	public static RedissonClient createInstance() {
//		Config config = createConfig();
//		return Redisson.create(config);
//	}
//
//	protected boolean flushBetweenTests() {
//		return true;
//	}
}