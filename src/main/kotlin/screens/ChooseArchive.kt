package screens

import models.Data
import models.Archive

object ChooseArchiveScreen: AbstractChooseScreen <Archive>() {
    override val title = "Выбор архива"
    override val createChoose = "Создать архив"
    override val createItemFun = { CreateArchiveScreen.start(0) }
    override val chooseItemFun = { element: Archive -> ChooseNoteScreen.start(element.id) }
    override val getElementList = { _: Int -> Data.getArchives() }
}
