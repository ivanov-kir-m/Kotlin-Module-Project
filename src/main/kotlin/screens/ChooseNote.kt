package screens

import models.Data
import models.Note

object ChooseNoteScreen: AbstractChooseScreen<Note>() {
    override val title = "Выбор заметки"
    override val createChoose = "Создать заметку"
    override val createItemFun = { CreateNoteScreen.start(0) }
    override val chooseItemFun = { element: Note -> NoteScreen.start(element) }
    override val getElementList = {archiveId: Int -> Data.getNotes(archiveId) }
}
