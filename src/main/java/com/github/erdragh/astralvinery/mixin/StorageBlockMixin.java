package com.github.erdragh.astralvinery.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import satisfyu.vinery.block.StorageBlock;
import satisfyu.vinery.block.entity.StorageBlockEntity;

@Mixin(StorageBlock.class)
public abstract class StorageBlockMixin {
    @Shadow public abstract int size();

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

    @Inject(method = "createBlockEntity", at = @At("HEAD"), cancellable = true)
    private void astralCreateBlockEntity(BlockPos pos, BlockState state, CallbackInfoReturnable<BlockEntity> cir) {
        System.out.println(this.size());
    }

}
