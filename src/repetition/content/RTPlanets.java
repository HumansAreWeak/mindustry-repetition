package repetition.content;

import arc.graphics.Color;
import arc.math.Mathf;
import arc.math.geom.Vec3;
import arc.util.Tmp;
import arc.util.noise.Simplex;
import mindustry.content.Planets;
import mindustry.graphics.Pal;
import mindustry.graphics.Shaders;
import mindustry.graphics.g3d.HexMesh;
import mindustry.graphics.g3d.HexMesher;
import mindustry.type.Planet;

public class RTPlanets {
    public static RTPlanet kepler62, kepler62b, kepler62c, kepler62d, kepler62e, kepler62f;

    public static void load() {
        kepler62 = new RTPlanet("kepler62", null, 0.66f, 3, 0.77f, 5062) {{
                bloom = true;
                visible = true;
                hasAtmosphere = false;
                landCloudColor = Pal.darkFlame;
        }};
        kepler62b = new RTPlanet("kepler-62b", kepler62, 1.31f, 1, 9f, 750) {
            {
                bloom = true;
                visible = true;
                accessible = true;
                hasAtmosphere = false;
                alwaysUnlocked = true;
                clearSectorOnLose = true;
                allowWaveSimulation = true;
                allowLaunchSchematics = false;
                allowLaunchLoadout = true;
                landCloudColor = Pal.darkFlame;
                startSector = 0;
                meshLoader = () -> new RTHexMesh(
                        this, 5,
                        5, 0.3, 1.7, 1.2, 1.4, 1.1f,
                        Pal.orangeSpark.cpy().mul(0.95f),
                        Pal.orangeSpark.cpy().lerp(Color.white, 0.105f),
                        Pal.orangeSpark.cpy().lerp(Pal.gray, 0.2f),
                        Pal.orangeSpark);
            }
        };
        kepler62c = new RTPlanet("kepler-62c", kepler62, 0.54f, 3, 4f, 578) {{
                bloom = true;
                visible = true;
                accessible = true;
                hasAtmosphere = false;
        }};
        kepler62d = new RTPlanet("kepler-62d", kepler62, 1.95f, 3, 14f, 510) {{
                bloom = true;
                visible = true;
                accessible = true;
                hasAtmosphere = false;
        }};
        kepler62e = new RTPlanet("kepler-62e", kepler62, 1.61f, 3, 36f, 270) {{
                bloom = true;
                visible = true;
                accessible = true;
                hasAtmosphere = false;
        }};
        kepler62f = new RTPlanet("kepler-62f", kepler62, 1.46f, 3, 35f, 208) {{
                bloom = true;
                visible = true;
                accessible = true;
                hasAtmosphere = false;
        }};
    }

    public static class RTPlanet extends Planet {
        public float mass;
        public int temperature;

        public RTPlanet(final String name, final Planet parent, final float radius, final int sectorSize, final float mass, final int temperature) {
            super(name, parent, radius, sectorSize);
            this.mass = mass;
            this.temperature = temperature;
        }

        public RTPlanet(final String name, final Planet parent, final float radius, final float mass, final int temperature) {
            super(name, parent, radius);
            this.mass = mass;
            this.temperature = temperature;
        }
    }

    public static class RTHexMesh extends HexMesh {
        public static float waterOffset = 0.05f;

        public RTHexMesh(Planet planet, int divisions, double octaves, double persistence, double scl, double pow,
                double mag, float colorScale, Color... colors) {
            super(planet, new HexMesher() {
                @Override
                public float getHeight(Vec3 position) {
                    position = Tmp.v33.set(position).scl(4f);
                    float height = (Mathf
                            .pow(Simplex.noise3d(123, 7, 0.5f, 1f / 3f, position.x, position.y, position.z), 2.3f)
                            + waterOffset) / (1f + waterOffset);
                    return Math.max(height, 0.05f);
                }

                @Override
                public Color getColor(Vec3 position) {
                    double height = Math
                            .pow(Simplex.noise3d(1, octaves, persistence, scl, position.x, position.y, position.z), pow)
                            * mag;
                    return Tmp.c1.set(colors[Mathf.clamp((int) (height * colors.length), 0, colors.length - 1)])
                            .mul(colorScale);
                }

            }, divisions, Shaders.unlit);
        }
    }
}
