package br.com.kelvinsantiago;
/* Licensed under the Apache License, Version 2.0 (the "License");
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

public class Main {

    public static void main(String[] args) {

        PokerHand T1 = new PokerHand("7C 8S 9H TH JH");

        System.out.println(T1);

        PokerHand T2 = new PokerHand("TS TH TD JH JD");

        System.out.println(T2);

        System.out.println(T1.compareWith(T2));

    }
}
