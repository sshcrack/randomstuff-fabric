package me.sshcrack.randomstuff;

import me.sshcrack.randomstuff.entity.TPArrowEntity;
import me.sshcrack.randomstuff.entity.TntArrowEntity;
import me.sshcrack.randomstuff.item.TPArrowItem;
import me.sshcrack.randomstuff.item.TntArrowItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tag.ItemTags;
import net.minecraft.tag.TagManagerLoader;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Collectors;

public class RandomStuffMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String ModID = "randomstuff";
	public static final Logger LOGGER = LoggerFactory.getLogger(ModID);

	public static final EntityType<TntArrowEntity> TntArrowEntityType = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier(ModID, "tnt_arrow"),
			FabricEntityTypeBuilder.<TntArrowEntity>create(SpawnGroup.MISC, TntArrowEntity::new)
					.dimensions(EntityDimensions.fixed(0.25F, 0.25F))
					.trackRangeBlocks(4).trackedUpdateRate(10)
					.build()
	);


	public static final EntityType<TPArrowEntity> TPArrowEntityType = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier(ModID, "tp_arrow"),
			FabricEntityTypeBuilder.<TPArrowEntity>create(SpawnGroup.MISC, TPArrowEntity::new)
					.dimensions(EntityDimensions.fixed(0.25F, 0.25F))
					.trackRangeBlocks(4).trackedUpdateRate(10)
					.build()
	);

	public static final Item TntArrowItem = new TntArrowItem(new FabricItemSettings().group(ItemGroup.COMBAT));
	public static final Item TPArrowItem = new TPArrowItem(new FabricItemSettings().group(ItemGroup.COMBAT));


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Registry.register(Registry.ITEM, new Identifier(ModID, "tnt_arrow"), TntArrowItem);
		Registry.register(Registry.ITEM, new Identifier(ModID, "tp_arrow"), TPArrowItem);

		LOGGER.info("Hello Fabric world!");

	}
}
