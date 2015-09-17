package com.andges.rameshwar.androidgesturesdemo;

import android.app.Activity;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;

public class MainActivity extends Activity {

    ScaleGestureDetector scaleGestureDetector;
    ImageView imageView;
    Matrix matrix=new Matrix();
    float scale=1f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.ivDemo) ;
        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());


    }
    @Override
    public boolean onTouchEvent(MotionEvent ev)
    {
        scaleGestureDetector.onTouchEvent(ev);
        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale*=detector.getScaleFactor();
            scale=Math.max(0.1f,Math.min(scale,5f)); //ensures that the size doesn't exceed 5 nor is less than 0.1f
            matrix.setScale(scale,scale*2); //uniform change
            //HACK: check for different scale factors for the two dimensions
            imageView.setImageMatrix(matrix);
            return true;
        }

    }
}
