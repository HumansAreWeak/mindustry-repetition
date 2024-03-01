package repetition.data;

import arc.util.Log;
import mindustry.world.blocks.environment.OreBlock;

public class RTOreBlock extends OreBlock {

    public RTOreBlock(final RTItem item) {
        super("ore-" + item.internalName);
        Log.info(item.name);
        oreDefault = true;
        variants = 3;
        oreThreshold = 0.81f;
        oreScale = 23.47619f;
        itemDrop = item;
        localizedName = item.localizedName;
        mapColor.set(item.color);
        useColor = true;
    }
}
