package com.example.myapplication;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

final class DelegateThing extends AccessibilityDelegate {
    // The View instance on which this class performs accessibility functions.
    private final PieChart view;

    DelegateThing(PieChart view) {
        this.view = view;
    }

    @Override
    public AccessibilityNodeProvider getAccessibilityNodeProvider(final View host) {
        return new AccessibilityNodeProvider() {
            @Override
            public AccessibilityNodeInfo createAccessibilityNodeInfo(int virtualViewId) {
                if (virtualViewId == HOST_VIEW_ID) {
                    AccessibilityNodeInfo node = AccessibilityNodeInfo.obtain(view);
//                    node.addChild(view, 33);
//                    node.addChild(view, 44);
                    // Set other attributes like screenReaderFocusable and contentDescription.
                    return node;
                } else if (virtualViewId == 33 || virtualViewId == 44) {
                    AccessibilityNodeInfo node =
                            AccessibilityNodeInfo.obtain(view, virtualViewId);
                    node.setParent(view);
                    node.setText(virtualViewId == 1 ? "English" : "Hebrew");
                    // Set other attributes like focusable and visibleToUser.
                    node.setBoundsInScreen(
                            new Rect(200,200,200,200));
                    return node;
                } else {
                    return null;
                }
            }
//            @Override
//            public boolean performAction(int virtualViewId, int action, Bundle arguments) {
//                if (virtualViewId == HOST_VIEW_ID) {
//                    return view.performAccessibilityAction(action, arguments);
//                }
//                else{
//                    return false;
//                }
//            }
        };
    }
}
