package repetition.data;

import arc.graphics.Color;
import mindustry.type.Liquid;
import repetition.util.RTElementSymbol;
import repetition.util.RTPair;

public class RTLiquid extends Liquid implements RTElementSymbol {
    private RTPair<Integer, RTElementSymbol>[] compounds;
    private String symbol;

    public RTLiquid(final String internalName, final Color color, RTPair<Integer, RTElementSymbol>... compounds) {
        super(internalName, color);
        this.compounds = compounds;
        this.symbol = getSymbolFromCompounds(compounds);
    }

    private String getSymbolFromCompounds(RTPair<Integer, RTElementSymbol>[] compounds) {
        String symbol = "";
        for(var pair : compounds) {
            RTElementSymbol item = pair.getSecond();
            symbol += item.getSymbol();

            if(pair.getFirst() > 1) {
                symbol += "_{" + pair.getFirst() + "}";
            }
        }
        return symbol;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }
}
