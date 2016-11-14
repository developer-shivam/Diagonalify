package developer.shivam.library;

import android.graphics.Path;

public class ClipProvider {

    private static float SHADOW_CORRECTION = 10;
    private static int ALPHA = 1;

    /**
     * @param width width of imageView excluding padding
     * @param height height of imageView excluding padding
     * @param angle angle at which diagonal is to be formed
     * @param horizontalShift horizontal shift from the x-axis.
     * @return path for clipping imageView
     */
    public static Path getDiagonalCutPath (int width, int height, int angle, int horizontalShift, int gravity,
                                           int paddingLeft, int paddingRight, int paddingTop, int paddingBottom) {

        float perpendicularHeight = (float) (width * Math.tan(Math.toRadians(angle)));

        Path mPath = new Path();

        if ((gravity & DiagonalView.TOP) != DiagonalView.TOP) {
            if ((gravity & DiagonalView.LEFT) == DiagonalView.LEFT) {
                mPath.moveTo(paddingLeft, height - paddingBottom);
                if (horizontalShift > 0 && horizontalShift < width) {
                    mPath.lineTo(horizontalShift + paddingLeft, height - paddingBottom);
                }
                mPath.lineTo(width - paddingRight, height - perpendicularHeight - paddingBottom);
                mPath.lineTo(width - paddingRight, height + ALPHA + paddingTop);
                mPath.lineTo(paddingLeft, height + ALPHA + paddingTop);
                mPath.close();
            } else {
                mPath.moveTo(width - paddingLeft, height - paddingBottom);
                if (horizontalShift > 0 && horizontalShift < width) {
                    mPath.lineTo(horizontalShift - paddingLeft, height - paddingBottom);
                }
                mPath.lineTo(paddingRight, height - perpendicularHeight - paddingBottom);
                mPath.lineTo(paddingRight, height + ALPHA + paddingTop);
                mPath.lineTo(width - paddingLeft, height + ALPHA + paddingTop);
                mPath.close();
            }
        } else {
            if ((gravity & DiagonalView.LEFT) == DiagonalView.LEFT) {
                mPath.moveTo(paddingLeft, 0);
                mPath.lineTo(paddingLeft, perpendicularHeight - paddingTop);
                if (horizontalShift > 0 && horizontalShift < width) {
                    mPath.lineTo(horizontalShift + paddingLeft, perpendicularHeight - paddingTop);
                }
                mPath.lineTo(width - paddingRight, paddingTop);
                mPath.lineTo(width - paddingRight, 0);
                mPath.close();
            } else {
                mPath.moveTo(paddingLeft, paddingTop);
                if (horizontalShift > 0 && horizontalShift < width) {
                    mPath.lineTo(horizontalShift + paddingLeft, paddingTop);
                }
                mPath.lineTo(width - paddingRight, perpendicularHeight - paddingTop);
                mPath.lineTo(width - paddingRight, 0);
                mPath.lineTo(paddingLeft, 0);
                mPath.close();
            }
        }
        return mPath;
    }

    /**
     * @param width width of imageView excluding padding
     * @param height height of imageView excluding padding
     * @param angle angle at which diagonal is to be formed
     * @param horizontalShift horizontal shift from the x-axis.
     * @return path for clipping imageView
     */
    public static Path getDiagonalOutlinePath (int width, int height, int angle, int horizontalShift, int gravity,
                                               int paddingLeft, int paddingRight, int paddingTop, int paddingBottom) {

        float perpendicularHeight = (float) (width * Math.tan(Math.toRadians(angle)));

        Path mPath = new Path();
        if ((gravity & DiagonalView.TOP) != DiagonalView.TOP) {
            if ((gravity & DiagonalView.LEFT) == DiagonalView.LEFT) {
                mPath.moveTo(paddingLeft, height - paddingBottom - paddingTop);
                if (horizontalShift > 0 && horizontalShift < width) {
                    mPath.lineTo(horizontalShift + paddingLeft, height - paddingBottom - paddingTop);
                }
                mPath.lineTo(width - paddingRight, height - perpendicularHeight - paddingBottom - paddingTop);
                mPath.lineTo(width - paddingRight, 0);
                mPath.lineTo(paddingLeft, 0);
                mPath.close();
            } else {
                mPath.moveTo(width - paddingLeft, height - paddingBottom - paddingTop);
                if (horizontalShift > 0 && horizontalShift < width) {
                    mPath.lineTo(horizontalShift - paddingLeft, height - paddingBottom - paddingTop);
                }
                mPath.lineTo(paddingRight, height - perpendicularHeight - paddingBottom - paddingTop);
                mPath.lineTo(paddingRight, 0);
                mPath.lineTo(width - paddingLeft, 0);
                mPath.close();
            }
        } else {
            if ((gravity & DiagonalView.LEFT) == DiagonalView.LEFT) {
                mPath.moveTo(paddingLeft - SHADOW_CORRECTION, perpendicularHeight - paddingTop - SHADOW_CORRECTION);
                if (horizontalShift > 0 && horizontalShift < width) {
                    mPath.lineTo(horizontalShift + paddingLeft - SHADOW_CORRECTION, perpendicularHeight - paddingTop - SHADOW_CORRECTION);
                }
                mPath.lineTo(width - paddingRight , paddingTop - SHADOW_CORRECTION);
                mPath.lineTo(width - paddingRight , height - paddingBottom - SHADOW_CORRECTION);
                mPath.lineTo(paddingLeft - SHADOW_CORRECTION, height - paddingBottom);
                mPath.close();
            } else {
                mPath.moveTo(paddingLeft - SHADOW_CORRECTION, paddingTop - SHADOW_CORRECTION);
                if (horizontalShift > 0 && horizontalShift < width) {
                    mPath.lineTo(horizontalShift - paddingLeft - SHADOW_CORRECTION, paddingTop - SHADOW_CORRECTION);
                }
                mPath.lineTo(width - paddingRight + SHADOW_CORRECTION, perpendicularHeight - paddingTop - SHADOW_CORRECTION);
                mPath.lineTo(width - paddingRight + SHADOW_CORRECTION, height - paddingBottom - SHADOW_CORRECTION);
                mPath.lineTo(paddingLeft - SHADOW_CORRECTION, height - paddingBottom - SHADOW_CORRECTION);
                mPath.close();
            }
        }
        return mPath;
    }
}
