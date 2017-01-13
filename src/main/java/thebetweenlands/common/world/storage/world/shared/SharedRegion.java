package thebetweenlands.common.world.storage.world.shared;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;

/**
 * One region spans over 32x32 chunks. Any {@link SharedStorage} assigned to a region will be saved in that region file.
 * Regions stay loaded until all references are unloaded or the cache is cleared.
 */
public class SharedRegion {
	private int x, z;

	/**
	 * Returns a region from the specified BlockPos
	 * @see SharedRegion
	 * @param pos
	 * @return
	 */
	public static SharedRegion getFromBlockPos(BlockPos pos) {
		return getFromBlockPos(pos.getX(), pos.getZ());
	}

	/**
	 * Returns a region from the specified X and Z coordinate
	 * @see SharedRegion
	 * @param x
	 * @param z
	 * @return
	 */
	public static SharedRegion getFromBlockPos(int x, int z) {
		return new SharedRegion(x >> 9, z >> 9);
	}

	private SharedRegion(int x, int z) {
		this.x = x;
		this.z = z;
	}

	/**
	 * Returns the X coordinate of the region
	 * @return
	 */
	public int getX() {
		return this.x;
	}


	/**
	 * Returns the Z coordinate of the region
	 * @return
	 */
	public int getZ() {
		return this.z;
	}

	/**
	 * Returns the region file name
	 * @return
	 */
	public String getFileName() {
		return "r." + this.x + "." + this.z;
	}

	/**
	 * Writes the region to the specified NBT
	 * @param nbt
	 * @return
	 */
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		nbt.setInteger("x", this.x);
		nbt.setInteger("z", this.z);
		return nbt;
	}

	/**
	 * Reads a region from the specified NBT
	 * @param nbt
	 * @return
	 */
	public static SharedRegion readFromNBT(NBTTagCompound nbt) {
		return new SharedRegion(nbt.getInteger("x"), nbt.getInteger("z"));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.x;
		result = prime * result + this.z;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		SharedRegion other = (SharedRegion) obj;
		if (this.x != other.x)
			return false;
		if (this.z != other.z)
			return false;
		return true;
	}
}
