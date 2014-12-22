/*
 * Copyright 2014 Alessandro Falappa <alex.falappa@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;
import javax.swing.plaf.nimbus.AbstractRegionPainter;

/**
 * NetBeans style indeterminate progress bar.
 * <p>
 * Found on http://stackoverflow.com/questions/24409879/how-to-use-netbeans-indeterminate-progress-bar-style
 **
 * @author Alessandro Falappa <alex.falappa@gmail.com>
 */
class IndeterminateRegionPainter extends AbstractRegionPainter {

    // Copied from javax.swing.plaf.nimbus.ProgressBarPainter.java
    private final Color color17 = decodeColor("nimbusOrange", .0f, .0f, .0f, -156);
    private final Color color18 = decodeColor("nimbusOrange", -.015796512f, .02094239f, -.15294117f, 0);
    private final Color color19 = decodeColor("nimbusOrange", -.004321605f, .02094239f, -.0745098f, 0);
    private final Color color20 = decodeColor("nimbusOrange", -.008021399f, .02094239f, -.10196078f, 0);
    private final Color color21 = decodeColor("nimbusOrange", -.011706904f, -.1790576f, -.02352941f, 0);
    private final Color color22 = decodeColor("nimbusOrange", -.048691254f, .02094239f, -.3019608f, 0);
    private final Color color23 = decodeColor("nimbusOrange", .003940329f, -.7375322f, .17647058f, 0);
    private final Color color24 = decodeColor("nimbusOrange", .005506739f, -.46764207f, .109803915f, 0);
    private final Color color25 = decodeColor("nimbusOrange", .0042127445f, -.18595415f, .04705882f, 0);
    private final Color color26 = decodeColor("nimbusOrange", .0047626942f, .02094239f, .0039215684f, 0);
    private final Color color27 = decodeColor("nimbusOrange", .0047626942f, -.15147138f, .1607843f, 0);
    private final Color color28 = decodeColor("nimbusOrange", .010665476f, -.27317524f, .25098038f, 0);
    private final PaintContext ctx = new PaintContext(new Insets(5, 5, 5, 5), new Dimension(29, 19), false);
    private Rectangle2D rect = new Rectangle2D.Float(0, 0, 0, 0);
    private Path2D path = new Path2D.Float();

    @Override
    public void doPaint(Graphics2D g, JComponent c, int width, int height, Object[] extendedCacheKeys) {
        path = decodePath1();
        g.setPaint(color17);
        g.fill(path);
        rect = decodeRect3();
        g.setPaint(decodeGradient5(rect));
        g.fill(rect);
        rect = decodeRect4();
        g.setPaint(decodeGradient6(rect));
        g.fill(rect);
    }

    @Override
    public PaintContext getPaintContext() {
        return ctx;
    }

    private Path2D decodePath1() {
        path.reset();
        path.moveTo(decodeX(0.6f), decodeY(0.12666667f));
        path.curveTo(decodeAnchorX(0.6000000238418579f, -2.0f), decodeAnchorY(0.12666666507720947f, 0.0f), decodeAnchorX(
                0.12666666507720947f, 0.0f), decodeAnchorY(0.6000000238418579f, -2.0f), decodeX(0.12666667f), decodeY(0.6f));
        path.curveTo(decodeAnchorX(0.12666666507720947f, 0.0f), decodeAnchorY(0.6000000238418579f, 2.0f), decodeAnchorX(
                0.12666666507720947f, 0.0f), decodeAnchorY(2.4000000953674316f, -2.0f), decodeX(0.12666667f), decodeY(2.4f));
        path.curveTo(decodeAnchorX(0.12666666507720947f, 0.0f), decodeAnchorY(2.4000000953674316f, 2.0f), decodeAnchorX(
                0.6000000238418579f, -2.0f), decodeAnchorY(2.8933334350585938f, 0.0f), decodeX(0.6f), decodeY(2.8933334f));
        path.curveTo(decodeAnchorX(0.6000000238418579f, 2.0f), decodeAnchorY(2.8933334350585938f, 0.0f), decodeAnchorX(3.0f,
                0.0f), decodeAnchorY(2.8933334350585938f, 0.0f), decodeX(3.0f), decodeY(2.8933334f));
        path.lineTo(decodeX(3.0f), decodeY(2.6f));
        path.lineTo(decodeX(0.4f), decodeY(2.6f));
        path.lineTo(decodeX(0.4f), decodeY(0.4f));
        path.lineTo(decodeX(3.0f), decodeY(0.4f));
        path.lineTo(decodeX(3.0f), decodeY(0.120000005f));
        path.curveTo(decodeAnchorX(3.0f, 0.0f), decodeAnchorY(0.12000000476837158f, 0.0f),
                decodeAnchorX(0.6000000238418579f, 2.0f), decodeAnchorY(0.12666666507720947f, 0.0f), decodeX(0.6f), decodeY(
                        0.12666667f));
        path.closePath();
        return path;
    }

    private Rectangle2D decodeRect3() {
        rect.setRect(decodeX(0.4f), //x
                decodeY(0.4f), //y
                decodeX(3.0f) - decodeX(0.4f), //width
                decodeY(2.6f) - decodeY(0.4f)); //height
        return rect;
    }

    private Rectangle2D decodeRect4() {
        rect.setRect(decodeX(0.6f), //x
                decodeY(0.6f), //y
                decodeX(2.8f) - decodeX(0.6f), //width
                decodeY(2.4f) - decodeY(0.6f)); //height
        return rect;
    }

    private Paint decodeGradient5(Shape s) {
        Rectangle2D bounds = s.getBounds2D();
        float x = (float) bounds.getX();
        float y = (float) bounds.getY();
        float w = (float) bounds.getWidth();
        float h = (float) bounds.getHeight();
        return decodeGradient((0.5f * w) + x, (0.0f * h) + y, (0.5f * w) + x, (1.0f * h) + y,
                new float[]{0.038709678f, 0.05483871f, 0.07096774f, 0.28064516f, 0.4903226f, 0.6967742f, 0.9032258f, 0.9241935f, 0.9451613f},
                new Color[]{color18,
                    decodeColor(color18, color19, 0.5f),
                    color19,
                    decodeColor(color19, color20, 0.5f),
                    color20,
                    decodeColor(color20, color21, 0.5f),
                    color21,
                    decodeColor(color21, color22, 0.5f),
                    color22
                });
    }

    private Paint decodeGradient6(Shape s) {
        Rectangle2D bounds = s.getBounds2D();
        float x = (float) bounds.getX();
        float y = (float) bounds.getY();
        float w = (float) bounds.getWidth();
        float h = (float) bounds.getHeight();
        return decodeGradient((0.5f * w) + x, (0.0f * h) + y, (0.5f * w) + x, (1.0f * h) + y,
                new float[]{0.038709678f, 0.061290324f, 0.08387097f, 0.27258065f, 0.46129033f, 0.4903226f, 0.5193548f, 0.71774197f, 0.91612905f, 0.92419356f, 0.93225807f},
                new Color[]{color23,
                    decodeColor(color23, color24, 0.5f),
                    color24,
                    decodeColor(color24, color25, 0.5f),
                    color25,
                    decodeColor(color25, color26, 0.5f),
                    color26,
                    decodeColor(color26, color27, 0.5f),
                    color27,
                    decodeColor(color27, color28, 0.5f),
                    color28
                });
    }
}
