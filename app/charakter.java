import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;

public class charakter extends View {

    Paint paint = new Paint();

    public charakter(Context context) {
        super(context);
    }



    public charakter(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public charakter(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public charakter(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void onDraw(Canvas canvas) {
        // Clear Canvas
        canvas.drawColor(Color.WHITE, PorterDuff.Mode.MULTIPLY);

        // Draw Rectangle
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        canvas.drawRect(30, 30, 500, 200, paint);
    }

}