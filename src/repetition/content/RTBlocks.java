package repetition.content;

import mindustry.world.Block;
import repetition.data.MT;
import repetition.data.RTOreBlock;

public class RTBlocks {
    public static Block oreCassiterite, oreBasalticMineralSand, oreGraniticMineralSand;

    public static void load() {
        oreCassiterite = new RTOreBlock(MT.Cassiterite);
        oreBasalticMineralSand = new RTOreBlock(MT.BasalticMineralSand);
        oreGraniticMineralSand = new RTOreBlock(MT.GraniticMineralSand);
    }
}
