package developer.shivam.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class DiagonalView extends ImageView {

    Context mContext;

    /**
     * @param height is the height of view
     */
    int height = 0;

    /**
     * @param angle is the angle at which the diagonal
     * is to be made
     */
    int angle = 15;

    /**
     * @param width is the width of view
     */
    int width = 0;

    Path mPath;

    Paint mPaint;

    /**
     * RIGHT and LEFT would be the gravity of diagonal
     * if diagonalGravity is LEFT then diagonal will start from left
     * and start increasing to RIGHT and reverse if gravity is RIGHT
     */

    public static int LEFT = 1;
    public static int RIGHT = 2;

    private PorterDuffXfermode porterDuffXfermode;

    int diagonalGravity = DiagonalView.LEFT;

    private int paddingLeft = 0;
    private int paddingRight = 0;
    private int paddingTop = 0;
    private int paddingBottom = 0;

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

        porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);

        mPath = new Path();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        TypedArray styledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.DiagonalView, 0, 0);
        angle = styledAttributes.getInt(R.styleable.DiagonalView_angle, 0);
        if (styledAttributes.hasValue(R.styleable.DiagonalView_diagonalGravity)) {
            diagonalGravity = styledAttributes.getInt(R.styleable.DiagonalView_diagonalGravity, 0);
        }

        styledAttributes.recycle();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        width = getMeasuredWidth();
        height = getMeasuredHeight();

        paddingLeft = getPaddingLeft();
        paddingRight = getPaddingRight();
        paddingTop = getPaddingTop();
        paddingBottom = getPaddingBottom();

        mPath = ClipProvider.getDiagonalCutPath(width, height, angle, 0, diagonalGravity,
                paddingLeft, paddingRight, paddingTop, paddingBottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int saveCount = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        super.onDraw(canvas);
        mPaint.setXfermode(porterDuffXfermode);
        canvas.drawPath(mPath, mPaint);
        canvas.restoreToCount(saveCount);
        mPaint.setXfermode(null);
    }

    public void setAngle(int angle) {
        mPath.reset();
        this.angle = angle;
        invalidate();
    }

    public void setDiagonalGravity(int gravity) {
        mPath.reset();
        this.diagonalGravity = gravity;
        invalidate();
    }
}
