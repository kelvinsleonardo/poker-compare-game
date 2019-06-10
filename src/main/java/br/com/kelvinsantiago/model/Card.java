package br.com.kelvinsantiago.model;/*
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

import java.util.*;

/**
 * Created Kelvin Santiago.
 */

public class Card {

    private String value;
    private String suit;

    public Card(String card) {
        List<String> cardStr = Arrays.asList(card.split(""));

        validate(cardStr);

        this.value = cardStr.get(0);
        this.suit = cardStr.get(1);
    }

    public String getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    public int getPoints(boolean startWithAce){
        return mapPoints(startWithAce).get(value);
    }

    public  int getPoints(){
        return mapPoints(false).get(value);
    }

    private void validate(List<String> card) {

        if (card.size() != 2) {
            throw new IllegalArgumentException("Format card is not valid." + card);
        }

        if (Optional.ofNullable(mapPoints(false).get(card.get(0))).isEmpty()) {
            throw new IllegalArgumentException("Value of card is not valid." + card);
        }

    }

    private Map<String, Integer> mapPoints(boolean startWithAce) {

        Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        map.put("9", 9);
        map.put("T", 10);
        map.put("J", 11);
        map.put("Q", 12);
        map.put("K", 13);
        map.put("A", startWithAce ? 1 : 14);

        return map;

    }
}