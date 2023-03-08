package com.github.erdragh.astralvinery.mixin;

import com.simibubi.create.content.schematics.SchematicWorld;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import satisfyu.vinery.block.entity.StorageBlockEntity;

@Mixin(StorageBlockEntity.class)
public abstract class StorageBlockEntityMixin extends BlockEntity {

    public StorageBlockEntityMixin(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Inject(method = "markDirty", at = @At("HEAD"), cancellable = true)
    public void astralMarkDirty(CallbackInfo ci) {
        if (world == null) {
            ci.cancel();
        }
        if (world instanceof SchematicWorld) {
            ci.cancel();
        }
    }

}
