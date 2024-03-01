package repetition.data;

import arc.graphics.Color;
import mindustry.type.Item;
import repetition.util.RTElementSymbol;
import repetition.util.RTPair;

public class RTItem extends Item implements RTElementSymbol {
    private String symbol;
    private RTPair<Integer, RTElementSymbol>[] compounds;

    public RTItem(final String name, final Color color, final String symbol) {
        super(name, color);
        this.symbol = symbol;
        this.compounds = null;
    }

    public RTItem(final String name, final Color color, RTPair<Integer, RTElementSymbol>... compounds) {
        super(name, color);
        this.compounds = compounds;
        this.symbol = getSymbolFromCompounds(compounds);
    }

    private final String getSymbolFromCompounds(RTPair<Integer, RTElementSymbol>[] compounds) {
        String symbol = "";
        for(var compound : compounds) {
            RTElementSymbol item = compound.getSecond();
            symbol += item.getSymbol();
            if(compound.getFirst() > 1) {
                symbol += "_{" + compound.getFirst() + "}";
            }
        }
        return symbol;
    }

    public static RTItem fromItem(final Item item, final String symbol) {
        return new RTItem(item.name, item.color, symbol);
    }

    public static RTItem fromItem(final Item item, RTPair<Integer, RTElementSymbol>... compounds) {
        return new RTItem(item.name, item.color, compounds);
    }

    public String getSymbol() {
        return symbol;
    }
}
