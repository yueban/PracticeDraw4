package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.hencoder.hencoderpracticedraw4.R;

public class Practice09MatrixRotateView extends View {
  private final Matrix mMatrix = new Matrix();
  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
  Bitmap bitmap;
  Point point1 = new Point(200, 200);
  Point point2 = new Point(600, 200);

  {
    bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
  }

  public Practice09MatrixRotateView(Context context) {
    super(context);
  }

  public Practice09MatrixRotateView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Practice09MatrixRotateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    int bWidth = bitmap.getWidth();
    int bHeight = bitmap.getHeight();

    canvas.save();
    mMatrix.setRotate(180, point1.x + bWidth / 2, point1.y + bHeight / 2);
    canvas.concat(mMatrix);
    canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
    canvas.restore();

    canvas.save();
    mMatrix.setRotate(45, point2.x + bWidth / 2, point2.y + bHeight / 2);
    canvas.concat(mMatrix);
    canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
    canvas.restore();
  }
}
