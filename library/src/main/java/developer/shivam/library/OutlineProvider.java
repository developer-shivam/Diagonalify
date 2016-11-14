package developer.shivam.library;

import android.graphics.Path;

public class OutlineProvider {

    /**
     * @param width width of imageView excluding padding
     * @param height height of imageView excluding padding
     * @param angle angle at which diagonal is to be formed
     * @param horizontalShift horizontal shift from the x-axis.
     * @return path for clipping imageView
     */
    public static Path getDiagonalOutlinePath (int width, int height, int angle, int horizontalShift) {

        float perpendicularHeight = (float) (width * Math.tan(Math.toRadians(angle)));

        Path mPath = new Path();
        mPath.moveTo(0, 0);
        mPath.lineTo(0, height + 1f);
        if (horizontalShift > 0 && horizontalShift < width) {
            mPath.lineTo(horizontalShift, height + 1f);
        }
        mPath.lineTo(width, height - perpendicularHeight + 1f);
        mPath.lineTo(width, 0);
        mPath.close();

        return mPath;
    }
}
