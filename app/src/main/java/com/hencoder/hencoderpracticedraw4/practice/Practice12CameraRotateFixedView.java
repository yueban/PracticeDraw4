package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.hencoder.hencoderpracticedraw4.R;

public class Practice12CameraRotateFixedView extends View {
  private final Camera mCamera = new Camera();
  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
  Bitmap bitmap;
  Point point1 = new Point(200, 200);
  Point point2 = new Point(600, 200);

  {
    bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
  }

  public Practice12CameraRotateFixedView(Context context) {
    super(context);
  }

  public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    int bWidht = bitmap.getWidth();
    int bHeight = bitmap.getHeight();

    int dx1 = point1.x + bWidht / 2;
    int dy1 = point1.y + bHeight / 2;

    canvas.save();
    canvas.translate(dx1, dy1);
    mCamera.save();
    mCamera.rotateX(30);
    mCamera.applyToCanvas(canvas);
    mCamera.restore();
    canvas.translate(-dx1, -dy1);
    canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
    canvas.restore();

    int dx2 = point2.x + bWidht / 2;
    int dy2 = point2.y + bHeight / 2;

    canvas.save();
    canvas.translate(dx2, dy2);
    mCamera.save();
    mCamera.rotateY(30);
    mCamera.applyToCanvas(canvas);
    mCamera.restore();
    canvas.translate(-dx2, -dy2);
    canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
    canvas.restore();
  }
}
