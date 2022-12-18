import static org.junit.Assert.*;

public class UtilitiesTest {
    private Utilities utils;
    @org.junit.Before
    public void reunBefore(){
        utils=new Utilities();
    }
    @org.junit.Test
    public void everynthChar_testing(){
        assertArrayEquals(new char[]{'e','l'},utils.everynthChar(new char[]{'h','e','l','l','o'},2));
        //assertArrayEquals(new char[]{'e','l'},utils.everynthChar(new char[]{'h','e','l','l','o'},5));
        assertArrayEquals(new char[]{'h','e','l','l','o'},utils.everynthChar(new char[]{'h','e','l','l','o'},15));

    }

    @org.junit.Test
    public void removepairs_test_1(){
        String op=utils.removePairs("AABCDDEFF");
        assertEquals("ABCDEF",op);
    }
    @org.junit.Test
    public void removepairs_test_2(){
        String op=utils.removePairs("ABCCABDEEF");
        assertEquals("ABCABDEF",op);
    }

    @org.junit.Test(expected = Exception.class)
    public void converter_testing() throws ArithmeticException{
        assertEquals(300,utils.converter(10,5));
        assertEquals(300,utils.converter(10,0));
    }

    @org.junit.Test
    public void nullIfOddLength(){
        String s="vishal";
        String odds="vinay";
        String news=null;
        assertNotNull(utils.nullIfOddLength(s));
        assertEquals(null,utils.nullIfOddLength(odds));
        assertEquals(null,utils.nullIfOddLength(news));
    }

}