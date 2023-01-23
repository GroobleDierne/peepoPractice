package me.wurgo.peepopractice.mixin.gui;

import me.wurgo.peepopractice.gui.CategorySelectionScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin extends Screen {
    protected TitleScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "initWidgetsNormal", at = @At("TAIL"))
    private void addPracticeButton(int y, int spacingY, CallbackInfo ci) {
        this.addButton(
                new ButtonWidget(
                        this.width / 2 - 100,
                        y - spacingY,
                        200,
                        20,
                        new LiteralText("Practice"),
                        b -> {
                            if (this.client != null) {
                                this.client.openScreen(new CategorySelectionScreen(this));
                            }
                        }
                )
        );
    }
}
