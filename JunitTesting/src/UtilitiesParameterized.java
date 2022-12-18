import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class UtilitiesParameterized {
    private String value;
    private String expected;
    private Utilities utils;
    public UtilitiesParameterized(String value,String expected){
        this.value=value;
        this.expected=expected;
    }



    @org.junit.Before
    public void reunBefore(){
        utils=new Utilities();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> removepairTest(){
     return Arrays.asList(new Object[][]{{"ABCDEFF","ABCDEF"},{"AB88EFFG","AB8EFG"},
             {"112233445566","123456"},
             {"ZYZQQB","ZYZQB"},{"A","A"}});
    }

    @org.junit.Test
    public void removepairs_test_1(){
        String op=utils.removePairs(value);
        assertEquals(expected,op);
    }
}
