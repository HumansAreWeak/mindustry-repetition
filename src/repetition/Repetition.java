package repetition;

import arc.graphics.Color;
import arc.util.Log;
import mindustry.gen.Icon;
import mindustry.mod.Mod;
import mindustry.ui.Links;
import mindustry.ui.dialogs.BaseDialog;
import repetition.content.RTBlocks;
import repetition.content.RTItems;
import repetition.content.RTLiquids;
import repetition.content.RTPlanets;
import repetition.content.RTSectorPresets;

public class Repetition extends Mod {
    public static final String MOD_RELEASES = "https://github.com/HumansAreWeak/mindustry-repetition/releases";
    public static final String MOD_NAME = "repetition-mod";
    public static final String MOD_REPO = "HumansAreWeak/mindustry-repetition";
    public static final String MOD_GITHUB_URL = "https://github.com/HumansAreWeak/mindustry-repetition";

    public static Links.LinkEntry[] links = {
        new Links.LinkEntry("mod.github", MOD_GITHUB_URL, Icon.github, Color.valueOf("24292e")),
    };

    public Repetition() {
        Log.info("Loaded Repetition constructor.");
    }

    private void showAbout() {
        final BaseDialog dialog = new BaseDialog("@links");
        dialog.cont.add("About").row();
        for(var link : links) {
            dialog.cont.add(link.title).row();
        }
        dialog.cont.button("Back", dialog::hide).size(100f, 50f);
        dialog.show();
    }

    @Override
    public void loadContent() {
        RTPlanets.load();
        RTSectorPresets.load();
        RTItems.load();
        RTLiquids.load();
        RTBlocks.load();
    }
}
