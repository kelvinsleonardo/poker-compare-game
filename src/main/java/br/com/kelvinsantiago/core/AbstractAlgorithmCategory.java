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
package br.com.kelvinsantiago.core;

import br.com.kelvinsantiago.model.Card;
import br.com.kelvinsantiago.util.Number;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Algorithms to check categories of the hands in poker
 * Created Kelvin Santiago.
 */
public abstract class AbstractAlgorithmCategory {

    private List<Card> cards;

    public AbstractAlgorithmCategory(List<Card> cards) {
        this.cards = cards;
    }

    protected boolean hasOnePair() {
        return hasValueRepeated(2, 1);
    }

    protected boolean hasTwoPair() {
        return hasValueRepeated(2,2 );
    }

    protected boolean hasThreeOfKind() {
        return hasValueRepeated(3, 1);
    }

    protected boolean hasFourOfKind() {
        return hasValueRepeated(4, 1);
    }

    protected boolean hasStraight() {
        boolean startWithStraightLow = this.cards
                .stream()
                .map(Card::getValue)
                .collect(Collectors.toList())
                .containsAll(Arrays.asList("A", "2"));

        return Number.isSequence(this.cards
                .stream()
                .map(c -> c.getPoints(startWithStraightLow))
                .collect(Collectors.toList()));

    }

    protected boolean hasFlush() {
        return this.cards
                .stream()
                .collect(Collectors.groupingBy(Card::getSuit))
                .values()
                .stream()
                .filter(cards -> cards.size() == 5)
                .count() == 1;
    }

    protected boolean hasStraightFlush() {
        return hasFlush() && hasStraight();
    }

    protected boolean hasFullHouse() {
        return hasOnePair() && hasThreeOfKind();
    }

    protected boolean hasRoyalFlush() {
        boolean isHighCard = this.cards
                .stream()
                .map(Card::getValue)
                .collect(Collectors.toList())
                .containsAll(Arrays.asList("A", "K"));
        return isHighCard && hasStraightFlush();
    }

    private boolean hasValueRepeated(int repeater, int count) {
        return this.cards
                .stream()
                .collect(Collectors.groupingBy(Card::getValue))
                .values()
                .stream()
                .filter(cards -> cards.size() == repeater)
                .count() == count;
    }

}