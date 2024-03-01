package repetition.content;

import mindustry.type.SectorPreset;
import static repetition.content.RTPlanets.*;

public class RTSectorPresets {
    public static SectorPreset crashLanding;

    public static void load() {
        // Kepler-62b
        crashLanding = new SectorPreset("crashLanding", kepler62b, 15) {{
            alwaysUnlocked = true;
            addStartingItems = true;
            difficulty = 0;
            overrideLaunchDefaults = true;
            noLighting = true;
        }};
    }
}
