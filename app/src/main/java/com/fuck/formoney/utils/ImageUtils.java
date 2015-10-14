package com.fuck.formoney.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;

import com.fuck.formoney.base.Constants;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ImageUtils {

    public static Bitmap scaleBitmap(Bitmap bitmap, float scale) {
        if (scale == 1.0f) {
            return bitmap;
        } else {
            return Bitmap.createScaledBitmap(bitmap,
                    (int) (scale * (float) bitmap.getWidth()),
                    (int) (scale * (float) bitmap.getHeight()), true);
        }
    }

    public static Bitmap scaleBitmap(String filePath, float scale) {
        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
        if (bitmap != null)
            return scaleBitmap(bitmap, scale);
        return null;
    }


    public static Bitmap getRoundedCornerBitmapBig(Bitmap bitmap) {
        Bitmap outBitmap = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(outBitmap);
        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPX = 7;
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPX, roundPX, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return outBitmap;
    }

    public static Bitmap getRoundHeader(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_4444);

        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);

        //--CROP THE IMAGE
        canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2, bitmap.getWidth() / 2 - 1, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

    /**
     *裁剪压缩图片，用于上传图片
     * @param filePath
     * @return
     */
    public static byte[] getSmallBitmap(String filePath) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
        options.inSampleSize = calculateInSampleSize(options, SPCache.getInt(Constants.SharePreference.SCREEN_WIDTH, 480) / 2, SPCache.getInt(Constants.SharePreference.SCREEN_HEIGHT, 800) / 2);
        options.inJustDecodeBounds = false;
        Bitmap bmp = BitmapFactory.decodeFile(filePath, options);
        bmp = rotaingImageView(readPictureDegree(filePath), bmp);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, bos);
        return bos.toByteArray();

    }


    /**
     *
     * 计算图片的缩放值
     * @param options
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight){
        int srcWidth = options.outWidth;
        int srcHeight = options.outHeight;
        int inSampleSize = 1;
        if(srcWidth > reqWidth || srcHeight > reqHeight){
            int widthSize = Math.round((float) (srcWidth / reqWidth));
            int heightSize = Math.round((float)(srcHeight / reqHeight));
            inSampleSize = widthSize < heightSize ? widthSize : heightSize;
        }
        return  inSampleSize;
    }


    /**
     * 读取图片属性：旋转的角度
     *
     * @param path 图片绝对路径
     * @return degree旋转的角度
     */

    public static int readPictureDegree(String path) {
        int degree = 0;
        try {
            ExifInterface exifInterface = new ExifInterface(path);
            int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return degree;
    }

    /**
     * 旋转图片
     *
     * @param angle
     * @param bitmap
     * @return Bitmap
     */
    public static Bitmap rotaingImageView(int angle, Bitmap bitmap) {
        //旋转图片 动作
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        // 创建新的图片
        Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        return resizedBitmap;
    }
}
