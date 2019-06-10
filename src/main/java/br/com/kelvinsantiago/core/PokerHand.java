package br.com.kelvinsantiago.core;/*
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

/**
 * Created Kelvin Santiago.
 */
import br.com.kelvinsantiago.impl.*;
import br.com.kelvinsantiago.interfaces.IPokerCategory;
import br.com.kelvinsantiago.model.Card;
import br.com.kelvinsantiago.types.Result;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PokerHand {

    private List<Card> cards;

    private int points;

    public PokerHand(String str) {

        List<String> arrayHandsStr = Arrays.asList(str.split("\\s+"));

        validateHand(arrayHandsStr);

        // Convert list string to object card
        cards = arrayHandsStr
                .stream()
                .map(Card::new)
                .collect(Collectors.toList());

        // Sorting by point of card
        this.sort();

        // Define categories to evaluate hands
        List<IPokerCategory> categories = List.of(
                new RoyalFlushImpl(this.cards),
                new StraightFlushImpl(this.cards),
                new FourOfKindImpl(this.cards),
                new FullHouseImpl(this.cards),
                new FlushImpl(this.cards),
                new StraightImpl(this.cards),
                new ThreeOfKindImpl(this.cards),
                new TwoPairImpl(this.cards),
                new OnePairImpl(this.cards)
        );

        for (int i = 0; i < categories.size() - 1; i++) {
            categories.get(i).evaluateNext(categories.get(i + 1));
        }

        // Starting iteration to get point of hand
        this.points = categories.get(0).getPoints();
    }

    public List<Card> getCards() {
        return cards;
    }

    public Result compareWith(PokerHand anotherPokerHand) {

        // Winner
        if (this.points > anotherPokerHand.points)
            return Result.WIN;

        // Loser
        else if (this.points < anotherPokerHand.points)
            return Result.LOSS;

        return resolveDraw(anotherPokerHand);


    }

    private void sort() {
        cards.sort(Comparator.comparing(Card::getPoints));
    }

    private static void validateHand(List<String> cards) throws IllegalArgumentException {
        if (cards.size() != 5) {
            throw new IllegalArgumentException("Ops, you need 5 cards!");
        }
    }

    private Result resolveDraw(PokerHand ph){

        // Loop highest to lowest
        for (int count = this.cards.size() - 1; count >= 0; count--) {

            int pointCard1 = this.cards.get(count).getPoints();
            int pointCard2 = ph.getCards().get(count).getPoints();

            if(pointCard1 > pointCard2)
                return Result.WIN;

            else if (pointCard2 > pointCard1)
                return Result.LOSS;
        }

        return Result.DRAW;
    }
}





