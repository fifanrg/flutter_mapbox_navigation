package com.eopeter.flutter_mapbox_navigation.views

import android.app.Activity
import android.view.View
import android.content.Context
import android.util.Log

import com.eopeter.flutter_mapbox_navigation.TurnByTurn
import eopeter.flutter_mapbox_navigation.databinding.NavigationActivityBinding
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.EventChannel
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.platform.PlatformView


class EmbeddedNavigationMapView(context: Context, activity: Activity, binding: NavigationActivityBinding, binaryMessenger: BinaryMessenger, vId: Int, args: Any?, accessToken: String)
    : PlatformView, TurnByTurn(context, activity, binding, accessToken) {
    private val viewId: Int = vId
    private val messenger: BinaryMessenger = binaryMessenger
    private val args = args
    override fun initFlutterChannelHandlers() {
        methodChannel = MethodChannel(messenger, "flutter_mapbox_navigation/${viewId}")
        eventChannel = EventChannel(messenger, "flutter_mapbox_navigation/${viewId}/events")
        ///TODO set initial argument properly when initalising navigation
        val arguments = args as? Map<*, *>
        if(arguments != null) {
            initialLatitude = arguments["initialLatitude"] as? Double
            initialLongitude = arguments["initialLongitude"] as? Double
        }
        super.initFlutterChannelHandlers()
    }

    /// For some reason onFlutterViewAttached is not called
    override fun onFlutterViewAttached(flutterView: View) {
        super.onFlutterViewAttached(flutterView)
        initFlutterChannelHandlers()
        initNavigation()
    }

    override fun getView(): View {
        val view: View = binding.root;
        return view;
    }

    override fun dispose() {
        unregisterObservers();
        onDestroy();
    }

}