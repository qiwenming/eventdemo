package com.qwm.eventdemo.touchdelegatedemo;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/**
 * <b>Project:</b> eventdemo<br>
 * <b>Create Date:</b> 2017/4/21<br>
 * <b>Author:</b> qiwenming<br>
 * <b>Description:</b> <br>
 */
public class rrr {

    public class TouchDelegate {

        /**
         * View that should receive forwarded touch events
         * 代理的view
         */
        private View mDelegateView;

        /**
         * Bounds in local coordinates of the containing view that should be mapped to the delegate
         * view. This rect is used for initial hit testing.
         * 触摸区域
         */
        private Rect mBounds;

        /**
         * mBounds inflated to include some slop. This rect is to track whether the motion events
         * should be considered to be be within the delegate view.
         * 移动时候触摸区域，包含了误差
         */
        private Rect mSlopBounds;

        /**
         * True if the delegate had been targeted on a down event (intersected mBounds).
         * 标记 down 事件，是否落在了触摸区域内
         */
        private boolean mDelegateTargeted;

        /**
         * The touchable region of the View extends above its actual extent.
         */
        public static final int ABOVE = 1;

        /**
         * The touchable region of the View extends below its actual extent.
         */
        public static final int BELOW = 2;

        /**
         * The touchable region of the View extends to the left of its
         * actual extent.
         */
        public static final int TO_LEFT = 4;

        /**
         * The touchable region of the View extends to the right of its
         * actual extent.
         */
        public static final int TO_RIGHT = 8;

        private int mSlop;

        /**
         * Constructor
         *
         * @param bounds Bounds in local coordinates of the containing view that should be mapped to
         *        the delegate view
         * @param delegateView The view that should receive motion events
         */
        public TouchDelegate(Rect bounds, View delegateView) {
            mBounds = bounds;
            //获取相对的触摸区域的误差值（就是在这个超过原来的触摸区域，只要超出值小于等于这个值，都算在触摸区域内）
            mSlop = ViewConfiguration.get(delegateView.getContext()).getScaledTouchSlop();
            mSlopBounds = new Rect(bounds);
            mSlopBounds.inset(-mSlop, -mSlop);
            mDelegateView = delegateView;
        }

        /**
         * Will forward touch events to the delegate view if the event is within the bounds
         * specified in the constructor.
         *
         * @param event The touch event to forward
         * @return True if the event was forwarded to the delegate, false otherwise.
         */
        public boolean onTouchEvent(MotionEvent event) {
            int x = (int)event.getX();
            int y = (int)event.getY();
            boolean sendToDelegate = false;
            boolean hit = true;
            boolean handled = false;

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    Rect bounds = mBounds;
                    //判断这个区域包含不包含这个点
                    if (bounds.contains(x, y)) {
                        mDelegateTargeted = true;
                        sendToDelegate = true;
                    }
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_MOVE:
                    sendToDelegate = mDelegateTargeted;
                    if (sendToDelegate) {
                        Rect slopBounds = mSlopBounds;
                        //判断移动的点是否超出了范围
                        if (!slopBounds.contains(x, y)) {
                            hit = false;
                        }
                    }
                    break;
                case MotionEvent.ACTION_CANCEL:
                    sendToDelegate = mDelegateTargeted;
                    mDelegateTargeted = false;
                    break;
            }
            if (sendToDelegate) {
                final View delegateView = mDelegateView;
                //判断移动的点是否没有超出了我们的范围
                if (hit) {
                    // Offset event coordinates to be inside the target view
                    //没有超出，重新设置触摸的点，以确保我们下面调用代理的view的分发方法时，控件能够判断点是落在它上面的
                    event.setLocation(delegateView.getWidth() / 2, delegateView.getHeight() / 2);
                } else {
                    // Offset event coordinates to be outside the target view (in case it does
                    // something like tracking pressed state)
                    int slop = mSlop;
                    //超出了，重新设置触摸的点，保证控件能判断点不是落在它上面
                    event.setLocation(-(slop * 2), -(slop * 2));
                }
                handled = delegateView.dispatchTouchEvent(event);
            }
            return handled;
        }
    }


}
