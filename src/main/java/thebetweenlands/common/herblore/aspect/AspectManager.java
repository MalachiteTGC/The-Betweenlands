package thebetweenlands.common.herblore.aspect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import thebetweenlands.common.herblore.aspect.type.IAspectType;
import thebetweenlands.common.registries.AspectRegistry;
import thebetweenlands.common.world.storage.world.BetweenlandsWorldData;

public class AspectManager {
	public static enum AspectTier {
		COMMON(0), UNCOMMON(1), RARE(2);

		public final int id;

		private AspectTier(int id) {
			this.id = id;
		}
	}

	public static enum AspectGroup {
		HERB(0), GEM_BYRGINAZ(1), GEM_FIRNALAZ(2), GEM_FERGALAZ(3);

		public final int id;

		private AspectGroup(int id) {
			this.id = id;
		}
	}

	public static class AspectEntry {
		public final IAspectType aspect;
		public final int tier;
		public final int type;
		public final float baseAmount;
		public final String aspectName;

		public AspectEntry(IAspectType aspect, AspectTier tier, AspectGroup type, float baseAmount) {
			this(aspect, tier.id, type.id, baseAmount);
		}

		public AspectEntry(IAspectType aspect, int tier, int type, float baseAmount) {
			this.aspect = aspect;
			this.tier = tier;
			this.type = type;
			this.baseAmount = baseAmount;
			this.aspectName = this.aspect.getName();
		}
	}

	public static final class AspectItemEntry {
		public final AspectItem item;
		public final int tier;
		public final int type;
		public final float amountMultiplier, amountVaration;
		public final ResourceLocation itemName;

		public AspectItemEntry(ItemStack item, IItemStackMatcher matcher, AspectTier tier, AspectGroup type, float amountMultiplier, float amountVariation) {
			this(item, matcher, tier.id, type.id, amountMultiplier, amountVariation);
		}

		public AspectItemEntry(ItemStack item, IItemStackMatcher matcher, int tier, int type, float amountMultiplier, float amountVariation) {
			this.item = new AspectItem(item, matcher);
			this.tier = tier;
			this.type = type;
			this.amountMultiplier = amountMultiplier;
			this.amountVaration = amountVariation;
			this.itemName = item.getItem().getRegistryName();
		}

		public boolean matchEntry(AspectEntry aspectEntry) {
			return aspectEntry.tier == this.tier && aspectEntry.type == this.type;
		}
	}

	public static final class AspectItem {
		private final ItemStack original;
		private final IItemStackMatcher matcher;

		/**
		 * Creates a new aspect item
		 * @param stack
		 * @param matcher
		 */
		private AspectItem(ItemStack stack, IItemStackMatcher matcher) {
			this.original = stack;
			this.matcher = matcher;
		}

		/**
		 * Returns the original item stack
		 * <p><b>DO NOT MODIFY</b>
		 * @return
		 */
		public ItemStack getOriginal() {
			return this.original;
		}

		/**
		 * Returns the item stack matcher
		 * @return
		 */
		public IItemStackMatcher getMatcher() {
			return this.matcher;
		}

		/**
		 * Writes this aspect item to the specified NBT
		 * @param nbt
		 * @return
		 */
		public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
			nbt.setTag("item", this.original.writeToNBT(new NBTTagCompound()));
			return nbt;
		}

