package com.example;

import static com.example.MathUtil.mdc;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

public class MathUtilTest {
    @Test
    void testMdcP1BImpar() {
        int a= 6;
        int b= 3;
        int esperado = 3;
        int obtido = MathUtil.mdc(a, b) ;

        assertEquals(esperado,obtido);

    }

    @Test
    void testMdcP3Positivo() {
        int a= 6;
        int b= 0;
        int esperado = 6;
        int obtido = MathUtil.mdc(a, b) ;

        assertEquals(esperado,obtido);

    }

    @Test
    void testMdcP3Negativo() {
        int a= -6;
        int b= 0;
        int esperado = 6;
        int obtido = MathUtil.mdc(a, b) ;

        assertEquals(esperado,obtido);

    }

    @Test
    void testMdcP5() {
        int a= 6;
        int b= 2;
        int esperado = MathUtil.mdc(b, a);
        int obtido = MathUtil.mdc(a, b) ;
        assertEquals(esperado,obtido);

    }

    @Test
    void testMdcP7() {
        int a= 6;
        int b= 2;
        int esperado = MathUtil.mdc(-a, b);
        int obtido = MathUtil.mdc(-a, -b) ;
        assertEquals(esperado,obtido);
    }

    @Test
    void testMdcP8() {
        int a= 6;
        int esperado = 6 ;
        int obtido = MathUtil.mdc(a, a);
        assertEquals(esperado,obtido);
    }

    @Test
    void testMdc12() {
        int p= 7;
        int a = 2;
        int esperado = 1 ;
        int obtido = MathUtil.mdc(p, a);
        assertEquals(esperado,obtido);
    }

    @Test
    void testMdc121() {
        int p= 7;
        int a = 1;
        int esperado = 1 ;
        int obtido = MathUtil.mdc(p, a);
        assertEquals(esperado,obtido);
    }

    @Test
    void testMdcGeral1() {
        int a= 30;
        int b = 12;
        int esperado = 6;
        int obtido = MathUtil.mdc(a, b);
        assertEquals(esperado,obtido);
    }

    @Test
    void testMdcGeral2() {
        int a= 12;
        int b = 9;
        int esperado = 3;
        int obtido = MathUtil.mdc(a, b);
        assertEquals(esperado,obtido);
    }

    @Test
    void testMdcP4() {
        int m=2, a=6, b=3;
        int esperado = MathUtil.mdc(m*a, m*b);
        int obtido = m* MathUtil.mdc(a, b);
        assertEquals(esperado,obtido);
    }

    @Test
    void testMdcP9() {
        int a = 6, b=3, c=2;
        int esperado = 3;
        int obtido = MathUtil.mdc(a, b) ;
        assertTrue(mdc(a, mdc(b, c))== mdc(mdc(a, b) , c));
        //assertEquals(esperado,obtido);
    }

    @Test
    void testMdc3Valores() {
        int a=12, b=6, c=4;
        int esperado = 2;
        int obtido = mdc(a,b,c);
        assertEquals(esperado,obtido);
    }

    @Test
    void testMdcNenhumValor() {
        int obtido = mdc();
        var exception = assertThrows(IllegalArgumentException.class, MathUtil::mdc);
        System.out.println(exception.getMessage());
    }

    void mdcSemParametros(){
        mdc();
    }

}
