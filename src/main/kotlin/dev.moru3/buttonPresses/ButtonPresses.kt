package dev.moru3.buttonPresses

import dev.moru3.minepie.events.EventRegister.Companion.registerEvent
import org.bukkit.Material
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.plugin.java.JavaPlugin

class ButtonPresses: JavaPlugin() {
    override fun onEnable() {
        repeat(10) {
            server.logger.info("美味しいヤミー❗️✨\uD83E\uDD1F\uD83D\uDE01\uD83D\uDC4D感謝❗️\uD83D\uDE4C✨感謝❗️\uD83D\uDE4C✨またいっぱい食べたいな❗️\uD83C\uDF56\uD83D\uDE0B\uD83C\uDF74✨デリシャッ‼️\uD83D\uDE4F✨ｼｬ‼️\uD83D\uDE4F✨ ｼｬ‼️\uD83D\uDE4F✨ ｼｬ‼️\uD83D\uDE4F✨ ｼｬ‼️\uD83D\uDE4F✨ ｼｬ‼️\uD83D\uDE4F✨ ｼｬｯｯ‼ハッピー\uD83C\uDF1Fスマイル❗️\uD83D\uDC49\uD83D\uDE01\uD83D\uDC48")
        }
        this.registerEvent<PlayerInteractEvent> { event ->
            if(event.action==Action.RIGHT_CLICK_BLOCK) {
                if(event.hand!=EquipmentSlot.HAND) { return@registerEvent }
                when(event.clickedBlock?.type) {
                    Material.STONE_BUTTON, Material.POLISHED_BLACKSTONE_BUTTON -> {
                        val stoneButtonPressesObjective = event.player.scoreboard.getObjective("stoneButtonPresses")
                        stoneButtonPressesObjective?.getScore(event.player.name)?.apply { score += 1 }
                    }
                    Material.OAK_BUTTON, Material.SPRUCE_BUTTON, Material.BIRCH_BUTTON, Material.JUNGLE_BUTTON, Material.ACACIA_BUTTON, Material.DARK_OAK_BUTTON, Material.CRIMSON_BUTTON, Material.WARPED_BUTTON -> {
                        val woodenButtonPressesObjective = event.player.scoreboard.getObjective("woodenButtonPresses")
                        woodenButtonPressesObjective?.getScore(event.player.name)?.apply { score += 1 }
                    }
                    else -> {}
                }
            }
        }
    }
}