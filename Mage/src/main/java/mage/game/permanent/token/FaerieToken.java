

package mage.game.permanent.token;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.MageInt;
import mage.abilities.keyword.FlyingAbility;

/**
 *
 * @author spjspj
 */
public final class FaerieToken extends TokenImpl {

    public FaerieToken() {
        super("Faerie", "1/1 blue Faerie creature tokens with flying");
        cardType.add(CardType.CREATURE);
        color.setBlue(true);
        subtype.add(SubType.FAERIE);
        power = new MageInt(1);
        toughness = new MageInt(1);
        this.addAbility(FlyingAbility.getInstance());
    }

    public FaerieToken(final FaerieToken token) {
        super(token);
    }

    public FaerieToken copy() {
        return new FaerieToken(this);
    }
}
