package archives.tater.drinkingflask;

import archives.tater.drinkingflask.item.DrinkingFlaskItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DrinkingFlask implements ModInitializer {
	public static final String MOD_ID = "drinkingflask";
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final TagKey<Item> CAN_POUR_INTO_FLASK = TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, "can_pour_into_flask"));
	public static final TagKey<Item> BOTTLE_REMAINDER = TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, "remainder/glass_bottle"));
	public static final TagKey<Item> BOWL_REMAINDER = TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, "remainder/bowl"));
	public static final TagKey<Item> BUCKET_REMAINDER = TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, "remainder/bucket"));
	public static final TagKey<Item> DOUBLE_SIZE = TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, "double_size"));

	public static final Item DRINKING_FLASK = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "drinking_flask"), new DrinkingFlaskItem(16, false, new FabricItemSettings()
			.maxCount(1)
	));

	public static final Item PHANTOM_DRINKING_FLASK = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "phantom_drinking_flask"), new DrinkingFlaskItem(16, true, new FabricItemSettings()
			.maxCount(1)
	));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
			entries.add(DRINKING_FLASK);
			entries.add(PHANTOM_DRINKING_FLASK);
		});
	}
}
