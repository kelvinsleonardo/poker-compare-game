/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import br.com.kelvinsantiago.core.PokerHand;
import br.com.kelvinsantiago.types.Result;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created Kelvin Santiago on 10/06/19.
 */
public class PokerHandTest {

    @Test
    public void test1() {
        PokerHand T1 = new PokerHand("9C TC JC QC KC");
        PokerHand T2 = new PokerHand("9C 9H 5C 5H AC");
        assertEquals(T1.compareWith(T2), Result.WIN);
    }

    @Test
    public void test2() {
        PokerHand T1 = new PokerHand("9C TC JC QC KC");
        PokerHand T2 = new PokerHand("9C 9H 5C 5H AC");
        assertEquals(T1.compareWith(T2), Result.WIN);
    }

    @Test
    public void test3() {
        PokerHand T1 = new PokerHand("TS TD KC JC 7C");
        PokerHand T2 = new PokerHand("JS JC AS KC TD");
        assertEquals(T1.compareWith(T2), Result.LOSS);
    }

    @Test
    public void test4() {
        PokerHand T1 = new PokerHand("7H 7C QC JS TS");
        PokerHand T2 = new PokerHand("7D 7C JS TS 6D");
        assertEquals(T1.compareWith(T2), Result.WIN);
    }

    @Test
    public void test5() {
        PokerHand T1 = new PokerHand("TS TD KC JC 7C");
        PokerHand T2 = new PokerHand("JS JC AS KC TD");
        assertEquals(T1.compareWith(T2), Result.LOSS);
    }

    @Test
    public void test6() {
        PokerHand T1 = new PokerHand("AS AD KD 7C 3D");
        PokerHand T2 = new PokerHand("AD AH KD 7C 4S");
        assertEquals(T1.compareWith(T2), Result.LOSS);
    }

    @Test
    public void test7() {
        PokerHand T1 = new PokerHand("TS JS QS KS AS");
        PokerHand T2 = new PokerHand("AC AH AS AS KS");
        assertEquals(T1.compareWith(T2), Result.WIN);
    }

    @Test
    public void test8() {
        PokerHand T1 = new PokerHand("TS JS QS KS AS");
        PokerHand T2 = new PokerHand("TC JS QC KS AC");
        assertEquals(T1.compareWith(T2), Result.WIN);
    }

    @Test
    public void test9() {
        PokerHand T1 = new PokerHand("TS JS QS KS AS");
        PokerHand T2 = new PokerHand("QH QS QC AS 8H");
        assertEquals(T1.compareWith(T2), Result.WIN);
    }

    @Test
    public void test10() {
        PokerHand T1 = new PokerHand("AC AH AS AS KS");
        PokerHand T2 = new PokerHand("TC JS QC KS AC");
        assertEquals(T1.compareWith(T2), Result.WIN);
    }

    @Test
    public void test11() {
        PokerHand T1 = new PokerHand("AC AH AS AS KS");
        PokerHand T2 = new PokerHand("QH QS QC AS 8H");
        assertEquals(T1.compareWith(T2), Result.WIN);
    }

    @Test
    public void test12() {
        PokerHand T1 = new PokerHand("TC JS QC KS AC");
        PokerHand T2 = new PokerHand("QH QS QC AS 8H");
        assertEquals(T1.compareWith(T2), Result.WIN);
    }

    @Test
    public void test13() {
        PokerHand T1 = new PokerHand("7H 8H 9H TH JH");
        PokerHand T2 = new PokerHand("JH JC JS JD TH");
        assertEquals(T1.compareWith(T2), Result.WIN);
    }

    @Test
    public void test14() {
        PokerHand T1 = new PokerHand("7H 8H 9H TH JH");
        PokerHand T2 = new PokerHand("4H 5H 9H TH JH");
        assertEquals(T1.compareWith(T2), Result.WIN);
    }

    @Test
    public void test15() {
        PokerHand T1 = new PokerHand("7H 8H 9H TH JH");
        PokerHand T2 = new PokerHand("7C 8S 9H TH JH");
        assertEquals(T1.compareWith(T2), Result.WIN);
    }

    @Test
    public void test16() {
        PokerHand T1 = new PokerHand("7H 8H 9H TH JH");
        PokerHand T2 = new PokerHand("TS TH TD JH JD");
        assertEquals(T1.compareWith(T2), Result.WIN);
    }

    @Test
    public void test17() {
        PokerHand T1 = new PokerHand("7H 8H 9H TH JH");
        PokerHand T2 = new PokerHand("JH JD TH TC 4C");
        assertEquals(T1.compareWith(T2), Result.WIN);
    }

    @Test
    public void test18() {
        PokerHand T1 = new PokerHand("JH JC JS JD TH");
        PokerHand T2 = new PokerHand("4H 5H 9H TH JH");
        assertEquals(T1.compareWith(T2), Result.WIN);
    }

    @Test
    public void test19() {
        PokerHand T1 = new PokerHand("JH JC JS JD TH");
        PokerHand T2 = new PokerHand("7C 8S 9H TH JH");
        assertEquals(T1.compareWith(T2), Result.WIN);
    }

    @Test
    public void test20() {
        PokerHand T1 = new PokerHand("JH JC JS JD TH");
        PokerHand T2 = new PokerHand("TS TH TD JH JD");
        assertEquals(T1.compareWith(T2), Result.WIN);
    }

