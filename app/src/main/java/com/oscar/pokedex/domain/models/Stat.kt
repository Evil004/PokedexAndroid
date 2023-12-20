package com.oscar.pokedex.domain.models

import androidx.compose.ui.graphics.Color
import com.oscar.pokedex.ui.theme.ATKStatColor
import com.oscar.pokedex.ui.theme.DEFStatColor
import com.oscar.pokedex.ui.theme.HPStatColor
import com.oscar.pokedex.ui.theme.SpATKStatColor
import com.oscar.pokedex.ui.theme.SpDEFStatColor
import com.oscar.pokedex.ui.theme.SpeedStatColor

enum class Stat(val color: Color, val text: String, val jsonName: String) {
    HP(HPStatColor, "HP", "hp"),
    ATK(ATKStatColor, "ATK", "attack"),
    DEF(DEFStatColor, "DEF", "defense"),
    SP_ATK(SpATKStatColor, "Sp. ATK", "special-attack"),
    SP_DEF(SpDEFStatColor, "Sp. DEF", "special-defense"),
    SPD(SpeedStatColor, "SPD", "speed");

    companion object {
        fun getStat(jsonName: String): Stat {
            return values().first { it.jsonName == jsonName }
        }
    }
}