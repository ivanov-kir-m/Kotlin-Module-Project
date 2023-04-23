package screens

import models.Data
import java.util.*

object CreateArchiveScreen: AbstractCreateScreen() {
    override val startText = "Создание архива..."
    override val endText = "Архив создан!"

    override fun createElement(parentId: Int) {
        println("Введите имя архива:")
        val name = Scanner(System.`in`).nextLine()
        Data.addArchive(name)
    }
}
