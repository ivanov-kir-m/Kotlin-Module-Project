package screens

abstract class AbstractCreateScreen {
    abstract val startText: String
    abstract val endText: String
    abstract fun createElement(parentId: Int)

    fun start(parentId: Int) {
        println(startText)
        createElement(parentId)
        println(endText)
    }
}

abstract class AbstractChooseScreen <T> {
    abstract val title: String
    abstract val createChoose: String
    abstract val createItemFun: () -> Unit
    abstract val chooseItemFun: (element: T) -> Unit
    abstract val getElementList: (parentId: Int) -> List<T>

    fun getMenuItems(parentId: Int): List<MenuItem> {
        val menuItems: MutableList<MenuItem> = mutableListOf()
        menuItems.add(MenuItem(1, createChoose, operation=createItemFun))
        var itemIndex = 2
        for (element in getElementList(parentId)) {
            menuItems.add(
                MenuItem(
                    itemIndex,
                    element.toString(),
                    operation={ chooseItemFun(element) },
                )
            )
            itemIndex++
        }
        menuItems.add(MenuItem(itemIndex, "Выход", null))
        return menuItems.toList()
    }

    fun start(parentId: Int) {
        while (true) {
            val menuItems = getMenuItems(parentId)
            Utils.printMenu(title, menuItems)
            val choice = Utils.getChoice(menuItems)
            if (choice != null) {
                if (choice == menuItems.lastIndex + 1) return
                Utils.goToMenuItem(choice, menuItems)
            }
        }
    }

}