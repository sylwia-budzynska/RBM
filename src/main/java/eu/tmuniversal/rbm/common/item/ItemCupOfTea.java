/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code in github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * GPL-3.0 License: https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package eu.tmuniversal.rbm.common.item;

import eu.tmuniversal.rbm.common.core.ModStats;
import eu.tmuniversal.rbm.common.lib.LibItemNames;
import eu.tmuniversal.rbm.common.lib.TranslationKeyHelper;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.UseAction;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class ItemCupOfTea extends ModItem {
  public ItemCupOfTea() {
    super(ModItem.defaultBuilder().rarity(Rarity.UNCOMMON));
  }

  @Override
  public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entity) {
    if (!worldIn.isRemote) {
      entity.addPotionEffect(new EffectInstance(Objects.requireNonNull(Effect.get(1)), 60 * 20));
      entity.addPotionEffect(new EffectInstance(Objects.requireNonNull(Effect.get(5)), 30 * 20));
      entity.heal(entity.getMaxHealth() / 10.0F);
    }

    if (entity instanceof ServerPlayerEntity) {
      ServerPlayerEntity serverplayerentity = (ServerPlayerEntity) entity;
      CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, stack);
      serverplayerentity.addStat(Stats.ITEM_USED.get(this));
      serverplayerentity.addStat(ModStats.CUPS_OF_TEA_CONSUMED);
    }

    if (entity instanceof PlayerEntity && !((PlayerEntity) entity).abilities.isCreativeMode) {
      stack.shrink(1);
    }

    return stack;
  }

  @Override
  public int getUseDuration(ItemStack stack) {
    return 32;
  }

  @Override
  public UseAction getUseAction(ItemStack stack) {
    return UseAction.DRINK;
  }

  @Override
  public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
    return DrinkHelper.startDrinking(worldIn, playerIn, handIn);
  }

  @Override
  public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
    super.addInformation(stack, worldIn, tooltip, flagIn);
    tooltip.add(TranslationKeyHelper.itemTooltip(LibItemNames.CUP_OF_TEA));
  }
}
