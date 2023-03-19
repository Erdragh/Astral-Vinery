package com.github.erdragh.astralvinery.mixin;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import satisfyu.vinery.block.entity.CookingPotEntity;

@Mixin(CookingPotEntity.class)
public abstract class CookingPotEntityMixin implements ExtendedScreenHandlerFactory {

    @Shadow public abstract boolean isBeingBurned();

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBoolean(this.isBeingBurned());
    }

    @Override
    @Shadow
    public Text getDisplayName() {
        return null;
    }

    @Nullable
    @Override
    @Shadow
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return null;
    }
}
