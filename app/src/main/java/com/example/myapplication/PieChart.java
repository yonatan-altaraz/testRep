package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.graphics.Rect;

public class PieChart extends View {
    public PieChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setAccessibilityDelegate(new DelegateThing(this));
    }
    @Override
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
       return super.getAccessibilityNodeProvider();
    }

//    @Override
//    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
//        return new AccessibilityNodeProvider() {
//            @Override
//            public AccessibilityNodeInfo createAccessibilityNodeInfo(int virtualViewId) {
//                if (virtualViewId == -1 ) {
//
//                    PieChart pie = PieChart.this.findViewById(R.id.parent);
//                    PieChart kof = PieChart.this.findViewById(R.id.view_offset_helper);
//
//                    AccessibilityNodeInfo node = AccessibilityNodeInfo.obtain(PieChart.this);
//                    node.addChild(PieChart.this, 33);
//                    node.addChild(PieChart.this, 44);
//                    node.setVisibleToUser(true);
//                    node.setBoundsInScreen(
//                            new Rect(2,2,2,2));
//                    // Set other attributes like screenReaderFocusable and contentDescription.
//                    return node;
//                } else if (virtualViewId == 33 || virtualViewId == 44) {
//                    AccessibilityNodeInfo node =
//                            AccessibilityNodeInfo.obtain(PieChart.this, virtualViewId);
//                    node.setParent(PieChart.this);
//                    node.setText(virtualViewId == 1 ? "English" : "Hebrew");
//                    node.setVisibleToUser(true);
//                    // Set other attributes like focusable and visibleToUser.
//                    node.setBoundsInScreen(
//                            new Rect(2,2,2,2));
//                    return node;
//                } else {
//                   return null;
//                }
//            }
//        };
//    }
}
