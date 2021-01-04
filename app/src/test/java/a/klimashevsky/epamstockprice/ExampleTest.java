package a.klimashevsky.epamstockprice;

import org.junit.Assert;
import org.junit.Test;

public class ExampleTest {

    int[] anotherOneMagicFunction(int[] src, int n) {
        int l = n % src.length;
        int[] result = new int[src.length];
        for (int i = l; i < src.length; i++) {
            result[i - l] = src[i];
        }
        for (int i = 0; i < l; i++) {
            result[i + src.length - l] = src[i];
        }
        return result;
    }

    @Test
    public void test1() {
        int[] src = new int[]{ 1, 2, 3, 4, 5 };
        int[] result = anotherOneMagicFunction(src, 3);
        int[] expectedResult = new int[]{ 4, 5, 1, 2, 3 };
        Assert.assertArrayEquals(expectedResult, result);
    }

    @Test
    public void test2() {
        int[] src = new int[]{ 3, 2, 5, 4, 5};
        int[] result = anotherOneMagicFunction(src, 2);
        int[] expectedResult = new int[]{5, 4, 5, 3, 2};
        Assert.assertArrayEquals(expectedResult, result);
    }

    @Test
    public void test3() {
        int[] src = new int[]{1, 1, 2, 2, 2};
        int[] result = anotherOneMagicFunction(src, 6);
        int[] expectedResult = new int[]{1, 2, 2, 2, 1};
        Assert.assertArrayEquals(expectedResult, result);
    }
}
