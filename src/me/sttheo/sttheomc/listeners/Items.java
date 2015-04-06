package me.sttheo.sttheomc.listeners;

import com.google.common.collect.Lists;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static org.bukkit.ChatColor.DARK_RED;
import static org.bukkit.ChatColor.WHITE;

/**
 * Created by theodoregardner on 4/5/15.
 */
public class Items {
    public static ItemStack getTeam9000Sword() {
        ItemStack team9000Sword = new ItemStack(Material.DIAMOND_SWORD);
        team9000Sword.addEnchantment(Enchantment.DAMAGE_ALL, 10);
        team9000Sword.addEnchantment(Enchantment.FIRE_ASPECT, 10);
        team9000Sword.addEnchantment(Enchantment.DURABILITY, 10);
        team9000Sword.addEnchantment(Enchantment.KNOCKBACK, 10);
        ItemMeta itemMeta = team9000Sword.getItemMeta();
        itemMeta.setDisplayName(WHITE + "Team" + DARK_RED + "9000");
        itemMeta.setLore(Lists.newArrayList("A sword so elusive, even", "its maker, Wootalyzer,", "doesn't know it exists."));
        team9000Sword.setItemMeta(itemMeta);
        return team9000Sword;

    }
}
