package consoleView.frame;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

/**
 * This class is used to make a group layout Serializable
 */
public class monGroupLayout extends GroupLayout implements Serializable {
    /**
     * Creates a {@code GroupLayout} for the specified {@code Container}.
     *
     * @param host the {@code Container} the {@code GroupLayout} is
     *             the {@code LayoutManager} for
     * @throws IllegalArgumentException if host is {@code null}
     */
    public monGroupLayout(Container host) {
        super(host);
    }
}
