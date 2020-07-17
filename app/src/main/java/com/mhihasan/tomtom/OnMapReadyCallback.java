package com.mhihasan.tomtom;

import androidx.annotation.NonNull;

import com.tomtom.online.sdk.map.TomtomMap;

/**
 * Callback interface executed when the map is ready to be used.
 * The instance of this interface is set to MapFragment,
 * and the {@link OnMapReadyCallback#onMapReady(TomtomMap)} is triggered
 * when the map is fully initialized and not-null.
 */
public interface OnMapReadyCallback extends com.tomtom.online.sdk.map.OnMapReadyCallback {
    /**
     * Called when the map is ready to be used.
     */
    void onMapReady(@NonNull TomtomMap tomtomMap);
}