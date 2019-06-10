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
package br.com.kelvinsantiago.impl;

import br.com.kelvinsantiago.core.AbstractAlgorithmCategory;
import br.com.kelvinsantiago.interfaces.IPokerCategory;
import br.com.kelvinsantiago.model.Card;
import br.com.kelvinsantiago.types.PointCategoryHand;

import java.util.List;

/**
 * Created Kelvin Santiago.
 */
public class FlushImpl extends AbstractAlgorithmCategory implements IPokerCategory {
    private IPokerCategory nextCategory;

    public FlushImpl(List<Card> cards) {
        super(cards);
    }

    @Override
    public void evaluateNext(IPokerCategory nextCategory) {
        this.nextCategory = nextCategory;
    }

    @Override
    public int getPoints() {
        return hasFlush() ? PointCategoryHand.FLUSH : nextCategory.getPoints();
    }

}
