package screens

import models.Note
import java.util.*

object NoteScreen {
    fun start(note: Note) {
        println("Имя заметки: ${note.name}\nТекст заметки: ${note.text}\n" +
                "Введите любой символ для возврата в меню")
        Scanner(System.`in`).nextLine()
    }
}