		/**
		 * Reads an aspect item from the specified NBT
		 * @param nbt
		 * @return
		 */
		@Nullable
		public static AspectItem readFromNBT(NBTTagCompound nbt) {
			ItemStack item = nbt.hasKey("item") ? ItemStack.loadItemStackFromNBT(nbt.getCompoundTag("item")) : null;
			if(item == null)
				return null;
			return AspectManager.getAspectItem(item);
		}
	}

	private static final List<AspectEntry> REGISTERED_ASPECTS = new ArrayList<AspectEntry>();
	private static final Map<AspectItem, List<AspectItemEntry>> REGISTERED_ITEMS = new LinkedHashMap<AspectItem, List<AspectItemEntry>>();
	private static final Map<Item, List<AspectItem>> ITEM_TO_ASPECT_ITEMS = new HashMap<Item, List<AspectItem>>();
	private final Map<AspectItem, List<Aspect>> matchedAspects = new LinkedHashMap<AspectItem, List<Aspect>>();

	/**
	 * Returns a list of all generated and matched aspects
	 * @return
	 */
	public Map<AspectItem, List<Aspect>> getMatchedAspects() {
		return Collections.unmodifiableMap(this.matchedAspects);
	}

	/**
	 * Returns all registered aspect items and their possible aspects
	 * @return
	 */
	public static Map<AspectItem, List<AspectItemEntry>> getRegisteredItems(){
		return REGISTERED_ITEMS;
	}

	/**
	 * Registers an aspect
	 * @param entry
	 */
	public static void registerAspect(AspectEntry entry) {
		REGISTERED_ASPECTS.add(entry);
	}

	/**
	 * Adds a single static aspect to the specified entry
	 * @param entry
	 */
	public static void addStaticAspectsToItem(AspectItemEntry entry) {
		addStaticAspectsToItem(entry, 1);
	}

	/**
	 * Adds static aspects to the specified entry
	 * @param entry
	 * @param aspectCount How often the aspect should be added
	 */
	public static void addStaticAspectsToItem(AspectItemEntry entry, int aspectCount) {
		AspectItem itemEntry = entry.item;
		for(Entry<AspectItem, List<AspectItemEntry>> e : REGISTERED_ITEMS.entrySet()) {
			if(e.getKey().equals(itemEntry)) {
				itemEntry = e.getKey();
				break;
			}
		}

		//Register item and possible aspects
		List<AspectItemEntry> entryList = REGISTERED_ITEMS.get(itemEntry);
		if(entryList == null)
			REGISTERED_ITEMS.put(entry.item, entryList = new ArrayList<AspectItemEntry>());
		for(int i = 0; i < aspectCount; i++) {
			entryList.add(entry);
		}

		//Register aspect item and matcher
		List<AspectItem> aspectItems = ITEM_TO_ASPECT_ITEMS.get(entry.item.original.getItem());
		if(aspectItems == null)
			ITEM_TO_ASPECT_ITEMS.put(entry.item.original.getItem(), aspectItems = new ArrayList<AspectItem>());
		aspectItems.add(entry.item);
	}

	/**
	 * Returns the aspect seed based on the world seed
	 * @param worldSeed
	 * @return
	 */
	public static long getAspectsSeed(long worldSeed) {
		Random rnd = new Random();
		rnd.setSeed(worldSeed);
		return rnd.nextLong();
	}

	/**
	 * Returns the aspect manager for the specified world
	 * @param world
	 * @return
	 */
	public static AspectManager get(World world) {
		return BetweenlandsWorldData.forWorld(world).getAspectManager();
	}

	/**
	 * Loads all static aspects from an NBT and complements any missing data
	 * @param nbt
	 * @param aspectSeed
	 */
	public void loadAndPopulateStaticAspects(NBTTagCompound nbt, long aspectSeed) {
		if(nbt != null && nbt.hasKey("entries")) {
			this.loadStaticAspects(nbt);
			//System.out.println("Loaded aspects: ");
			//int loaded = this.matchedAspects.size();
			//for(Entry<AspectItem, List<Aspect>> entry : this.matchedAspects.entrySet()) {
			//	System.out.println(entry.getKey().original.getUnlocalizedName() + " " + entry.getValue());
			//}
			this.updateAspects(aspectSeed);
			//System.out.println("Updated aspects: ");
			//for(Entry<AspectItem, List<Aspect>> entry : this.matchedAspects.entrySet()) {
			//	System.out.println(entry.getKey().original.getUnlocalizedName() + " " + entry.getValue());
			//}
			//System.out.println("Total inserted: " + (this.matchedAspects.size() - loaded));
		} else {
			this.generateStaticAspects(aspectSeed);
		}
	}

	private void updateMatchedAspects(AspectItem item, List<Aspect> aspects) {
		Collections.sort(aspects);
		this.matchedAspects.put(item, aspects);
	}

	/**
	 * Loads all static aspects from an NBT
	 * @param nbt
	 */
	public void loadStaticAspects(NBTTagCompound nbt) {
		this.matchedAspects.clear();
		NBTTagList entryList = (NBTTagList) nbt.getTag("entries");
		entryIT:
			for(int i = 0; i < entryList.tagCount(); i++) {
				NBTTagCompound entryCompound = entryList.getCompoundTagAt(i);
				//System.out.println("Getting aspect item: " + entryCompound);
				AspectItem itemEntry = AspectItem.readFromNBT(entryCompound);
				if(itemEntry == null) {
					//System.out.println("Failed getting aspect item");
					continue;
				}
				//System.out.println("Getting aspect list for item: " + itemEntry);
				NBTTagList aspectList = (NBTTagList) entryCompound.getTag("aspects");
				List<Aspect> itemAspects = new ArrayList<Aspect>();
				for(int c = 0; c < aspectList.tagCount(); c++) {
					NBTTagCompound aspectCompound = aspectList.getCompoundTagAt(c);
					Aspect aspect = Aspect.readFromNBT(aspectCompound);
					if(aspect == null) {
						//System.out.println("Failed getting aspect");
						continue entryIT;
					}
					itemAspects.add(aspect);
				}
				this.updateMatchedAspects(itemEntry, itemAspects);
			}
	}

	/**
	 * Saves all static aspects to an NBT
	 * @param nbt
	 */
	public void saveStaticAspects(NBTTagCompound nbt) {
		NBTTagList entryList = new NBTTagList();
		for(Entry<AspectItem, List<Aspect>> entry : this.matchedAspects.entrySet()) {
			AspectItem itemEntry = entry.getKey();
			List<Aspect> itemAspects = entry.getValue();
			NBTTagCompound entryCompound = new NBTTagCompound();
			itemEntry.writeToNBT(entryCompound);
			NBTTagList aspectList = new NBTTagList();
			for(Aspect aspect : itemAspects) {
				aspectList.appendTag(aspect.writeToNBT(new NBTTagCompound()));
			}
			entryCompound.setTag("aspects", aspectList);
			entryList.appendTag(entryCompound);
			//System.out.println("Saved item aspects: " + entryCompound);
		}
		nbt.setTag("entries", entryList);
	}

	/**
	 * Resets all static aspects
	 * @param aspectSeed
	 */
	public void resetStaticAspects(long aspectSeed) {
		this.generateStaticAspects(aspectSeed);
	}

	private void generateStaticAspects(long seed) {
		this.matchedAspects.clear();
		this.updateAspects(seed);
	}

	private void updateAspects(long seed) {
		Random rnd = new Random();
		rnd.setSeed(seed);

		List<AspectEntry> availableAspects = new ArrayList<AspectEntry>(REGISTERED_ASPECTS.size());
		availableAspects.addAll(REGISTERED_ASPECTS);

		List<AspectEntry> possibleAspects = new ArrayList<AspectEntry>();

		for(Entry<AspectItem, List<AspectItemEntry>> item : REGISTERED_ITEMS.entrySet()) {
			AspectItem itemStack = item.getKey();
			if(this.matchedAspects.containsKey(itemStack)) {
				continue;
			}
			List<AspectItemEntry> itemEntries = item.getValue();
			List<Aspect> itemAspects = new ArrayList<Aspect>(itemEntries.size());
			if(!this.fillItemAspects(itemAspects, itemEntries.size(), itemEntries, possibleAspects, availableAspects, rnd)) {
				this.fillItemAspects(itemAspects, itemEntries.size(), itemEntries, possibleAspects, REGISTERED_ASPECTS, rnd);
			}
			for(Aspect itemAspect : itemAspects) {
				this.removeAvailableAspect(itemAspect, availableAspects);
			}
			List<Aspect> mergedAspects = new ArrayList<Aspect>(itemAspects.size());
			for(Aspect aspect : itemAspects) {
				Aspect mergedAspect = null;
				for(Aspect ma : mergedAspects) {
					if(ma.type == aspect.type) {
						mergedAspect = ma;
						break;
					}
				}
				if(mergedAspect == null) {
					mergedAspects.add(aspect);
				} else {
					mergedAspects.remove(mergedAspect);
					mergedAspects.add(new Aspect(mergedAspect.type, mergedAspect.amount + aspect.amount));
				}
			}
			this.updateMatchedAspects(itemStack, mergedAspects);
		}
	}

	private void removeAvailableAspect(Aspect itemAspect, List<AspectEntry> availableAspects) {
		Iterator<AspectEntry> it = availableAspects.iterator();
		AspectEntry availableAspect = null;
		while(it.hasNext() && (availableAspect = it.next()) != null) {
			if(availableAspect.aspect.equals(itemAspect.type)) {
				it.remove();
			}
		}
	}

	private boolean fillItemAspects(List<Aspect> itemAspects, int itemAspectsSize, List<AspectItemEntry> itemEntries, List<AspectEntry> possibleAspects,
			List<AspectEntry> availableAspects, Random rnd) {
		boolean foundMatches = false;
		int possibleAspectCount = this.fillPossibleAspects(itemEntries, possibleAspects, availableAspects, null);
		if(possibleAspectCount == 0) return false;
		for(int i = 0; i < itemAspectsSize; i++) {
			if(possibleAspects.size() == 0) {
				this.fillPossibleAspects(itemEntries, possibleAspects, availableAspects, itemAspectsSize < possibleAspectCount ? itemAspects : null);
			}
			AspectEntry randomAspect = possibleAspects.get(rnd.nextInt(possibleAspects.size()));
			possibleAspects.remove(randomAspect);
			AspectItemEntry matchingItemEntry = null;
			Collections.shuffle(itemEntries, rnd);
			for(AspectItemEntry itemEntry : itemEntries) {
				if(itemEntry.matchEntry(randomAspect)) {
					matchingItemEntry = itemEntry;
					break;
				}
			}
			float baseAmount = randomAspect.baseAmount * matchingItemEntry.amountMultiplier;
			itemAspects.add(new Aspect(randomAspect.aspect, (int)(baseAmount + baseAmount * matchingItemEntry.amountVaration * (rnd.nextFloat() * 2.0F - 1.0F))));
			foundMatches = true;
		}
		return foundMatches;
	}

	private int fillPossibleAspects(List<AspectItemEntry> itemEntries, List<AspectEntry> possibleAspects, List<AspectEntry> availableAspects, List<Aspect> takenAspects) {
		possibleAspects.clear();
		for(AspectItemEntry itemEntry : itemEntries) {
			for(AspectEntry availableAspect : availableAspects) {
				if(itemEntry.matchEntry(availableAspect) && !possibleAspects.contains(availableAspect) && (takenAspects == null || !takenAspects.contains(availableAspect))) {
					possibleAspects.add(availableAspect);
				}
			}
		}
		return possibleAspects.size();
	}

	/**
	 * Returns a list of all static aspects on an item
	 * @param item
	 * @return
	 */
	@Nonnull
	public List<Aspect> getStaticAspects(ItemStack stack) {
		AspectItem item = getAspectItem(stack);
		if(item != null)
			return this.getStaticAspects(item);
		return new ArrayList<Aspect>();
	}

	/**
	 * Returns a list of all static aspects on the specified item
	 * @param item
	 * @return
	 */
	@Nonnull
	public List<Aspect> getStaticAspects(AspectItem item) {
		List<Aspect> aspects = this.matchedAspects.get(item);
		if(aspects == null)
			aspects = new ArrayList<Aspect>();
		return aspects;
	}

	/**
	 * Returns the matching aspect item for the specified stack
	 * @param stack
	 * @return
	 */
	@Nullable
	public static AspectItem getAspectItem(ItemStack stack) {
		List<AspectItem> potentialMatches = ITEM_TO_ASPECT_ITEMS.get(stack.getItem());
		if(potentialMatches != null) {
			for(AspectItem aspectItem : potentialMatches) {
				if(aspectItem.matcher.matches(aspectItem.original, stack))
					return aspectItem;
			}
		}
		return null;
	}

	/**
	 * Returns a list of all discovered aspects on an item. If you specify a player
	 * this will only return the aspects that the player has discovered.
	 * If the player is null this will return all aspects on an item.
	 * @param item
	 * @param player
	 * @return
	 */
	public List<Aspect> getDiscoveredAspects(AspectItem item, DiscoveryContainer<?> discoveryContainer) {
		List<Aspect> aspects = new ArrayList<Aspect>();
		if(discoveryContainer == null) {
			aspects.addAll(this.getStaticAspects(item));
		} else {
			aspects.addAll(discoveryContainer.getDiscoveredStaticAspects(this, item));
		}
		return aspects;
	}

	/**
	 * Returns a list of all discovered aspect types on an item. If you specify a player
	 * this will only return the aspect types that the player has discovered.
	 * If the player is null this will return all aspect types on an item.
	 * @param item
	 * @param player
	 * @return
	 */
	public List<IAspectType> getDiscoveredAspectTypes(AspectItem item, DiscoveryContainer<?> discoveryContainer) {
		List<IAspectType> aspects = new ArrayList<IAspectType>();
		for(Aspect aspect : this.getDiscoveredAspects(item, discoveryContainer)) {
			aspects.add(aspect.type);
		}
		return aspects;
	}

	/**
	 * Writes an aspect type to the specified nbt compound
	 * @param type
	 * @param nbt
	 * @return
	 */
	public static NBTTagCompound writeAspectTypeNBT(IAspectType type, NBTTagCompound nbt) {
		nbt.setString("type", type.getName());
		return nbt;
	}

	/**
	 * Reads an aspect type from the specified compound
	 * @param nbt
	 * @return
	 */
	public static IAspectType readAspectTypeFromNBT(NBTTagCompound nbt) {
		return AspectRegistry.getAspectTypeFromName(nbt.getString("type"));
	}
}
