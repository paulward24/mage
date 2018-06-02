

package mage.target.common;

import mage.filter.common.FilterEnchantmentPermanent;
import mage.target.TargetPermanent;

/**
 *
 * @author LevelX2
 */
public class TargetEnchantmentPermanent extends TargetPermanent {
    
    public TargetEnchantmentPermanent() {
        this(1, 1, new FilterEnchantmentPermanent(), false);
    }

    public TargetEnchantmentPermanent(FilterEnchantmentPermanent filter) {
        this(1, 1, filter, false);
    }

    public TargetEnchantmentPermanent(int numTargets) {
        this(numTargets, numTargets, new FilterEnchantmentPermanent(), false);
    }

    public TargetEnchantmentPermanent(int minNumTargets, int maxNumTargets, FilterEnchantmentPermanent filter, boolean notTarget) {
        super(minNumTargets, maxNumTargets, filter, notTarget);
    }

    public TargetEnchantmentPermanent(final TargetEnchantmentPermanent target) {
        super(target);
    }

    @Override
    public TargetEnchantmentPermanent copy() {
        return new TargetEnchantmentPermanent(this);
    }
}
