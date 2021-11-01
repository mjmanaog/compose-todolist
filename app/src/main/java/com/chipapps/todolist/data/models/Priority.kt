package com.chipapps.todolist.data.models

import androidx.compose.ui.graphics.Color
import com.chipapps.todolist.ui.theme.HighPriorityColor
import com.chipapps.todolist.ui.theme.LowPriorityColor
import com.chipapps.todolist.ui.theme.MediumPriorityColor
import com.chipapps.todolist.ui.theme.NonePriorityColor

enum class Priority (color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}