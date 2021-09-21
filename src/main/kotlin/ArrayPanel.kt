import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JPanel


/**
 * Array Panel with bars that represents each element of the Main Array.
 */
object ArrayPanel : JPanel() {
    private const val RECT_WIDTH = 10

    private lateinit var g2D: Graphics2D

    override fun paintComponent(g: Graphics) {
        g2D = g as Graphics2D

        g2D.color = Color.GRAY
        g2D.fillRect(0, 0, Frame.FRAME_WIDTH, Frame.FRAME_WIDTH - Frame.MENU_HEIGHT)

        paintGrid()
    }


    /**
     * Paints the grid.
     */
    private fun paintGrid() {
        val xCoordinate = (Frame.FRAME_WIDTH - mainArray.size * RECT_WIDTH) / 2

        mainArray.forEachIndexed { idx, num ->
            g2D.color = Color.CYAN
            g2D.fillRect(xCoordinate + idx * RECT_WIDTH, 0, RECT_WIDTH, num)
            g2D.color = Color.DARK_GRAY
            g2D.drawRect(xCoordinate + idx * RECT_WIDTH, 0, RECT_WIDTH, num)
        }
    }
}
