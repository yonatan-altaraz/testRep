package com.example.myapplication;

import android.graphics.Rect;
import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

final class DelegateLoop extends AccessibilityDelegate {
    // The View instance on which this class performs accessibility functions.
    private final PieChart view;

    DelegateLoop(PieChart view) {
        this.view = view;
    }

    @Override
    public AccessibilityNodeProvider getAccessibilityNodeProvider(final View host) {
        return new AccessibilityNodeProvider() {
            @Override
            public AccessibilityNodeInfo createAccessibilityNodeInfo(int virtualViewId) {
                if (virtualViewId == host.getId()) {
                    AccessibilityNodeInfo node = AccessibilityNodeInfo.obtain(view);
                    node.addChild(view, 33);
                    node.addChild(view, 44);
                    // Set other attributes like screenReaderFocusable and contentDescription.
                    return node;
                } else if (virtualViewId == 33 || virtualViewId == 44) {
                    AccessibilityNodeInfo node =
                            AccessibilityNodeInfo.obtain(view, virtualViewId);
                    node.setParent(view);
                    node.setText(virtualViewId == 1 ? "English" : "Hebrew");
                    // Set other attributes like focusable and visibleToUser.
                    node.setBoundsInScreen(
                            new Rect(2,2,2,2));
                    return node;
                } else {
                    return null;
                }
            }
        };
    }
}
