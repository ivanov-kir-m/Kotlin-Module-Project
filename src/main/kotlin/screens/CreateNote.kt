package screens

import models.Data
import java.util.*

object CreateNoteScreen: AbstractCreateScreen() {
    override val startText = "Создание заметки..."
    override val endText = "Заметка создана!"

    override fun createElement(parentId: Int) {
        println("Введите имя заметки:")
        val name = Scanner(System.`in`).nextLine()
        println("Введите текст заметки:")
        val text = Scanner(System.`in`).nextLine()
        Data.addNote(name, parentId, text)
    }
}
