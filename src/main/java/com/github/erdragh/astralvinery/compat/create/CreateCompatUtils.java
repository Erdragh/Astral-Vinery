package com.github.erdragh.astralvinery.compat.create;

import com.simibubi.create.content.schematics.SchematicWorld;
import net.minecraft.world.World;

public class CreateCompatUtils {
    public static boolean worldIsSchematicWorld(World world) {
        return world instanceof SchematicWorld;
    }
}
