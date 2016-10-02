package developer.shivam.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.ImageView;

public class DiagonalView extends ImageView {

    Context mContext;

    /**
     * @height is the height of view
     */
    int height = 0;

    /**
     * @angle is the angle at which the diagonal
     *  is to be made
     */
    float angle = 15;

    /**
     * @width is the width of view
     */
    int width = 0;

    Path mPath;
    Paint mPaint;

    /**
     * @diagonalColor is the color of diagonal color
     * @backgroundColor is the color of tint on ImageView
     *  which is optional
     */
    int diagonalColor;
    int backgroundColor;

    /**
     * RIGHT and LEFT would be the gravity of diagonal
     *  if diagonalGravity is LEFT then diagonal will start from left
     *  and start increasing to RIGHT and reverse if gravity is RIGHT
     */
    public static String RIGHT = "right";
    public static String LEFT = "left";

    String diagonalGravity = DiagonalView.LEFT;

    public DiagonalView(Context context) {
        super(context);
        init(context, null);
    }

    public DiagonalView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public void init(Context context, AttributeSet attrs) {
        mContext = context;

        mPath = new Path();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        TypedArray styledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.diagonal, 0, 0);
        angle = styledAttributes.getInt(R.styleable.diagonal_angle, 0);
        diagonalColor = styledAttributes.getColor(R.styleable.diagonal_diagonalColor, Color.WHITE);
        if (styledAttributes.hasValue(R.styleable.diagonal_diagonalGravity)) {
            diagonalGravity = styledAttributes.getString(R.styleable.diagonal_diagonalGravity);
        }
        backgroundColor = styledAttributes.getColor(R.styleable.diagonal_backgroundColor, Color.TRANSPARENT);

        styledAttributes.recycle();

        mPaint.setColor(diagonalColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(backgroundColor);

        height = getMeasuredHeight();
        width = getMeasuredWidth();

        float perpendicularHeight = (float) (width * Math.tan(Math.toRadians(angle)));
        if (diagonalGravity.equals("right")) {
            mPath.moveTo(width, height);
            mPath.lineTo(0, height - perpendicularHeight);
            mPath.lineTo(0, height + 1);
        } else {
            mPath.moveTo(0, height);
            mPath.lineTo(width, height - perpendicularHeight);
            mPath.lineTo(width, height + 1);
        }

        canvas.drawPath(mPath, mPaint);
    }

    public void setAngle(float angle) {
        mPath.reset();
        this.angle = angle;
        invalidate();
    }

    public void setDiagonalGravity(String gravity) {
        mPath.reset();
        this.diagonalGravity = gravity;
        invalidate();
    }

    public void setBackgroundColor(int color) {
        backgroundColor = color;
        invalidate();
    }
}
