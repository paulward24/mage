
package mage.cards.b;

import java.util.UUID;
import mage.abilities.effects.common.FightTargetsEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.filter.common.FilterCreaturePermanent;
import mage.filter.predicate.mageobject.AnotherTargetPredicate;
import mage.target.common.TargetCreaturePermanent;

/**
 *
 * @author intimidatingant
 */
public final class BloodFeud extends CardImpl {

    public BloodFeud(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.SORCERY},"{4}{R}{R}");

        // Target creature fights another target creature.
        this.getSpellAbility().addEffect(new FightTargetsEffect());
        TargetCreaturePermanent target = new TargetCreaturePermanent();
        target.setTargetTag(1);
        this.getSpellAbility().addTarget(target);

        FilterCreaturePermanent filter = new FilterCreaturePermanent("another target creature");
        filter.add(new AnotherTargetPredicate(2));
        TargetCreaturePermanent target2 = new TargetCreaturePermanent(filter);
        target2.setTargetTag(2);
        this.getSpellAbility().addTarget(target2);
    }

    public BloodFeud(final BloodFeud card) {
        super(card);
    }

    @Override
    public BloodFeud copy() {
        return new BloodFeud(this);
    }
}
