package thebetweenlands.world.feature.gen.cave;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import thebetweenlands.utils.MathUtils;
import thebetweenlands.world.biomes.base.BiomeGenBaseBetweenlands;

public class MapGenCavesBetweenlandsExperimental extends MapGenBase {
	private OpenSimplexNoise cave;
	private OpenSimplexNoise seaLevelBreak;
	private FractalOpenSimplexNoise form;
	private int seaLevel = 81;

	public MapGenCavesBetweenlandsExperimental(long seed) {
		cave = new OpenSimplexNoise(seed);
		seaLevelBreak = new OpenSimplexNoise(seed + 1);
		form = new FractalOpenSimplexNoise(seed + 2, 4, 0.1);
	}

	@Override
	public void func_151539_a(IChunkProvider chunkProvider, World world, int chunkX, int chunkZ, Block[] blocks) {
		int cx = chunkZ * 16;
		int cz = chunkX * 16;
		int slice = blocks.length / 256;
		int seaLevel = 81;
		for (int bx = 0; bx < 16; bx++) {
			for (int bz = 0; bz < 16; bz++) {
				int x = cx + bx, z = cz + bz;
				Block fillerBlock = world.getBiomeGenForCoords(x, z).fillerBlock;
				int xzIndex = (bz * 16 + bx) * slice;
				int level = 0;
				while (!(blocks[xzIndex + level] != null && blocks[xzIndex + level++].getMaterial().isLiquid()) && level < seaLevel);
				for (int y = 0; y <= level; y++) {
					double noise = cave.eval(x * 0.08, y * 0.15, z * 0.08) + form.eval(x * 0.5, y * 0.3, z * 0.5) * 0.4;
					double limit = -0.3;
					if (y <= 10) {
						limit = (limit + 1) / 10 * y - 1;
					} else if (level - y <= 20) {
						double t = 1 - (level - y) / 20;
						if (t > 0) {
							double cut = seaLevelBreak.eval(x * 0.05, z * 0.05);
							noise += (cut * 0.5 + 0.5) * t;
							if (level < seaLevel) {
								noise += (seaLevel - level) / 6D;
							}
						}
					}
					if (noise < limit) {
						int index = BiomeGenBaseBetweenlands.getBlockArrayIndex(bx, y, bz, slice);
						if (blocks[index] == null || blocks[index].getMaterial().isLiquid()) {
							continue;
						}
						blocks[index] = Blocks.air;
					} else if (y == level && noise < limit + 0.5) {
						double h = MathUtils.linearTransformd(noise, limit, limit + 0.5, 0, 1);
						// https://www.desmos.com/calculator/nhbhw6jwk6
						double f1 = Math.sin(2 * Math.PI * (Math.pow(1 - h, 2) - 0.25)) * 0.5 + 0.5;
						double f2 = Math.sqrt(Math.pow(0.5, 2) - Math.pow(h - 0.5, 2));
						int height = (int) ((f1 + f2) / 1.4576 * 3);
						for (int dy = 0; dy < height; dy++) {
							blocks[BiomeGenBaseBetweenlands.getBlockArrayIndex(bx, y + dy, bz, slice)] = fillerBlock;
						}
					}
				}
			}
		}
	}
}
