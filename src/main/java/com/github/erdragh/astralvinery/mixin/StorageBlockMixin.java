package com.github.erdragh.astralvinery.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import satisfyu.vinery.block.StorageBlock;
import satisfyu.vinery.block.entity.StorageBlockEntity;

@Mixin(StorageBlock.class)
public abstract class StorageBlockMixin {

    @Inject(method = "add", at = @At("HEAD"), cancellable = true)
    private void astralAdd(World level, BlockPos blockPos, PlayerEntity player, StorageBlockEntity shelfBlockEntity, ItemStack itemStack, int i, CallbackInfo ci) {
        if (player == null) {
            ci.cancel();
        }
    }

    @Inject(method = "remove", at = @At("HEAD"), cancellable = true)
    private void astralRemove(World level, BlockPos blockPos, PlayerEntity player, StorageBlockEntity shelfBlockEntity, int i, CallbackInfo ci) {
        if (player == null) {
            ci.cancel();
        }
    }

}
