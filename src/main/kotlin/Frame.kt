
import java.awt.*
import javax.swing.*


/**
 * Program main frame with window and menu.
 */
object Frame : JFrame() {

    // Constants.
    const val FRAME_WIDTH = 800
    const val FRAME_HEIGHT = 800
    const val MENU_HEIGHT = 50
    private const val BORDER_SIZE = 10
    private const val BUTTON_BORDER = 5
    private const val TITLE_FONT_SIZE = 32

    //Frame and main panels.
    private val frame = JFrame()
    private val mainCommandsP = JPanel()

    // Sorting Controls
    private val sortingTitle = JLabel("Sorting")
    private val algorithmsBox = JComboBox(Sorting.sortAlgorithmsNames)
    private val sortBtn = JButton("Sort Array")
    private val resetBtn = JButton("Reset Array")


    /**
     * Initializes the frame.
     */
    fun init() {
        // Main Frame setup
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT)
        frame.contentPane.background = Color.LIGHT_GRAY
        frame.defaultCloseOperation = EXIT_ON_CLOSE
        frame.title = "Sort Algorithm Visualizer - by Jesus"
        frame.isResizable = false
        frame.layout = null
        frame.setLocationRelativeTo(null)


        // Main Commands Panel setup
        val subtitleFont = Font("ARIAL", Font.BOLD, TITLE_FONT_SIZE)
        val titleBorder = BorderFactory.createEmptyBorder(0, 0, 0, BORDER_SIZE)
        mainCommandsP.layout = FlowLayout()
        mainCommandsP.setBounds(0, 0, FRAME_WIDTH, MENU_HEIGHT)

        // Sorting Panel
        sortingTitle.font = subtitleFont
        sortingTitle.border = titleBorder
        mainCommandsP.add(sortingTitle)

        algorithmsBox.border = BorderFactory.createEmptyBorder(0, 0, 0, BORDER_SIZE)
        algorithmsBox.alignmentY = Component.CENTER_ALIGNMENT
        mainCommandsP.add(algorithmsBox)

        sortBtn.addActionListener { Sorting.sortArray() }
        sortBtn.alignmentY = Component.CENTER_ALIGNMENT
        mainCommandsP.add(sortBtn)
        mainCommandsP.add(Box.createRigidArea(Dimension(BUTTON_BORDER, 0)))

        resetBtn.alignmentY = Component.CENTER_ALIGNMENT
        resetBtn.addActionListener { resetArray() }
        mainCommandsP.add(resetBtn)

        frame.add(mainCommandsP)


        // Array Panel setup
        ArrayPanel.setBounds(0, MENU_HEIGHT, FRAME_WIDTH, FRAME_HEIGHT - MENU_HEIGHT)
        ArrayPanel.background = Color.GREEN
        frame.add(ArrayPanel, BorderLayout.SOUTH)

        frame.isVisible = true
    }


    /**
     * Returns the sort algorithm selected by the user.
     * @return sort algorithm selected by JComboBox.
     */
    fun getSelectedSortAlgo(): Sorting.SortAlgorithm {
        return when (algorithmsBox.selectedItem) {
            "Bubble Sort" -> Sorting.SortAlgorithm.BUBBLE_SORT
            else -> Sorting.SortAlgorithm.BUBBLE_SORT
        }
    }

}
