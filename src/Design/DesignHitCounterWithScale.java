package Design;

/**
 * follow up: 说如果每秒的点击次数真的是超多，那你该怎么设计呢？
 * 加入1s内进来了1000个hits， 那么我们queue里面就有1000个timestamp，在调用getHits(301), 也就需要删除1000个timestamp， 这样严重影响性能。
 * 比较巧的方法，我们可以用两个bucket来解决，分别用两个大小为300的一维数组，timestamps, hits,前者用来盛放timestamp， 后者用来盛放hit。
 * hit(int timestamp): 对timestamp 取余数，得到在数组中对应的坐标位置，再看坐标位置存的timestamp跟这个新的timestamp是否一样，如果不一样，则证明坐标位置存的timestamp已经过期了，把这个新的timestamp存入即可。
 * getHits(int timestamp): 遍历数组，把没过期的timestamp对应的hits加和。
 * <p>
 * 由于Follow up中说每秒中会有很多点击，下面这种方法就比较巧妙了，定义了两个大小为300的一维数组times和hits，分别用来保存时间戳和点击数，
 * 在点击函数中，将时间戳对300取余，然后看此位置中之前保存的时间戳和当前的时间戳是否一样，一样说明是同一个时间戳，那么对应的点击数自增1，
 * 如果不一样，说明已经过了五分钟了，那么将对应的点击数重置为1。那么在返回点击数时，我们需要遍历times数组，找出所有在5分中内的位置，
 * 然后把hits中对应位置的点击数都加起来即可
 */

public class DesignHitCounterWithScale {

    private int[] times;
    private int[] hits;

    public DesignHitCounterWithScale() {
        times = new int[300];
        hits = new int[300];
    }

    public void hit(int timestamp) {
        int index = timestamp % 300;

        if (times[index] != timestamp) {
            times[index] = timestamp;
            hits[index] = 1;
        } else {
            hits[index]++;
        }
    }

    public int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - times[i] < 300) {
                total += hits[i];
            }
        }
        return total;
    }

}
