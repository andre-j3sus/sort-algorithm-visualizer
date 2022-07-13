import java.awt.BorderLayout
import java.awt.Color
import java.awt.Dimension
import java.awt.FlowLayout
import java.awt.Font
import javax.swing.BorderFactory
import javax.swing.Box
import javax.swing.JButton
import javax.swing.JComboBox
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel

/**
 * Program main frame with window and menu.
 */
object Frame : JFrame() {

    // Constants.
    const val FRAME_WIDTH = 800
    private const val FRAME_HEIGHT = 800
    const val MENU_HEIGHT = 50

    private const val DEFAULT_BORDER_SIZE = 10
    private const val BUTTON_BORDER_SIZE = 5
    private const val TITLE_FONT_SIZE = 32
    private const val TITLE_FONT = "ARIAL"

    // Frame and main panels.
    private val frame = JFrame()
    private val mainCommandsP = JPanel()

    // Sorting Controls
    private val sortingTitle = JLabel("Sorting")
    private val algorithmsBox = JComboBox(Sorting.sortAlgorithmsNames)
    private val sortBtn = JButton("Sort Array")
    private val generateNewArrayBtn = JButton("Generate New Array")

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
        val defaultBorder = BorderFactory.createEmptyBorder(0, 0, 0, DEFAULT_BORDER_SIZE)
        mainCommandsP.layout = FlowLayout()
        mainCommandsP.setBounds(0, 0, FRAME_WIDTH, MENU_HEIGHT)

        // Sorting Panel
        sortingTitle.font = Font(TITLE_FONT, Font.BOLD, TITLE_FONT_SIZE)
        sortingTitle.border = defaultBorder
        mainCommandsP.add(sortingTitle)

        algorithmsBox.border = defaultBorder
        mainCommandsP.add(algorithmsBox)

        sortBtn.addActionListener { Sorting.sortArray() }
        mainCommandsP.add(sortBtn)

        mainCommandsP.add(Box.createRigidArea(Dimension(BUTTON_BORDER_SIZE, 0))) // Separate Area

        generateNewArrayBtn.addActionListener { generateNewArray() }
        mainCommandsP.add(generateNewArrayBtn)

        frame.add(mainCommandsP)

        // Array Panel setup
        ArrayPanel.setBounds(0, MENU_HEIGHT, FRAME_WIDTH, FRAME_HEIGHT - MENU_HEIGHT)
        frame.add(ArrayPanel, BorderLayout.SOUTH)

        frame.isVisible = true
    }

    /**
     * Returns the sort algorithm selected by the user.
     * @return sort algorithm selected by JComboBox.
     */
    fun getSelectedSortAlgo(): Sorting.SortAlgorithm? {
        return when (algorithmsBox.selectedItem) {
            "Bubble Sort" -> Sorting.SortAlgorithm.BUBBLE_SORT
            "Selection Sort" -> Sorting.SortAlgorithm.SELECTION_SORT
            "Insertion Sort" -> Sorting.SortAlgorithm.INSERTION_SORT
            "Merge Sort" -> Sorting.SortAlgorithm.MERGE_SORT
            "Quick Sort" -> Sorting.SortAlgorithm.QUICK_SORT
            "Heap Sort" -> Sorting.SortAlgorithm.HEAP_SORT
            else -> null
        }
    }
}
