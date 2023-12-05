package com.oscar.pokedex.model.entity

import androidx.compose.ui.graphics.Color
import com.oscar.pokedex.ui.theme.BugTypeColor
import com.oscar.pokedex.ui.theme.DarkTypeColor
import com.oscar.pokedex.ui.theme.DragonTypeColor
import com.oscar.pokedex.ui.theme.ElectricTypeColor
import com.oscar.pokedex.ui.theme.FairyTypeColor
import com.oscar.pokedex.ui.theme.FightingTypeColor
import com.oscar.pokedex.ui.theme.FireTypeColor
import com.oscar.pokedex.ui.theme.FlyingTypeColor
import com.oscar.pokedex.ui.theme.GhostTypeColor
import com.oscar.pokedex.ui.theme.GrassTypeColor
import com.oscar.pokedex.ui.theme.GroundTypeColor
import com.oscar.pokedex.ui.theme.IceTypeColor
import com.oscar.pokedex.ui.theme.NormalTypeColor
import com.oscar.pokedex.ui.theme.PoisonTypeColor
import com.oscar.pokedex.ui.theme.PsychicTypeColor
import com.oscar.pokedex.ui.theme.RockTypeColor
import com.oscar.pokedex.ui.theme.SteelTypeColor
import com.oscar.pokedex.ui.theme.WaterTypeColor

enum class PokemonType (val typeName: String, val color: Color) {
    BUG("Bug", BugTypeColor),
    DARK("Dark", DarkTypeColor),
    DRAGON("Dragon", DragonTypeColor),
    ELECTRIC("Electric", ElectricTypeColor),
    FAIRY("Fairy", FairyTypeColor),
    FIGHTING("Fighting", FightingTypeColor),
    FIRE("Fire", FireTypeColor),
    FLYING("Flying", FlyingTypeColor),
    GHOST("Ghost", GhostTypeColor),
    GRASS("Grass", GrassTypeColor),
    GROUND("Ground", GroundTypeColor),
    ICE("Ice", IceTypeColor),
    NORMAL("Normal", NormalTypeColor),
    POISON("Poison", PoisonTypeColor),
    PSYCHIC("Psychic", PsychicTypeColor),
    STEEL("Steel", SteelTypeColor),
    WATER("Water", WaterTypeColor),
    ROCK("Rock", RockTypeColor)
}
