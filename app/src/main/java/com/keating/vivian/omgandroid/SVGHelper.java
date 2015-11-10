package com.keating.vivian.omgandroid;

/**
 * Created by Rainbow on 11/10/15.
 */


import android.content.Context;
import android.graphics.*;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class SVGHelper {


        public static class SvgPath {
            private static final Region sRegion = new Region();
            private static final Region sMaxClip = new Region(
                    Integer.MIN_VALUE, Integer.MIN_VALUE,
                    Integer.MAX_VALUE, Integer.MAX_VALUE);

            final Path path;
            final Path renderPath = new Path();
            final Paint paint;
            final float length;
            final Rect bounds;
            final PathMeasure measure;

            SvgPath(Path path, Paint paint) {
                this.path = path;
                this.paint = paint;

                measure = new PathMeasure(path, false);
                this.length = measure.getLength();

                sRegion.setPath(path, sMaxClip);
                bounds = sRegion.getBounds();
            }
        }


}
