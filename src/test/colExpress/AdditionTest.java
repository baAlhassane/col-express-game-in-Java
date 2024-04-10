package colExpress;

import static org.junit.jupiter.api.Assertions.*;

class AdditionTest {

    @org.junit.jupiter.api.Test
    void add() {

        int result=Addition.add(3,5);
        int corectResult=8;
        assertEquals(result,corectResult);
    }
}