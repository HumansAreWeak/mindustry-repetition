package repetition.content;

import mindustry.world.Block;
import mindustry.world.blocks.environment.OreBlock;
import repetition.data.MT;

public class RTBlocks {
    public static Block oreClay, oreClayBrown, oreClayRed, oreBentonite, orePalygorskite, oreKaolinite;

    public static void load() {
        oreClay = new OreBlock(MT.Clay) {
            {
                oreDefault = true;
                oreThreshold = 0.846f;
                oreScale = 24.428572f;
            }
        };

    }
}