    @Test
    public void test21() {
        PokerHand T1 = new PokerHand("JH JC JS JD TH");
        PokerHand T2 = new PokerHand("JH JD TH TC 4C");
        assertEquals(T1.compareWith(T2), Result.WIN);
    }

    @Test
    public void test22() {
        PokerHand T1 = new PokerHand("4H 5H 9H TH JH");
        PokerHand T2 = new PokerHand("7C 8S 9H TH JH");
        assertEquals(T1.compareWith(T2), Result.WIN);
    }

    @Test
    public void test23() {
        PokerHand T1 = new PokerHand("4H 5H 9H TH JH");
        PokerHand T2 = new PokerHand("TS TH TD JH JD");
        assertEquals(T1.compareWith(T2), Result.LOSS);
    }

    @Test
    public void test24() {
        PokerHand T1 = new PokerHand("4H 5H 9H TH JH");
        PokerHand T2 = new PokerHand("JH JD TH TC 4C");
        assertEquals(T1.compareWith(T2), Result.WIN);
    }

    @Test
    public void test25() {
        PokerHand T1 = new PokerHand("7C 8S 9H TH JH");
        PokerHand T2 = new PokerHand("TS TH TD JH JD");
        assertEquals(T1.compareWith(T2), Result.LOSS);
    }

    @Test
    public void test26() {
        PokerHand T1 = new PokerHand("7C 8S 9H TH JH");
        PokerHand T2 = new PokerHand("JH JD TH TC 4C");
        assertEquals(T1.compareWith(T2), Result.WIN);
    }

    @Test
    public void test27() {
        PokerHand T1 = new PokerHand("TS TH TD JH JD");
        PokerHand T2 = new PokerHand("JH JD TH TC 4C");
        assertEquals(T1.compareWith(T2), Result.WIN);
    }

    @Test
    public void test28() {
        PokerHand T1 = new PokerHand("2S 3H 4D 5H 6D");
        PokerHand T2 = new PokerHand("5H 6D 7H 8C 9C");
        assertEquals(T1.compareWith(T2), Result.LOSS);
    }

    @Test
    public void test29() {
        PokerHand T1 = new PokerHand("2S 3H 4H 5H 6D");
        PokerHand T2 = new PokerHand("2S 3H 4D 5H 6C");
        assertEquals(T1.compareWith(T2), Result.DRAW);
    }

    @Test
    public void test30() {
        PokerHand T1 = new PokerHand("2H 3H 4H 5H 7H");
        PokerHand T2 = new PokerHand("2D 3D 4D 5D 8D");
        assertEquals(T1.compareWith(T2), Result.LOSS);
    }

    @Test
    public void test31() {
        PokerHand T1 = new PokerHand("2S 2H 2D 5H 6D");
        PokerHand T2 = new PokerHand("5H 5D 5H 8C 9C");
        assertEquals(T1.compareWith(T2), Result.LOSS);
    }

    @Test
    public void test32() {
        PokerHand T1 = new PokerHand("2H 3H 4H 5H 6H");
        PokerHand T2 = new PokerHand("5H 6H 7H 8H 9H");
        assertEquals(T1.compareWith(T2), Result.LOSS);
    }

    @Test
    public void test33() {
        PokerHand T1 = new PokerHand("TH JH QH KH AH");
        PokerHand T2 = new PokerHand("TC JC QC KC AC");
        assertEquals(T1.compareWith(T2), Result.DRAW);
    }

    @Test
    public void test34() {
        PokerHand T1 = new PokerHand("TH TH TH TH AS");
        PokerHand T2 = new PokerHand("9C 9C 9C 9C 2S");
        assertEquals(T1.compareWith(T2), Result.WIN);
    }

    @Test
    public void test35() {
        PokerHand T1 = new PokerHand("TH TH TH AH AS");
        PokerHand T2 = new PokerHand("9C 9C 9C 2C 2S");
        assertEquals(T1.compareWith(T2), Result.WIN);
    }

    @Test
    public void test36() {
        PokerHand T1 = new PokerHand("2H 4H 6H 8H AS");
        PokerHand T2 = new PokerHand("3C 5C 6C 8C JS");
        assertEquals(T1.compareWith(T2), Result.WIN);
    }

    @Test
    public void test37() {
        PokerHand T1 = new PokerHand("2H 2H 2H AH AS");
        PokerHand T2 = new PokerHand("2C 2C 2C JC JS");
        assertEquals(T1.compareWith(T2), Result.WIN);
    }

    @Test
    public void test38() {
        PokerHand T1 = new PokerHand("2H 2H 5H AH AS");
        PokerHand T2 = new PokerHand("2C 2C 6C AC AS");
        assertEquals(T1.compareWith(T2), Result.LOSS);
    }

    @Test
    public void test39() {
        PokerHand T1 = new PokerHand("2H 3C 3D 3S 6H");
        PokerHand T2 = new PokerHand("2C 3D 4D 5C 6C");
        assertEquals(T1.compareWith(T2), Result.LOSS);
    }

    @Test
    public void test40() {
        PokerHand T1 = new PokerHand("AS 2S 5S 8S QS");
        PokerHand T2 = new PokerHand("KS JS 5S 8S QS");
        assertEquals(T1.compareWith(T2), Result.WIN);
    }

}
