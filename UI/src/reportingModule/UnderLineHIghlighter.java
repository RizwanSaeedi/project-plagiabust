/*
Core SWING Advanced Programming
By Kim Topley
ISBN: 0 13 083292 8
Publisher: Prentice Hall
 */
package reportingModule;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.text.LayeredHighlighter;
import javax.swing.text.Position;
import javax.swing.text.View;

public class UnderLineHIghlighter extends DefaultHighlighter {

    // Shared painter used for default highlighting
        protected static final Highlighter.HighlightPainter sharedPainter = new UnderlineHighlightPainter(
                null);
        // Painter used for this highlighter
        protected Highlighter.HighlightPainter painter;


    public UnderLineHIghlighter(Color c) {
        painter = (c == null ? sharedPainter : new UnderlineHighlightPainter(c));
    }

    /**
     * Convenience method to add a highlight with
    the default painter.
     */
    public Object addHighlight(int p0, int p1) throws BadLocationException {
        return addHighlight(p0, p1, painter);
    }

    /**
     *
     * @param newValue
     */
    public void setDrawsLayeredHighlights(boolean newValue) {
        // Illegal if false - we only support layered highlights
        if (newValue == false) {
            throw new IllegalArgumentException(
                    "UnderlineHighlighter only draws layered highlights");
        }
        super.setDrawsLayeredHighlights(true);
    }

    /**
     * UnderLineHighlighter Class
     */
    public static class UnderlineHighlightPainter extends LayeredHighlighter.LayerPainter {

        
        public UnderlineHighlightPainter(Color c) {
            color = c;
        }

        public void paint(Graphics g, int offs0, int offs1, Shape bounds,
                JTextComponent c) {
            // Do nothing: this method will never be called
        }

        /**
         * Paint the underline layer
         * @param g
         * @param offs0
         * @param offs1
         * @param bounds
         * @param c
         * @param view
         * @return
         */
        public Shape paintLayer(Graphics g, int offs0, int offs1, Shape bounds,
                JTextComponent c, View view) {
            g.setColor(color == null ? c.getSelectionColor() : color);
            Rectangle alloc = null;
            if (offs0 == view.getStartOffset() && offs1 == view.getEndOffset()) {
                if (bounds instanceof Rectangle) {
                    alloc = (Rectangle) bounds;
                } else {
                    alloc = bounds.getBounds();
                }
            } else {
                try {
                    Shape shape = view.modelToView(offs0,
                            Position.Bias.Forward, offs1,
                            Position.Bias.Backward, bounds);
                    alloc = (shape instanceof Rectangle) ? (Rectangle) shape
                            : shape.getBounds();
                } catch (BadLocationException e) {
                    return null;
                }
            }
            FontMetrics fm = c.getFontMetrics(c.getFont());
            int baseline = alloc.y + alloc.height - fm.getDescent() + 1;
            g.drawLine(alloc.x, baseline, alloc.x + alloc.width, baseline);
            g.drawLine(alloc.x, baseline + 1, alloc.x + alloc.width,
                    baseline + 1);
            return alloc;
        }
        protected Color color; // The color for the underline
    }
}
