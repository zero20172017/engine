// Copyright 2013 The Flutter Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package io.flutter.embedding.engine.plugins.broadcastreceiver;

import android.arch.lifecycle.Lifecycle;
import android.content.BroadcastReceiver;
import android.support.annotation.NonNull;

/**
 * Control surface through which a {@link BroadcastReceiver} attaches to a {@link FlutterEngine}.
 *
 * <p>A {@link BroadcastReceiver} that contains a {@link FlutterEngine} should coordinate itself
 * with the {@link FlutterEngine}'s {@code BroadcastReceiverControlSurface}.
 */
public interface BroadcastReceiverControlSurface {
  /**
   * Call this method from the {@link BroadcastReceiver} that is running the {@link FlutterEngine}
   * that is associated with this {@code BroadcastReceiverControlSurface}.
   *
   * <p>Once a {@link BroadcastReceiver} is created, and its associated {@link FlutterEngine} is
   * executing Dart code, the {@link BroadcastReceiver} should invoke this method. At that point the
   * {@link FlutterEngine} is considered "attached" to the {@link BroadcastReceiver} and all {@link
   * BroadcastReceiverAware} plugins are given access to the {@link BroadcastReceiver}.
   */
  void attachToBroadcastReceiver(
      @NonNull BroadcastReceiver broadcastReceiver, @NonNull Lifecycle lifecycle);

  /**
   * Call this method from the {@link BroadcastReceiver} that is attached to this {@code
   * BroadcastReceiverControlSurfaces}'s {@link FlutterEngine} when the {@link BroadcastReceiver} is
   * about to be destroyed.
   *
   * <p>This method gives each {@link BroadcastReceiverAware} plugin an opportunity to clean up its
   * references before the {@link BroadcastReceiver is destroyed}.
   */
  void detachFromBroadcastReceiver();
}
